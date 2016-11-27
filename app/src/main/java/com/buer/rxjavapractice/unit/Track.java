package com.buer.rxjavapractice.unit;

/**
 * Created by YanMingDao on 27/11/2016.
 */
public class Track {
    private int length;
    private String name;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
