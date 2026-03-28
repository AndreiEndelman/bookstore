package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {}
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bookstore.rest_api_project.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    // Retrieve all books associated with a given author
    List<Book> findByAuthorId(String authorId);
    List<Book> findByGenre(String genre);
    Optional<Book> findByIsbn(String isbn);
}
