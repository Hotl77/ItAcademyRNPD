package org.hotl.libraryjpatesting.domain.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.api.dtos.books.BookResponseSecond;
import org.hotl.libraryjpatesting.api.mappers.BookEntityMapper;
import org.hotl.libraryjpatesting.api.dtos.books.BookResponse;
import org.hotl.libraryjpatesting.domain.entities.BookEntity;
import org.hotl.libraryjpatesting.domain.jpas.BookEntityJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    final BookEntityJpa bookEntityJpa;
    final BookEntityMapper bookEntityMapper;


    public List<BookResponse> findAll(Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        Page<BookEntity> bookList =  bookEntityJpa.findAll(pageRequest);

        List<BookResponse> response = bookEntityMapper.toResponse(bookList.getContent());
        return response;


    }

    public List<BookResponseSecond> findByAuthor(String authorName) {

        List<BookEntity> books = bookEntityJpa.findDistinctByAuthors_FirstName(authorName);

        List<BookResponseSecond> response = bookEntityMapper.toSecondResponse(books);

        return response;
    }

    public List<BookResponse> findByNumberOfPages(
            Integer numberOfPages
    ) {

        List<BookEntity> books = bookEntityJpa.findAllByNumberOfPagesGreaterThan(numberOfPages);

        List<BookResponse> response = bookEntityMapper.toResponse(books);

        return response;
    }


}
