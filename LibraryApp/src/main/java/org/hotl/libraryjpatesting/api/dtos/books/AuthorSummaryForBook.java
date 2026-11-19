package org.hotl.libraryjpatesting.api.dtos.books;

import java.util.UUID;

public record AuthorSummaryForBook(
        UUID authorId,
        String firstName,
        String lastName
) {


}
