package az.edu.msregister.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "staffBuilder")
public class StaffEntity {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(nullable = false)
    private String job;

    @Column
    private String bio;

    @Column
    private String picture;

    @ElementCollection
    @CollectionTable(name = "staff_social_media", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "social_media")
    private List<String> socialMediaLinks;

    @Column
    private String activityPosts;

    @ElementCollection
    @CollectionTable(name = "staff_attendance", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "attendance_status")
    private List<String> attendanceStatus;

    @ElementCollection
    @CollectionTable(name = "staff_grades", joinColumns = @JoinColumn(name = "staff_id"))
    @Column(name = "attendance_grade")
    private List<String> attendanceGrade;

    public void setUser(UserEntity user) {
        this.userEntity = user;
    }
}