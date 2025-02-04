package az.edu.msregister.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SuperAdmin extends UserEntity {

    @NotBlank(message = "Default username is mandatory")
    private String defaultUsername;

    @NotBlank(message = "Default password is mandatory")
    private String defaultPassword;

    private boolean initialStatus;
}
