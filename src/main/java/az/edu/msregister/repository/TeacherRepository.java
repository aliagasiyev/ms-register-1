package az.edu.msregister.repository;

import az.edu.msregister.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

    // Custom query to find Teacher by UserEntity's email
    @Query("SELECT t FROM TeacherEntity t JOIN t.user u WHERE u.email = :email")
    Optional<TeacherEntity> findByEmail(String email);
}
