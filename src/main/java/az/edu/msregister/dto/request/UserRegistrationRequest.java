package az.edu.msregister.dto.request;

import az.edu.msregister.enums.SpecializationType;
import az.edu.msregister.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Surname cannot be empty")
    private String surname;

    @NotBlank(message = "FIN code cannot be empty")
    @Size(min = 7, max = 7, message = "FIN code must be exactly 7 characters")
    private String fin;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull(message = "Specialization type must be selected")
    private SpecializationType specialization;

    @Email(message = "Please enter a valid course email")
    private String courseEmail;

    @NotBlank(message = "Phone number cannot be empty")
    @Size(min = 10, max = 13, message = "Phone number must be in the correct format")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "User role must be selected")
    private UserRole role;
}
