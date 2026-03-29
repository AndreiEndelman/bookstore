package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {}
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookstore.rest_api_project.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByAuthorId(String authorId);

    List<Book> findByGenre(String genre);
    Optional<Book> findByIsbn(String isbn);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List<Book> findByRatingGreaterThanEqual(double rating);
    List<Book> findByPublisher(String publisher);
    
}
