package com.book.book.service;

import com.book.book.DTO.bookDTO;
import com.book.book.Modal.book;
import com.book.book.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class bookService {

    @Autowired
    private bookRepository bookRepository;

    // Save a new book
    public book saveBook(book bookEntity) {
        return bookRepository.save(bookEntity);
    }

    // Get all books as DTOs (only id and name)
    public List<bookDTO> getAllBooksDTO() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get book by ID as DTO (only id and name)
    public Optional<bookDTO> getBookDTOById(Integer id) {
        Optional<book> bookEntity = bookRepository.findById(id);
        return bookEntity.map(this::convertToDTO);
    }

    // Check if book exists by ID
    public boolean bookExists(Integer id) {
        return bookRepository.existsById(id);
    }

    // Update book by ID
    public Optional<book> updateBook(Integer id, book updatedBookData) {
        Optional<book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            book bookToUpdate = existingBook.get();

            // Update fields
            bookToUpdate.setBook_name(updatedBookData.getBook_name());
            bookToUpdate.setBook_Author(updatedBookData.getBook_Author());
            bookToUpdate.setBook_summary(updatedBookData.getBook_summary());

            // Save the updated book
            book savedBook = bookRepository.save(bookToUpdate);
            return Optional.of(savedBook);
        }
        return Optional.empty();
    }

    // Delete book by ID
    public boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Helper method to convert book entity to bookDTO
    private bookDTO convertToDTO(book bookEntity) {
        return new bookDTO(bookEntity.getBook_id(), bookEntity.getBook_name());
    }
}