package az.edu.msregister.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherRequest extends UserRequest {

    @NotBlank(message = "Teaching profile is mandatory")
    private String teachingProfile;

    @NotBlank(message = "Specialization is mandatory")
    private String specialization;

    @NotBlank(message = "Courses are mandatory")
    private String courses;

    private String cv;
    private String photo;
}
