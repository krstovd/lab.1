package mk.ukim.finki.wp.lab.model;

public class Book {
    private Long id;
    private String title;
    private String genre;
    private double averageRating;

    private Author author;

    private static long idCounter = 1L;

    public Book(String title, String genre, double averageRating, Author author) {
        this.id = idCounter++;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

    public Long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}


