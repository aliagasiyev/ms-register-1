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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Override
    public UserResponse registerUser(UserRegistrationRequest request) {
        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        //  Encrypt password before saving
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .fin(request.getFin())
                .email(request.getEmail())
                .specialization(request.getSpecialization())
                .personalEmail(request.getPersonalEmail())
                .courseEmail(request.getCourseEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(encodedPassword) // Store hashed password
                .role(request.getRole())
                .build();

        userRepository.save(user);
        return UserMapper.INSTANCE.toResponse(user);
    }

    @Override
    public List getUsersByRole(UserRole role) {
        return userRepository.findByRole(role).stream()
                .map(UserMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().
                stream().map(UserMapper.INSTANCE::toResponse).
                collect(Collectors.toList());
    }

}