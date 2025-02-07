package az.edu.msregister.dto.response;

import az.edu.msregister.enums.Job;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffResponse extends UserResponse {
    private Job job;
    private String bio;
    private String picture;
    private List socialMediaLinks;
    private String activityPosts;
    private List attendanceStatuses;
    private List attendanceGrades;
}