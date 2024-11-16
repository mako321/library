package com.github.mako321.Models;

public class Volume {
    private int id;
    private Item item;

    public Volume(int id, Item item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public String toString() {
        return "Wolumin {" +
                "id = " + id +
                ", pozycja = " + item.toString() +
                '}';
    }
}
