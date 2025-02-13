package az.edu.msregister.entity;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.TeachingSubjectType;
import az.edu.msregister.enums.SocialMediaPlatform;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "teacherBuilder")
public class TeacherEntity extends UserEntity {

    @Column(name = "universities")
    private String universities;

    @Column(name = "work_experiences")
    private String workExperiences;

    @Enumerated(EnumType.STRING)
    @Column(name = "teaching_subjects")
    private TeachingSubjectType teachingSubjects;

    @Embedded
    private PaymentType paymentDetails;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_media_links")
    private SocialMediaPlatform socialMediaLinks;

    @Column(name = "activity_posts")
    private String activityPosts;
}
