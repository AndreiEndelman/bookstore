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

    @Bean
    CommandLineRunner testMongo(BookRepository repo) {
        return args -> {
            

            repo.save(new Book("1", "Clean Code", "Robert Martin","Technology"));
            repo.save(new Book("2", "Nights of Plague", "Orhan Pamuk","Murder Mystery"));
            repo.save(new Book("3", "Trigun Maximum", "Yasuhiro Nightow","Manga"));

            System.out.println("Books in DB: " + repo.findAll());
            
        };
    }
}
