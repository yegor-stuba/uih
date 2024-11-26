package sv.library.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.library.backend.entity.User;
import sv.library.backend.repository.UserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDatabaseConnectionAndEntityMapping() {
        // Clear existing records
        userRepository.deleteAll();

        // Create and save a user
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("secure_password");
        user.setRole("USER");
        userRepository.save(user);

        // Verify user in database
        List<User> users = userRepository.findAll();
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getUsername()).isEqualTo("test_user");
    }
}
