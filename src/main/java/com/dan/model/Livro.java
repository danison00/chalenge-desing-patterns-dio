package com.dan.model;

import java.time.LocalDate;

public class Livro {
    private static int idManager = 0;
    private final int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public Livro(String title, String author, int totalCopies, int availableCopies) {
        this.id = idManager = idManager++;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
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

    public void incrementAvaliableCopies(int availableCopies) {
        this.availableCopies++;
    }

    public void decrementAvaliableCopies(int availableCopies) {
        this.availableCopies--;
    }
}
