package org.example.springbootweb.repository.specification;

import org.example.springbootweb.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationProvider {
    public Specification<Book> addContainsIgnoreCase(
            Specification<Book> specification, String field, String value) {
        if (value == null || value.isBlank()) {
            return specification;
        }
        return specification.and((root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(field)), "%" + value.toLowerCase() + "%"));
    }
}
