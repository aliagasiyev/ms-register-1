package az.edu.msregister.dto.request;

import az.edu.msregister.enums.Job;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest extends UserRegistrationRequest {
    private String status;
    private String group;
    private List attendanceStatuses;
    private List attendanceGrades;
    private List socialMediaLinks;
    private String bio;
    private String picture;
    private String activityPosts;
}