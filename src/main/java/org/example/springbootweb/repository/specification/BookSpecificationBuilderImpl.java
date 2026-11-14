package org.example.springbootweb.repository.specification;

import lombok.RequiredArgsConstructor;
import org.example.springbootweb.dto.BookSearchParametersDto;
import org.example.springbootweb.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilderImpl implements BookSpecificationBuilder {
    private final BookSpecificationProvider specificationProvider;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> specification = Specification.where(null);
        specification = specificationProvider.addContainsIgnoreCase(
                specification, "title", searchParameters.title());
        return specificationProvider.addContainsIgnoreCase(
                specification, "author", searchParameters.author());
    }
}
