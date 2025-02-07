package az.edu.msregister.entity;

import az.edu.msregister.enums.SpecializationType;
import az.edu.msregister.enums.SocialMedia;
import az.edu.msregister.enums.AttendanceStatus;
import az.edu.msregister.enums.AttendanceGrade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends UserEntity {

    @Column
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpecializationType specialization;

    @Column
    private String group;

    @ElementCollection
    @CollectionTable(name = "student_attendance", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "attendance_status")
    @Enumerated(EnumType.STRING)
    private List<AttendanceStatus> attendanceStatuses;

    @ElementCollection
    @CollectionTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "attendance_grade")
    @Enumerated(EnumType.STRING)
    private List<AttendanceGrade> attendanceGrades;

    @ElementCollection
    @CollectionTable(name = "student_social_media", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "social_media")
    @Enumerated(EnumType.STRING)
    private List<SocialMedia> socialMediaLinks;

    @Column
    private String bio;

    @Column
    private String picture;

    @Column
    private String activityPosts;
}
