package az.edu.msregister.repository;

import az.edu.msregister.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    // Custom query to find Student by UserEntity's email
    @Query("SELECT s FROM StudentEntity s JOIN s.user u WHERE u.email = :email")
    Optional<StudentEntity> findByEmail(String email);
}
