package az.edu.msregister.repository;

import az.edu.msregister.entity.StaffEntity;
import az.edu.msregister.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
    boolean existsByUserEntity(UserEntity user);

    @Query("SELECT s FROM StaffEntity s WHERE s.userEntity = :user")
    Optional<StaffEntity> findByUserEntity(@Param("user") UserEntity userEntity);
}
