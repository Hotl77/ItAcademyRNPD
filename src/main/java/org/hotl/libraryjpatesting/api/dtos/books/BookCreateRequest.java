package org.hotl.libraryjpatesting.api.dtos.books;

import org.hotl.libraryjpatesting.domain.enums.BookGenre;

public record BookCreateRequest(
        String title,
        BookGenre genre,
        Integer numberOfPages
) {
}
