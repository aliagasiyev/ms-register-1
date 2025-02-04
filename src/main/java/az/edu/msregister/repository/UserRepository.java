package az.edu.msregister.repository;

import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByRole(UserRole role);



}
