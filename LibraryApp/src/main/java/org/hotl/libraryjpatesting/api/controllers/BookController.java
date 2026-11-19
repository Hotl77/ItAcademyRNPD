package org.hotl.libraryjpatesting.api.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotl.libraryjpatesting.api.dtos.books.BookResponse;
import org.hotl.libraryjpatesting.api.dtos.books.BookResponseSecond;

import org.hotl.libraryjpatesting.domain.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;



    @GetMapping
    public List<BookResponse> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) {
        return bookService.findAll(page,size);
    }

    @GetMapping("/author")
    public List<BookResponseSecond> findByAuthor(
            @RequestParam String authorName
    ) {
        return bookService.findByAuthor(authorName);
    }

    @GetMapping("/pages")
    public List<BookResponse> findByNumberOfPages(
            @RequestParam(defaultValue = "100") Integer numberOfPages
    ) {
        return bookService.findByNumberOfPages(numberOfPages);
    }

















}
