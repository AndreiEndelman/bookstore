package com.bookstore.rest_api_project.controller;

import com.bookstore.rest_api_project.model.Rating;
import com.bookstore.rest_api_project.repository.RatingRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {

        if (rating.getRating() < 1 || rating.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        return ratingRepository.save(rating);
    }
}