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
public class Student extends UserEntity {

    @NotBlank(message = "University profile is mandatory")
    private String universityProfile;

    @NotBlank(message = "Payment status is mandatory")
    private String paymentStatus;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotBlank(message = "Group is mandatory")
    private String group;

    private String bio;
    private String photo;
    private String socialMedia;
    private String activity;

}
