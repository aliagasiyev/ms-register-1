package az.edu.msregister.service;

import az.edu.msregister.dto.request.UserRegistrationRequest;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse registerUser(UserRegistrationRequest user);
    List<UserResponse> getUsersByRole(UserRole role);
    List<UserResponse> getAllUsers();
}
