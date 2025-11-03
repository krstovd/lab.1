package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBooks(@RequestParam(required = false) String searchText, Model model) {
        List<Book> books;
        if (searchText != null && !searchText.isEmpty()) {
            books = bookService.searchByTitle(searchText);
        } else {
            books = bookService.listAll();
        }
        model.addAttribute("books", books);
        return "listBooks";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-book";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam double averageRating) {
        bookService.create(title, genre, averageRating);
        return "redirect:/books";
    }
}
