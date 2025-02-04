package az.edu.msregister.controller;

import az.edu.msregister.dto.request.UserRegistrationRequest;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.enums.UserRole;
import az.edu.msregister.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    /**
     * Registers a new user.
     * Only SUPER_ADMIN and STAFF can create users.
     */
    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'STAFF')")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRegistrationRequest request, Authentication authentication) {
        String creatorEmail = authentication.getName();
        return ResponseEntity.ok(userService.registerUser(request, creatorEmail));
    }

    /**
     * Retrieves users by role.
     * Only SUPER_ADMIN can access this.
     */
    @GetMapping("/role/{role}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<List<UserResponse>> getUsersByRole(@PathVariable UserRole role) {
        return ResponseEntity.ok(userService.getUsersByRole(role));
    }


    /**
     * Retrieves all users.
     * Only SUPER_ADMIN can access this.
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
