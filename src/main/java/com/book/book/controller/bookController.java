package com.book.book.controller;

import com.book.book.DTO.bookDTO;
import com.book.book.Modal.book;
import com.book.book.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class bookController {

    @Autowired
    private bookService bookService;

    // Save a new book - accepts full book JSON
    @PostMapping
    public ResponseEntity<book> saveBook(@RequestBody book bookEntity) {
        book savedBook = bookService.saveBook(bookEntity);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Get all books as DTOs (only id and name)
    @GetMapping
    public ResponseEntity<List<bookDTO>> getAllBooks() {
        List<bookDTO> books = bookService.getAllBooksDTO();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get book by ID (returns only id and name as DTO)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        if (!bookService.bookExists(id)) {
            return new ResponseEntity<>("Book with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }

        Optional<bookDTO> book = bookService.getBookDTOById(id);
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    // Update book by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody book bookEntity) {
        if (!bookService.bookExists(id)) {
            return new ResponseEntity<>("Book with ID " + id + " not found. Cannot update non-existing book.", HttpStatus.NOT_FOUND);
        }

        Optional<book> updatedBook = bookService.updateBook(id, bookEntity);
        return new ResponseEntity<>(updatedBook.get(), HttpStatus.OK);
    }

    // Delete book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        if (!bookService.bookExists(id)) {
            return new ResponseEntity<>("Book with ID " + id + " not found. Cannot delete non-existing book.", HttpStatus.NOT_FOUND);
        }

        boolean deleted = bookService.deleteBook(id);
        return new ResponseEntity<>("Book with ID " + id + " deleted successfully", HttpStatus.OK);
    }
}