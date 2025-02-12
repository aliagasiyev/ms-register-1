package az.edu.msregister.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(nullable = false)
    private String job;

    @Column
    private String bio;

    @Column
    private String picture;

    @Column(name = "social_media")
    private String socialMediaLinks;

    @Column
    private String activityPosts;

    @Column(name = "attendance_status", columnDefinition = "TEXT")
    private String attendanceStatus;

    @Column(name = "attendance_grade", columnDefinition = "TEXT")
    private Integer attendanceGrade;

    public void setUser(UserEntity user) {
        this.userEntity = user;
    }
}