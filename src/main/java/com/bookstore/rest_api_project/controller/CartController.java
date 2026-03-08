package com.bookstore.rest_api_project.controller;

import java.util.List;
import java.util.Optional;
import java.util.String;
import java.util.Double;

import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.model.CartItem;
import com.bookstore.rest_api_project.model.User;
import com.bookstore.rest_api_project.repository.BookRepository;
import com.bookstore.rest_api_project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/cart/{userId}")
    public ResponseEntity<List<CartItem>> getBooksInCart(@PathVariable String userId) {
        if (userId == null) return ResponseEntity.badRequest().build();
        Optional<User> optUser = userRepo.findById(userId);
        if (!optUser.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optUser.get().getCart());
    }

    @PostMapping("/cart/{userId}/add/{isbn}")
    public ResponseEntity<List<CartItem>> addBookToCart(@PathVariable String userId, @PathVariable String isbn) {
        if (userId == null || isbn == null) return ResponseEntity.badRequest().build();
        Optional<User> optUser = userRepo.findById(userId);
        Optional<Book> optBook = bookRepo.findByIsbn(isbn);
        if(!optUser.isPresent() || !optBook.isPresent()) return ResponseEntity.badRequest().build();
        User user = optUser.get();
        Book book = optBook.get();
        user.addToCart(book.getIsbn(), book.getPrice(), book.getTitle());
        userRepo.save(user);
        return ResponseEntity.ok().body(user.getCart());
    }

    @GetMapping("/cart/{userId}/subtotal")
    public ResponseEntity<Double> getSubtotal(@PathVariable String userId) {
         Optional<User> optUser = userRepo.findById(userId);
         if (!optUser.isPresent()) return ResponseEntity.notFound().build();
         List<CartItem> cart = optUser.get().getCart();
         Double sum = 0.;
         for (CartItem it : cart) sum += it.getPrice() * it.getQuantity();
         return ResponseEntity.ok(sum);
    }
}
