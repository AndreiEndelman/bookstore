package com.bookstore.rest_api_project.repository;

import com.bookstore.rest_api_project.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}