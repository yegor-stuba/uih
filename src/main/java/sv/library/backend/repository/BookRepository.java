package sv.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.library.backend.entity.Book;
import java.util.List;  // <-- Add this import

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query method to find a book by title
    Book findByTitle(String title);

    // Custom query method to find books by author
    List<Book> findByAuthor(String author);
}
