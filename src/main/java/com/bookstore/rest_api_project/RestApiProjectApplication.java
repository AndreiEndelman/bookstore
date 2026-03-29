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
          
            // Add sample books to the DB
          
            repo.save(new Book("978-0-13-468599-1", "Clean Code", "A handbook of agile software craftsmanship.", 35.99, "author1", "Technology", "Prentice Hall", 2008, 500000, 4.6));
            repo.save(new Book("978-0-374-23000-1", "Nights of Plague", "A historical novel set in the Ottoman Empire.", 27.99, "author2", "Fiction", "Farrar Straus Giroux", 2022, 150000, 3.5));
            repo.save(new Book("978-1-59582-040-1", "Trigun Maximum", "A sci-fi western manga series.", 14.99, "author3", "Manga", "Dark Horse Comics", 2004, 300000, 4.2));

            System.out.println("Books in DB: " + repo.findAll());

        };
    }
}
