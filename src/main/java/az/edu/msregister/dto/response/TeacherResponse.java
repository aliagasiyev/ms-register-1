package az.edu.msregister.dto.response;

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
    private List<String> universities;
    private String job;
    private String bio;
    private String picture;
    private List<String> socialMediaLinks;
    private String activityPosts;
    private List<String> attendanceStatuses;
    private List<Integer> attendanceGrades;
}








