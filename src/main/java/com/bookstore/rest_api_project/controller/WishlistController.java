package com.bookstore.rest_api_project.controller;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/wishlist-test")
    public String test() {
        return "wishlist works";
    }

    @GetMapping("/wishlists/{id}")
public Wishlist getWishlistById(@PathVariable String id) {
    return repo.findById(id).orElse(null);
}

    @GetMapping("/wishlists")
    public List<Wishlist> getAllWishlists() {
        return repo.findAll();
}

    @PostMapping("/wishlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWishlist(@RequestBody Wishlist wishlist) {
        repo.save(wishlist);
    }

    // POST /wishlists/add-book
    @PostMapping("/wishlists/add-book")
    @ResponseStatus(HttpStatus.OK)
    public void addBookToWishlist(@RequestBody Map<String, String> request) {
        String wishlistId = request.get("wishlistId");
        String bookId = request.get("bookId");

        Wishlist wishlist = repo.findById(wishlistId).orElse(null);

        if (wishlist == null) {
            throw new RuntimeException("Wishlist not found.");
        }

        if (!wishlist.getBookIds().contains(bookId)) {
            wishlist.getBookIds().add(bookId);
        }

        repo.save(wishlist);
    }
}