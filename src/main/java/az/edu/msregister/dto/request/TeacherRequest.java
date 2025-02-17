package az.edu.msregister.dto.request;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.TeachingSubjectType;
import az.edu.msregister.enums.SocialMediaPlatform;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest extends UserRegistrationRequest {

    private String universities;
    private String workExperiences;
    private TeachingSubjectType teachingSubjects;
    private PaymentType paymentDetails;
    private String bio;
    private String profilePicture;
    private SocialMediaPlatform socialMediaLinks;
    private String activityPosts;
}
