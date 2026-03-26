package com.bookstore.rest_api_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String comment;
    private String userId;
    private String bookId;
    private Date timestamp;

    public Comment(String comment, String userId, String bookId) {
        this.comment = comment;
        this.userId = userId;
        this.bookId = bookId;
        this.timestamp = new Date();
    }

    public String getComment() { return comment; }
    public String getUserId() { return userId; }
    public String getBookId() { return bookId; }
    public Date getTimestamp() { return timestamp; }
    public String getId() { return id; }
}