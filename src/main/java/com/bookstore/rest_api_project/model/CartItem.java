package com.bookstore.rest_api_project.model;

public class CartItem {
    private String bookId;
    private String bookName;
    private double price;
    private int quantity;

    public CartItem(String bookId, double price, String bookName) {
        this.bookId = bookId;
        this.price = price;
        this.quantity = 1;
        this.bookName = bookName;
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
