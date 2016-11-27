package com.buer.rxjavapractice.chapter3;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * 专辑
 * Created by YanMingDao on 27/11/2016.
 */

public class Album {
    private List<Artist> listArtist = new ArrayList<>();

    private List<Track> listTracks = new ArrayList<>();

    public void addArtist(Artist artist){
        listArtist.add(artist);
    }

    public void addTrack(Track track) {
        listTracks.add(track);
    }

    public List<Track> getListTracks() {
        return listTracks;
    }

    public Observable<Artist> getMusicians(){
        return Observable.from(listArtist.toArray(new Artist[listArtist.size()]));
    }

    @Override
    public String toString() {
        return "Album{" +
                "listArtist=" + listArtist +
                ", listTracks=" + listTracks +
                '}';
    }
}
