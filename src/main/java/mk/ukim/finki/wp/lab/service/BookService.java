package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchByTitle(String text);
    Book update (Long id, String title, String genre, double averageRating, Long authorId);
    Book findById(Long id);
    void deleteById(Long id);

    Book create(String title, String genre, double averageRating, Long authorId);
}
