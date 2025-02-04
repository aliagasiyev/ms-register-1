package az.edu.msregister.dto.response;

import az.edu.msregister.enums.UserRole;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String specialization;
    private String personalEmail;
    private String courseEmail;
    private String phoneNumber;
    private String password;
    private UserRole role;
}
