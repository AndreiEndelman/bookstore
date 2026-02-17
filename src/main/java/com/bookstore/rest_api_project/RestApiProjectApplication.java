package com.bookstore.rest_api_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.repository.BookRepository;

@SpringBootApplication
public class RestApiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiProjectApplication.class, args);
    }

    // ✅ This is the new part
    @Bean
    CommandLineRunner testMongo(BookRepository repo) {
        return args -> {
            // Add a sample book to the DB
            repo.save(new Book("1", "Clean Code", "Robert Martin","Non-Fiction"));

            // Print all books in the DB
            System.out.println("Books in DB: " + repo.findAll());
        };
    }
}
