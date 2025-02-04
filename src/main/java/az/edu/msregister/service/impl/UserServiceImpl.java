package az.edu.msregister.service.impl;

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
    private final PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Override
    public UserResponse registerUser(UserRegistrationRequest request, String creatorEmail) {
        // Fetch the creator (who is making this request)
        UserEntity creator = userRepository.findByEmail(creatorEmail)
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        // Validation rules: Only SUPER_ADMIN or STAFF can create users.
        if (request.getRole() == UserRole.SUPER_ADMIN) {
            throw new RuntimeException("SUPER_ADMIN can only be created manually.");
        }

        if (creator.getRole() == UserRole.STAFF && request.getRole() == UserRole.SUPER_ADMIN) {
            throw new RuntimeException("STAFF cannot create SUPER_ADMIN.");
        }

        if (creator.getRole() == UserRole.STAFF && request.getRole() == UserRole.STAFF) {
            throw new RuntimeException("Only SUPER_ADMIN can create STAFF users.");
        }

        // Encrypt password before saving
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(encodedPassword)
                .role(request.getRole())
                .build();

        userRepository.save(user);
        return UserMapper.INSTANCE.toResponse(user);
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
