package com.buer.rxjavapractice.unit;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static java.lang.Character.isDigit;

/**
 * Created by YanMingDao on 22/11/2016.
 */

public class Three {
    public int getLondonArtistCount(final ArrayList<Artist> arrArtist) {
        return Observable.from(arrArtist.toArray(new Artist[arrArtist.size()]))
                .filter(artist -> {
                    System.out.println(artist.isFrom());
                    return "London".equals(artist.isFrom());
                }).count().toBlocking().first();
    }

    public String[] toUpperCase(String[] actual) {
        List<String> list = Observable.from(actual).map(String::toUpperCase).toList().toBlocking().first();
        return list.toArray(new String[list.size()]);
    }

    public List<String> beginningWithNumbers(String[] arrString) {
        return Observable.from(arrString).filter(s -> isDigit(s.charAt(0))).toList().toBlocking().first();
    }
}
