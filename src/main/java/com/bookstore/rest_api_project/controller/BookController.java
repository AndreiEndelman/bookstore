package com.bookstore.rest_api_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.repository.BookRepository;

@RestController
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}
