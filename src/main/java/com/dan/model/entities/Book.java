package com.dan.model.entities;

public class Book extends AbstractIdentifier{
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, int totalCopies) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        availableCopies = totalCopies;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + super.getId() +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies+'\''+
                '}';
    }
}
