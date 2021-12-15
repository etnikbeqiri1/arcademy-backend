package arcademy.modules.authentication.repositories;

import arcademy.modules.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByToken(String token);
}