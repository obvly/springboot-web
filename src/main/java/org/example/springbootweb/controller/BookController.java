package org.example.springbootweb.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootweb.dto.BookDto;
import org.example.springbootweb.dto.CreateBookRequestDto;
import org.example.springbootweb.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Add status 201
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        return bookService.createBook(bookDto);
    }
}

