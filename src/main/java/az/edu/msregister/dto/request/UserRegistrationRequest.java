package az.edu.msregister.dto.request;

import az.edu.msregister.enums.SpecializationType;
import az.edu.msregister.enums.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

    private String name;
    private String surname;
    private String fin;
    private String email;

    private SpecializationType specialization;
    private String courseEmail;
    private String phoneNumber;
    private String password;
    private UserRole role;
}
