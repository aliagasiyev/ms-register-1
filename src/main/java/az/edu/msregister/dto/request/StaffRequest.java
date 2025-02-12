package az.edu.msregister.dto.request;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffRequest extends UserRegistrationRequest {
    private String job;
    private String bio;
    private String picture;
    private String socialMediaLinks;
    private String activityPosts;
    private String attendanceStatus;
    private Integer attendanceGrade;
}

