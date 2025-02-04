package az.edu.msregister.dto.request;
import az.edu.msregister.enums.UserRole;
import lombok.*;


@Getter
@Setter
@Builder
public class UserRegistrationRequest {

    private String name;
    private String surname;
    private String fin;
    private String email;
    private String specialization;
    private String personalEmail;
    private String courseEmail;
    private String phoneNumber;
    private String password;
    private UserRole role;
}
