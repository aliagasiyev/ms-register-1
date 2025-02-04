package az.edu.msregister.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentRequest extends UserRequest {

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
