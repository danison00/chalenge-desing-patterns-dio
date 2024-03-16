package com.dan.model.entities;

public class Book {
    private static int idManager = 0;
    private final int id;
    private String title;
    private String author;
    private int totalCopies;
    private static int availableCopies;

    public Book(String title, String author, int totalCopies) {
        this.id = idManager = idManager++;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        availableCopies = totalCopies;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void incrementAvailableCopies() {
        availableCopies++;
    }

    public void decrementAvailableCopies() {
        availableCopies--;
    }
}
