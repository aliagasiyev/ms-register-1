package az.edu.msregister.entity;

import az.edu.msregister.enums.SpecializationType;
import az.edu.msregister.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String fin;
    private String email;

    @Enumerated(EnumType.STRING)
    private SpecializationType specialization;

    private String courseEmail;
    private String phoneNumber;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
