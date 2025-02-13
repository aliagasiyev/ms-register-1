package az.edu.msregister.dto.response;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.TeachingSubjectType;
import az.edu.msregister.enums.SocialMediaPlatform;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse extends UserResponse {

    private String universities;
    private String workExperiences;
    private TeachingSubjectType teachingSubjects;
    private PaymentType paymentDetails;
    private String bio;
    private String profilePicture;
    private SocialMediaPlatform socialMediaLinks;
    private String activityPosts;
}
