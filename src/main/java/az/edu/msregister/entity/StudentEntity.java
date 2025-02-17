package az.edu.msregister.entity;

import az.edu.msregister.enums.PaymentType;
import az.edu.msregister.enums.SocialMediaPlatform;
import az.edu.msregister.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "studentBuilder")
public class StudentEntity {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentStatus status;

    @Column(name = "universities")
    private String universities;

    @Column(name = "work_experiences")
    private String workExperiences;

    @Column(name = "study_specialization", nullable = false)
    private String studySpecialization;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentDetails;

    @Column(name = "student_group")
    private String group;

    @Column(name = "attendance_status", columnDefinition = "TEXT")
    private String attendanceStatus;

    @Column(name = "grades", columnDefinition = "TEXT")
    private String grades;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_media_platform")
    private SocialMediaPlatform socialMediaPlatform;

    @Column(name = "social_media_link")
    private String socialMediaLink;

    @Column(name = "activity_posts")
    private String activityPosts;
}
