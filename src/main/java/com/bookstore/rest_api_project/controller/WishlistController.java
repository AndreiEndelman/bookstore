package com.bookstore.rest_api_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.bookstore.rest_api_project.model.Wishlist;
import com.bookstore.rest_api_project.repository.WishlistRepository;

@RestController
public class WishlistController {

    private final WishlistRepository repo;

    public WishlistController(WishlistRepository repo) {
        this.repo = repo;
    }

    // simple test endpoint
    @GetMapping("/wishlist-test")
    public String test() {
        return "wishlist works";
    }

    // POST /wishlists — create a wishlist
    @PostMapping("/wishlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWishlist(@RequestBody Wishlist wishlist) {
        repo.save(wishlist);
    }
}