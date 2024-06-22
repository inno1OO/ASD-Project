package tech.inno100.tryjesusapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.inno100.tryjesusapp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
