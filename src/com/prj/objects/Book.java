package com.prj;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private int availableCopies;

    public Book(String isbn, String title, String author, int year, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.availableCopies = availableCopies;
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
