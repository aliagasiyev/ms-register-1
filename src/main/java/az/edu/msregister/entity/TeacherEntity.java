package az.edu.msregister.entity;

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
    private List<String> universities;

    @Column(nullable = false)
    private String job;

    @Column
    private String bio;

    @Column
    private String picture;

    @ElementCollection
    @CollectionTable(name = "teacher_social_media", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "social_media")
    private List<String> socialMediaLinks;

    @Column
    private String activityPosts;

    @ElementCollection
    @CollectionTable(name = "teacher_attendance", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "attendance_status")
    private List<String> attendanceStatuses;

    @ElementCollection
    @CollectionTable(name = "teacher_grades", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "attendance_grade")
    private List<Integer> attendanceGrades;
}
