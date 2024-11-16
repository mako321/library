package com.github.mako321.Models;

import java.util.LinkedList;
import java.util.List;

public class Reader {
    protected Integer id;
    protected String name;
    protected String lastName;
    protected List<CallSlip> callSlips;

    public Reader(Integer id, String name, String lastName, LinkedList<CallSlip> callSlips) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.callSlips = callSlips;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<CallSlip> getCallSlips() {
        return callSlips;
    }

    public List<CallSlip> addCallSlip(CallSlip callSlip) {
        callSlips.add(callSlip);

        return callSlips;
    }

    public String toString() {
        return "Czytelnik {" +
                "id=" + id +
                ", imię ='" + name + '\'' +
                ", nazwisko ='" + lastName + '\'' +
                '}';
    }
}
