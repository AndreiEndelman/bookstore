package com.bookstore.rest_api_project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.rest_api_project.model.Author;
import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.repository.AuthorRepository;
import com.bookstore.rest_api_project.repository.BookRepository;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public AuthorController(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    // POST /authors — create a new author
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody Author author) {
        authorRepo.save(author);
    }

    // GET /authors/{authorId}/books — retrieve all books for an author
    @GetMapping("/authors/{authorId}/books")
    public List<Book> getBooksByAuthor(@PathVariable String authorId) {
        return bookRepo.findByAuthorId(authorId);
    }
}
