package org.example.springbootweb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springbootweb.dto.BookDto;
import org.example.springbootweb.dto.BookSearchParametersDto;
import org.example.springbootweb.dto.CreateBookRequestDto;
import org.example.springbootweb.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Books", description = "Book management endpoints")
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/search")
    public List<BookDto> searchBooks(
            @ModelAttribute BookSearchParametersDto searchParameters) {
        return bookService.searchBooks(searchParameters);
    }

    @Operation(summary = "Get all books")
    @ApiResponse(responseCode = "200", description = "Books obtained successfully")
    @GetMapping
    public Page<BookDto> getAll(Pageable pageable) {
        return bookService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID")
    @ApiResponse(responseCode = "200", description = "Book found")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new book")
    @ApiResponse(responseCode = "201", description = "Book created")
    @ApiResponse(responseCode = "400", description = "Invalid book data")
    public BookDto createBook(@Valid @RequestBody CreateBookRequestDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a book")
    @ApiResponse(responseCode = "200", description = "Book updated")
    @ApiResponse(responseCode = "400", description = "Invalid book data")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public BookDto putBook(@PathVariable Long id,
                           @Valid @RequestBody CreateBookRequestDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a book")
    @ApiResponse(responseCode = "204", description = "Book deleted")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
