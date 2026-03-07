package com.bookstore.rest_api_project.model;

import java.util.Set;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private Set<Book> cart;

    public User() {
        this.cart = new HashSet<>();
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = new HashSet<>();
    }
}
