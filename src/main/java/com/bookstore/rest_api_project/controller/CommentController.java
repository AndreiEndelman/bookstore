package com.bookstore.rest_api_project.controller;

import com.bookstore.rest_api_project.model.Comment;
import com.bookstore.rest_api_project.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}