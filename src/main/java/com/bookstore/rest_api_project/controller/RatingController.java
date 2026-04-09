package com.bookstore.rest_api_project.controller;

import com.bookstore.rest_api_project.model.Rating;
import com.bookstore.rest_api_project.repository.RatingRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    // Create Rating
    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {

        if (rating.getRating() < 1 || rating.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        return ratingRepository.save(rating);
    }

    // Get Average Rating
    @GetMapping("/average/{bookId}")
public double getAverageRating(@PathVariable String bookId) {

    List<Rating> ratings = ratingRepository.findByBookId(bookId);

    System.out.println("Ratings found: " + ratings.size());

    for (Rating r : ratings) {
        System.out.println(r.getRating());
    }

    if (ratings.isEmpty()) {
        return 0.0;
    }

    double sum = 0;

    for (Rating r : ratings) {
        sum += r.getRating();
    }

    return sum / ratings.size();
}
}