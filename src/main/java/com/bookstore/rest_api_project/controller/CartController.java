import java.util.List;

import com.bookstore.rest_api_project.model.Book;
import com.bookstore.rest_api_project.repository.BookRepository;
import com.bookstore.rest_api_project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("/cart")
    public List<Book> getBooksInCart() {return bookRepo.findAll();}
}
