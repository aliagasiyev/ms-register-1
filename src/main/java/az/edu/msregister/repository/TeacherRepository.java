package az.edu.msregister.repository;

import az.edu.msregister.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
}
