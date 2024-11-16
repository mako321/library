package com.github.mako321.Models;

public class Magazine extends Item{
    protected int issue; // numer w roku

    public Magazine(Integer id, String name, int issue) {
        super(id, name);
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Czasopismo {" +
                "id=" + id +
                ", tytuł = '" + title + '\'' +
                ", numer w roku = " + issue +
                '}';
    }
}
