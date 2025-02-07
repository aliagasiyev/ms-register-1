package az.edu.msregister.entity;

import az.edu.msregister.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity extends UserEntity {

    @ElementCollection
    @CollectionTable(name = "teacher_universities", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "university")
    @Enumerated(EnumType.STRING)
    private List<University> universities;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job;

    @Column
    private String bio;

    @Column
    private String picture;

    @ElementCollection
    @CollectionTable(name = "teacher_social_media", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "social_media")
    @Enumerated(EnumType.STRING)
    private List<SocialMedia> socialMediaLinks;

    @Column
    private String activityPosts;

    @ElementCollection
    @CollectionTable(name = "teacher_attendance", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "attendance_status")
    @Enumerated(EnumType.STRING)
    private List<AttendanceStatus> attendanceStatuses;

    @ElementCollection
    @CollectionTable(name = "teacher_grades", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "attendance_grade")
    @Enumerated(EnumType.STRING)
    private List<AttendanceGrade> attendanceGrades;
}
