package sv.library.backend.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sv.library.backend.repository.BookRepository;
import sv.library.backend.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EntityTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testUserEntity() {
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("secure_password");
        user.setRole("USER");
        userRepository.save(user);

        assertThat(userRepository.findAll()).isNotEmpty();
        assertThat(userRepository.findAll().get(0).getUsername()).isEqualTo("test_user");
    }

    @Test
    public void testBookEntity() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setOwner("test_user");
        book.setStatus("Available");
        bookRepository.save(book);

        assertThat(bookRepository.findAll()).isNotEmpty();
        assertThat(bookRepository.findAll().get(0).getTitle()).isEqualTo("Test Book");
    }
}
