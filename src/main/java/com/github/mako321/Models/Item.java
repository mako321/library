package com.github.mako321.Models;

public class Item {
    protected Integer id;
    protected String title;

    public Item(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return "Pozycja {" +
                "id=" + id +
                ", tytuł='" + title + '\'' +
                '}';
    }
}
