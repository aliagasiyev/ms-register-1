package az.edu.msregister.dto.response;

import az.edu.msregister.enums.SpecializationType;
import az.edu.msregister.enums.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String surname;
    private String fin;
    private String email;
    private SpecializationType specialization;
    private String courseEmail;
    private String phoneNumber;
    private UserRole role;
}
