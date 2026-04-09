package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByBookId(String bookId);
}