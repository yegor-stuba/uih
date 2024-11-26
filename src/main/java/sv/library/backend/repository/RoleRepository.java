package sv.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.library.backend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Find role by name (e.g., "ADMIN" or "USER")
    Role findByName(String name);
}
