package com.bookstore.rest_api_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlists")
public class Wishlist {

    @Id
    private String id;
    private String userId;
    private String wishlistName;

    public Wishlist() {
    }

    public Wishlist(String userId, String wishlistName) {
        this.userId = userId;
        this.wishlistName = wishlistName;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}