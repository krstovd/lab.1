package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchByTitle(String text);
    Book create(String title, String genre, double averageRating);
}
