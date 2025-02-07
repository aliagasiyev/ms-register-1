package az.edu.msregister.dto.request;
import az.edu.msregister.enums.Job;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherRequest extends UserRegistrationRequest {
    private List universities;
    private Job job;
    private String bio;
    private String picture;
    private List socialMediaLinks;
    private String activityPosts;
    private List attendanceStatuses;
    private List attendanceGrades;
}
