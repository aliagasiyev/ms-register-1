package az.edu.msregister.dto.response;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.SocialMediaPlatform;
import az.edu.msregister.enums.StudentStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse extends UserResponse {
    private LocalDate birthDate;
    private StudentStatus status;
    private String universities;
    private String workExperiences;
    private String studySpecialization;
    private PaymentType paymentDetails;
    private String group;
    private String attendanceStatus;
    private String grades;
    private String bio;
    private String profilePicture;
    private SocialMediaPlatform socialMediaPlatform;
    private String socialMediaLink;
    private String activityPosts;
}