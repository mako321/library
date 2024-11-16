package com.github.mako321.Models;

// rewers
public class CallSlip {
    private Volume volume;
    private Reader reader;

    public CallSlip(Volume volume, Reader reader) {
        this.volume = volume;
        this.reader = reader;
    }

    public Volume getVolume() {
        return volume;
    }

    public Reader getReader() {
        return reader;
    }

    public String toString() {
        return "Rewers {" +
                "wolumin = '" + volume.getItem().title + '\'' +
                ", czytelnik = '" + reader.getName() + " " + reader.getLastName() + '\'' +
                '}';
    }
}
