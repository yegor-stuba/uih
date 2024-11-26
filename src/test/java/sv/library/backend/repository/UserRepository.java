package sv.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.library.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries (if any) can be added here
}
