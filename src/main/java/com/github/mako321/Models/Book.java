package com.github.mako321.Models;

public class Book extends Item {
    protected String author;

    public Book(Integer id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Książka {" +
                "id=" + id +
                ", tytuł = '" + title + '\'' +
                ", autor = '" + author + '\'' +
                '}';
    }
}
