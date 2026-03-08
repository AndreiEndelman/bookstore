package com.bookstore.rest_api_project.model;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<CartItem> cart;

    public User() {
        this.cart = new ArrayList<>();
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }

    public String getId() { return id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}
