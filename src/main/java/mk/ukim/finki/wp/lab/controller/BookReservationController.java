package mk.ukim.finki.wp.lab.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class BookReservationController {

    private final BookService bookService;

    public BookReservationController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getReservationForm(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "reservation";
    }


    @PostMapping("/create")
    public String createReservation(@RequestParam Long bookId,
                                    @RequestParam int numberOfCopies,
                                    @RequestParam String readerName,
                                    @RequestParam String address,
                                    Model model,
                                    HttpServletRequest request) {
        Book book = bookService.findById(bookId);

        String clientIp = request.getRemoteAddr();

        model.addAttribute("readerName", readerName);
        model.addAttribute( "clientIp", clientIp);
        model.addAttribute("bookTitle", book.getTitle());
        model.addAttribute("numberOfCopies", numberOfCopies);

        return  "reservationConfirmation";
    }
}
