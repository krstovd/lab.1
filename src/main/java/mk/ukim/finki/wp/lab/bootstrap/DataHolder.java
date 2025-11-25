package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init(){
        Author author1 = new Author("Isaac", "Asimov","USA","Famous sci-fi author");
        Author author2 = new Author("J.K", "Rowling","UK","Author of Harry Potter");
        Author author3 = new Author("George", "Orwell","UK","Famous for 1984 and Animal Farm");

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        books.add(new Book("The Psychology of Money", "Psychology", 4.5, author1));
        books.add(new Book("Rich Dad Poor Dad", "Personal Finance", 4.8, author2));
        books.add(new Book("Harry Potter", "Fantasy", 4.7, author2));
        books.add(new Book("Think and Grow Rich", "Psychology", 4.6, author1));
        books.add(new Book("The Lord of the Rings", "Fantasy", 4.9, author3));


    }
}
