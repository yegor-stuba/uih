package sv.library.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.library.backend.entity.Transaction;
import sv.library.backend.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction borrowBook(@RequestBody Transaction transaction) {
        return transactionService.borrowBook(transaction);
    }

    @PutMapping("/{id}")
    public Transaction returnBook(@PathVariable Long id) {
        return transactionService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public void cancelTransaction(@PathVariable Long id) {
        transactionService.cancelTransaction(id);
    }
}
