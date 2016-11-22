package com.buer.rxjavapractice.unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by YanMingDao on 22/11/2016.
 */

public class ThreeTest {
    Three three = new Three();
    @Test
    public void getLondonArtistCountTest() throws Exception {
        ArrayList<Artist> arrArtist = new ArrayList<>();
        Artist artist = new Artist();
        artist.setFrom("China");
        arrArtist.add(artist);
        artist = new Artist();
        artist.setFrom("London");
        arrArtist.add(artist);
        artist = new Artist();
        artist.setFrom("China");
        arrArtist.add(artist);
        int count = three.getLondonArtistCount(arrArtist);
        Assert.assertEquals(1, count);
    }
}
