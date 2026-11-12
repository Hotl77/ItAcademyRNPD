package org.hotl.libraryjpatesting.api.dtos.books;

import org.hotl.libraryjpatesting.domain.enums.BookGenre;

import java.util.Set;
import java.util.UUID;

public record BookResponse(
        UUID bookId,
        String title,
        BookGenre genre,
        Integer numberOfPages,
        Set<AuthorSummaryForBook> authors
) {
}
