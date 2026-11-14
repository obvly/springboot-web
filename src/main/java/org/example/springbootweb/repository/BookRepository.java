package org.example.springbootweb.repository;

import java.util.List;
import org.example.springbootweb.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}
