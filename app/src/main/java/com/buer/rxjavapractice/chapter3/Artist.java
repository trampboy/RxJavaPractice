package com.buer.rxjavapractice.chapter3;

/**
 * Created by YanMingDao on 22/11/2016.
 */
public class Artist {
    private String name;
    private String nationality;
    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
