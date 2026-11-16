package org.example.springbootweb.repository.specification;

import org.example.springbootweb.dto.BookSearchParametersDto;
import org.example.springbootweb.model.Book;
import org.springframework.data.jpa.domain.Specification;

public interface BookSpecificationBuilder {
    Specification<Book> build(BookSearchParametersDto searchParameters);
}
