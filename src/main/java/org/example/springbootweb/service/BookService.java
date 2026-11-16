package org.example.springbootweb.service;

import java.util.List;
import org.example.springbootweb.dto.BookDto;
import org.example.springbootweb.dto.BookSearchParametersDto;
import org.example.springbootweb.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    List<BookDto> searchBooks(BookSearchParametersDto searchParameters);

    BookDto createBook(CreateBookRequestDto bookDto);

    Page<BookDto> getAll(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto updateBook(Long id, CreateBookRequestDto bookDto);

    void deleteBook(Long id);
}
