package com.buer.rxjavapractice.unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.observables.MathObservable;

import static java.util.Arrays.asList;

/**
 * Created by YanMingDao on 22/11/2016.
 */

public class ThreeTest {
    Three three = new Three();
    @Test
    public void getLondonArtistCountTest() throws Exception {
        ArrayList<Artist> arrArtist = new ArrayList<>();
        arrArtist.add(new Artist("China"));
        arrArtist.add(new Artist("London"));
        arrArtist.add(new Artist("China"));
        int count = three.getLondonArtistCount(arrArtist);
        Assert.assertEquals(1, count);
    }

    @Test
    public void toUpperCaseTest() throws Exception {
        String[] actual = {"a", "b", "c"};
        String[] expected = {"A", "B", "C"};
        Assert.assertArrayEquals(expected, three.toUpperCase(actual));
    }

    @Test
    public void beginningWithNumbersTest() throws Exception {
        String[] arrString = new String[]{"a", "1abc", "abc1"};
        Assert.assertEquals(Collections.singletonList("1abc"), three.beginningWithNumbers(arrString));
    }

    @Test
    public void flatMapTest() throws Exception {
        List<Integer> list = Observable.just(asList(1,2), asList(3,4))
                .flatMap(new Func1<List<Integer>, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(List<Integer> integers) {
                        return Observable.from(integers);
                    }
                })
                .toList()
                .toBlocking()
                .first();
        Assert.assertEquals(asList(1,2,3,4), list);
    }

    // TODO: 27/11/2016 找出长度最大的Artist
    @Test
    public void maxTest() throws Exception {
        Artist china = new Artist("China");
        Artist london = new Artist("London");
        List<Artist> artists = asList(china, london);
        int result = MathObservable.max(Observable.just(china, london).map(new Func1<Artist, Integer>() {
            @Override
            public Integer call(Artist artist) {
                return artist.isFrom().length();
            }
        })).toBlocking().first();
        Assert.assertEquals(london.isFrom().length(), result);
    }
}
