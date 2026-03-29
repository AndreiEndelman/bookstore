package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {
}