package stream.problem.given.by.Aadi;

public class Book {
    private String title;
    private String genre;
    private double rating;

    public Book(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
}