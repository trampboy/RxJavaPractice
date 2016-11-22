package com.buer.rxjavapractice.unit;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by YanMingDao on 22/11/2016.
 */

public class Three {
    public int getLondonArtistCount(final ArrayList<Artist> arrArtist) {
        return Observable.from(arrArtist.toArray(new Artist[arrArtist.size()]))
                .filter(new Func1<Artist, Boolean>() {
                    @Override
                    public Boolean call(Artist artist) {
                        System.out.println(artist.isFrom());
                        return "London".equals(artist.isFrom());
                    }
                }).count().toBlocking().first();
    }

    public String[] toUpperCase(String[] actual) {
        List<String> list = Observable.from(actual).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s.toUpperCase();
            }
        }).toList().toBlocking().first();
        return list.toArray(new String[list.size()]);
    }
}
