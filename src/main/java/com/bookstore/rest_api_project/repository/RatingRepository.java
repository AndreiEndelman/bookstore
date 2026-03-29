package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {

}