package com.buer.rxjavapractice.unit;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * 专辑
 * Created by YanMingDao on 27/11/2016.
 */

public class Album {
    private List<Artist> arrArtist = new ArrayList<>();

    public Album() {
        arrArtist.add(new Artist("The A", "China"));
        arrArtist.add(new Artist("The B", "London"));
        arrArtist.add(new Artist("C", "China"));
    }

    public Observable<Artist> getMusicians(){
        return Observable.from(arrArtist.toArray(new Artist[arrArtist.size()]));
    }
}
