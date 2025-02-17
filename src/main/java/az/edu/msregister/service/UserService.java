package az.edu.msregister.service;

import az.edu.msregister.dto.request.UserRegistrationRequest;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.enums.UserRole;

import java.util.List;

public interface UserService {
    UserResponse registerUser(UserRegistrationRequest user, String creatorEmail);

    List<UserResponse> getUsersByRole(UserRole role);

    List<UserResponse> getAllUsers();

    void deleteUser(Long userId, String requestEmail);
}
