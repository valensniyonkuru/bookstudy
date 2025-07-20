package com.book.book.Repository;

import com.book.book.Modal.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository <book,Integer> {
}
