package az.edu.msregister.dto.response;

import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.enums.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TeacherResponse extends UserResponse {
    private List universities;
    private Job job;
    private String bio;
    private String picture;
    private List socialMediaLinks;
    private String activityPosts;
    private List attendanceStatuses;
    private List attendanceGrades;
}








