package az.edu.msregister.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SuperAdminRequest extends UserRequest {

    @NotBlank(message = "Default username is mandatory")
    private String defaultUsername;

    @NotBlank(message = "Default password is mandatory")
    private String defaultPassword;

    private boolean initialStatus;
}
