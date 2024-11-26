package sv.library.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.library.backend.entity.User;
import sv.library.backend.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");

        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());
        assertEquals("john_doe", savedUser.getUsername());
    }

    // Add more tests for find, update, delete operations...
}
