package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("The Psychology of Money", "Psychology", 4.5));
        books.add(new Book("Rich Dad Poor Dad", "Personal Finance", 4.8));
        books.add(new Book("Harry Potter", "Fantasy", 4.7));
        books.add(new Book("Think and Grow Rich", "Psychology", 4.6));
        books.add(new Book("The Lord of the Rings", "Fantasy", 4.9));
    }
}
