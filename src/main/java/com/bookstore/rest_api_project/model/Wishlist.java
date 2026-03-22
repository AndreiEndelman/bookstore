package com.bookstore.rest_api_project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlists")
public class Wishlist {

    @Id
    private String id;
    private String userId;
    private String wishlistName;
    private List<String> bookIds;

    public Wishlist() {
        this.bookIds = new ArrayList<>();
    }

    public Wishlist(String userId, String wishlistName) {
        this.userId = userId;
        this.wishlistName = wishlistName;
        this.bookIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }
}