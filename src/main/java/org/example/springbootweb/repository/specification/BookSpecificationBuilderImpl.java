package org.example.springbootweb.repository.specification;

import lombok.RequiredArgsConstructor;
import org.example.springbootweb.dto.BookSearchParametersDto;
import org.example.springbootweb.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilderImpl implements BookSpecificationBuilder {
    private static final String TITLE_FIELD = "title";
    private static final String AUTHOR_FIELD = "author";

    private final BookSpecificationProvider specificationProvider;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> specification = Specification.where(null);
        specification = specificationProvider.addContainsIgnoreCase(
                specification, TITLE_FIELD, searchParameters.title());
        return specificationProvider.addContainsIgnoreCase(
                specification, AUTHOR_FIELD, searchParameters.author());
    }
}
