package com.bookstore.rest_api_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String description;
    private double price;
    private String authorId;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;

    public Book() {}

    public Book(String isbn, String title, String description, double price,
                String authorId, String genre, String publisher,
                int yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.authorId = authorId;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    // getters and setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }
    public int getCopiesSold() { return copiesSold; }
    public void setCopiesSold(int copiesSold) { this.copiesSold = copiesSold; }
}
