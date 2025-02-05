package az.edu.msregister.service.impl;

import az.edu.msregister.config.RoleBasedAccessConfig;
import az.edu.msregister.dto.request.UserRegistrationRequest;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
import az.edu.msregister.exceptions.*;
import az.edu.msregister.mapper.UserMapper;
import az.edu.msregister.repository.UserRepository;
import az.edu.msregister.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRegistrationRequest request, String creatorEmail) {
        UserEntity creator = userRepository.findByEmail(creatorEmail)
                .orElseThrow(() -> new UserNotFoundException("Creator not found"));

        UserRole creatorRole = creator.getRole();
        UserRole newUserRole = request.getRole();

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + request.getEmail() + " already exists");
        }

        if (!RoleBasedAccessConfig.getPermissions(creatorRole).getCanCreate().contains(newUserRole)) {
            throw new RolePermissionException(creatorRole + " is not allowed to create " + newUserRole);
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .fin(request.getFin())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .specialization(request.getSpecialization())
                .personalEmail(request.getPersonalEmail())
                .courseEmail(request.getCourseEmail())
                .password(encodedPassword)
                .role(newUserRole)
                .build();

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new DatabaseException("Error saving user to database: " + e.getMessage());
        }

        return UserMapper.INSTANCE.toResponse(user);
    }

    @Override
    public void deleteUser(Long userId, String requestorEmail) {
        UserEntity requestor = userRepository.findByEmail(requestorEmail)
                .orElseThrow(() -> new UserNotFoundException("Requestor not found"));

        UserEntity userToDelete = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        UserRole requestorRole = requestor.getRole();
        UserRole userRole = userToDelete.getRole();

        if (!RoleBasedAccessConfig.getPermissions(requestorRole).getCanDelete().contains(userRole)) {
            throw new RolePermissionException(requestorRole + " is not allowed to delete " + userRole);
        }

        try {
            userRepository.delete(userToDelete);
        } catch (Exception e) {
            throw new DatabaseException("Error deleting user from database: " + e.getMessage());
        }
    }

    @Override
    public List<UserResponse> getUsersByRole(UserRole role) {
        return userRepository.findByRole(role)
                .map(user -> List.of(UserMapper.INSTANCE.toResponse(user)))
                .orElseThrow(() -> new RoleNotFoundException("No users found with role " + role));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }
}
