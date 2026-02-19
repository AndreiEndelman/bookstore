package com.bookstore.rest_api_project.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bookstore.rest_api_project.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByGenreIgnoreCase(String genre);
    
}