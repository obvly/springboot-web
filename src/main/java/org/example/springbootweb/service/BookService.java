package org.example.springbootweb.service;

import java.util.List;
import org.example.springbootweb.dto.BookDto;
import org.example.springbootweb.dto.CreateBookRequestDto;

public interface BookService {
    BookDto createBook(CreateBookRequestDto bookDto);

    List<BookDto> getAll();

    BookDto getBookById(Long id);
}
