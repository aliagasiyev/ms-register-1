package az.edu.msregister.entity;

import az.edu.msregister.enums.Job;
import az.edu.msregister.enums.SocialMedia;
import az.edu.msregister.enums.AttendanceStatus;
import az.edu.msregister.enums.AttendanceGrade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffEntity extends UserEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job;

    @Column
    private String bio;

    @Column
    private String picture;

    @ElementCollection
    @CollectionTable(name = "staff_social_media", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "social_media")
    @Enumerated(EnumType.STRING)
    private List<SocialMedia> socialMediaLinks;

    @Column
    private String activityPosts;

    @ElementCollection
    @CollectionTable(name = "staff_attendance", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "attendance_status")
    @Enumerated(EnumType.STRING)
    private List<AttendanceStatus> attendanceStatuses;

    @ElementCollection
    @CollectionTable(name = "staff_grades", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "attendance_grade")
    @Enumerated(EnumType.STRING)
    private List<AttendanceGrade> attendanceGrades;
}
