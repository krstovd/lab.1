package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByTitle(String text) {
        return bookRepository.searchByTitle(text);
    }

    @Override
    public Book update(Long id, String title, String genre, double averageRating, Long authorId) {
        Book book = findById(id);
        if(book == null) {
            return null;
        }
        Author author = authorRepository.findById(authorId);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        return book;
    }

    @Override
    public Book create(String title, String genre, double averageRating, Long authorId) {
        Author author = authorRepository.findById(authorId);
        Book book = new Book(title, genre, averageRating,  author);
        return bookRepository.save(book);
    }
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
