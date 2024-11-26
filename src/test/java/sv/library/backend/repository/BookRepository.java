package sv.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.library.backend.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom queries (if any) can be added here
}
