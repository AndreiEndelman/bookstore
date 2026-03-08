package com.bookstore.rest_api_project.model;

import org.springframework.data.annotation.Id;

public class CartItem {
    @Id
    private String id;
    private String bookId;
    private double price;
    private int quantity;

    public CartItem(String bookId, double price) {
        this.bookId = bookId;
        this.price = price;
        this.quantity = 1;
    }

    public String getBookId() { return bookId; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int qty) {
        this.quantity = qty;
    }
    public void addOne() {
        this.quantity++;
    }
}
