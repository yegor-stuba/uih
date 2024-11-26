package sv.library.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.library.backend.entity.Book;
import sv.library.backend.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book to the library
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }


    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        // Set other properties from bookDetails

        return bookRepository.save(existingBook);
    }


    // Delete a book from the library
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    // Find a book by title
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Find books by author
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
