package com.bookstore.rest_api_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.repository.BookRepository;

@RestController
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // GET /books — retrieve all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // POST /books — create a new book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        repo.save(book);
    }

    // GET /books/{isbn} — retrieve a book by ISBN
    @GetMapping("/books/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return repo.findById(isbn).orElse(null);
    }

    @GetMapping("/books/genre")
    public List<Book> getBooksByGenre(@RequestParam String genre) {

    return repo.findByGenre(genre);

    }

    @GetMapping("/books/top-sellers")
    public List<Book> getTopSellers() {
        
        return repo.findTop10ByOrderByCopiesSoldDesc();

    }

    @GetMapping("/books/rating/{rating}")
    public List<Book> getBooksByRating(@PathVariable double rating) {

        return repo.findByRatingGreaterThanEqual(rating);

    }

    @PatchMapping("/books/discount")
    public void discountBooksByPublisher(@RequestParam String publisher, @RequestParam double discountPercent) {

    List<Book> books = repo.findByPublisher(publisher);

    for (Book book : books) {

        double newPrice = book.getPrice() * (1 - discountPercent / 100);
        book.setPrice(newPrice);

    }

    repo.saveAll(books);

}

}
