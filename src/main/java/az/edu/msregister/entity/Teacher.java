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
public class Teacher extends UserEntity {

    @NotBlank(message = "Teaching profile is mandatory")
    private String teachingProfile;

    @NotBlank(message = "Specialization is mandatory")
    private String specialization;

    @NotBlank(message = "Courses are mandatory")
    private String courses;

    private String cv;
    private String photo;
}
