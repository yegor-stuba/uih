package sv.library.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.library.backend.entity.Transaction;
import sv.library.backend.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Record a new transaction (borrow or lend)
    public Transaction recordTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Find transactions by user ID
    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    // Find transactions by book ID
    public List<Transaction> findByBookId(Long bookId) {
        return transactionRepository.findByBookId(bookId);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction borrowBook(Transaction transaction) {
        // Add business logic for borrowing a book
        return transactionRepository.save(transaction);
    }

    public Transaction returnBook(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        // Update the status of the transaction or handle book return logic
        transaction.setStatus("Returned");
        return transactionRepository.save(transaction);
    }

    public void cancelTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactionRepository.delete(transaction);
    }

}
