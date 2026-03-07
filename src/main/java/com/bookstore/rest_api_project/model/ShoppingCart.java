package com.bookstore.rest_api_project.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "ShoppingCart")
public class ShoppingCart {
    @Id
    private String id;

    @DBRef
    private Set<Book> cart;

    public ShoppingCart() {
        this.cart = new HashSet<>();
        
    }
}
