package se.iths.sebastian.libaryapp.model;

public class Book {

    private String title;
    private int isbn;
    private Author author;

    public Book(String title, int isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " ISBN nummer: " + isbn + " skriven av: " + author;
    }
}
