package az.edu.msregister.dto.request;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.SocialMediaPlatform;
import az.edu.msregister.enums.StudentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest extends UserRegistrationRequest {

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private StudentStatus status;

    private String universities;

    private String workExperiences;

    @NotBlank
    private String studySpecialization;

    @NotNull
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