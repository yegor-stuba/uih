package sv.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.library.backend.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Find transactions by user
    List<Transaction> findByUserId(Long userId);

    // Find transactions by book
    List<Transaction> findByBookId(Long bookId);
}
