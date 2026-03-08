package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    // Retrieve all books associated with a given author
    List<Book> findByAuthorId(String authorId);
}
