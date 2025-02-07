package az.edu.msregister.repository;

import az.edu.msregister.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
}
