package com.bookstore.rest_api_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "ratings")
public class Rating {

    @Id
    private String id;

    private int rating;      // 1–5 stars
    private String userId;
    private String bookId;
    private Date timestamp;

    public Rating(int rating, String userId, String bookId) {
        this.rating = rating;
        this.userId = userId;
        this.bookId = bookId;
        this.timestamp = new Date();
    }

    public Rating() {
        this.timestamp = new Date();
    }

    public int getRating() {
        return rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
}