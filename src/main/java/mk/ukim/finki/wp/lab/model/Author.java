package mk.ukim.finki.wp.lab.model;

public class Author {

    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;

    private static long idCounter = 1L;

    public Author(String name, String surname, String country, String biography) {
        this.id = idCounter++;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getBiography() {
        return biography;
    }
}
