package az.edu.msregister.service.impl;

import az.edu.msregister.config.RoleBasedAccessConfig;
import az.edu.msregister.dto.request.UserRegistrationRequest;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
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
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        UserRole creatorRole = creator.getRole();
        UserRole newUserRole = request.getRole();

        // Check role-based access
        if (!RoleBasedAccessConfig.getPermissions(creatorRole).getCanCreate().contains(newUserRole)) {
            throw new RuntimeException(creatorRole + " is not allowed to create " + newUserRole);
        }

        // Create and save the new user
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .specialization(request.getSpecialization())
                .personalEmail(request.getPersonalEmail())
                .courseEmail(request.getCourseEmail())
                .password(encodedPassword)
                .role(newUserRole)
                .build();

        userRepository.save(user);
        return UserMapper.INSTANCE.toResponse(user);
    }

    @Override
    public void deleteUser(Long userId, String requestorEmail) {
        // Check if the requestor exists
        UserEntity requestor = userRepository.findByEmail(requestorEmail)
                .orElseThrow(() -> new RuntimeException("Requestor not found"));

        // Retrieve the user to delete
        UserEntity userToDelete = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserRole requestorRole = requestor.getRole();
        UserRole userRole = userToDelete.getRole();

        // Check if the requestor has permission to delete the user
        if (!RoleBasedAccessConfig.getPermissions(requestorRole).getCanDelete().contains(userRole)) {
            throw new RuntimeException(requestorRole + " is not allowed to delete " + userRole);
        }

        // Perform the deletion
        userRepository.delete(userToDelete);
    }

    @Override
    public List<UserResponse> getUsersByRole(UserRole role) {
        return userRepository.findByRole(role).stream()
                .map(UserMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }
}
