package com.buer.rxjavapractice.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func1;
import rx.observables.MathObservable;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static rx.Observable.just;

/**
 * Created by YanMingDao on 22/11/2016.
 */

public class ThreeTest {
    ArrayList<Artist> arrArtist = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        arrArtist.add(new Artist("A", "China"));
        arrArtist.add(new Artist("B", "London"));
        arrArtist.add(new Artist("C", "China"));
    }

    @Test
    public void getLondonArtistCountTest() throws Exception {
        int count = Observable.from(arrArtist.toArray(new Artist[arrArtist.size()]))
                .filter(artist -> "London".equals(artist.getNationality())).count().toBlocking().first();
        Assert.assertEquals(1, count);
    }

    @Test
    public void toUpperCaseTest() throws Exception {
        String[] actual = {"a", "b", "c"};
        String[] expected = {"A", "B", "C"};
        List<String> list = Observable.from(actual).map(String::toUpperCase).toList().toBlocking().first();
        Assert.assertArrayEquals(expected, list.toArray(new String[list.size()]));
    }

    @Test
    public void beginningWithNumbersTest() throws Exception {
        String[] arrString = new String[]{"a", "1abc", "abc1"};
        Assert.assertEquals(Collections.singletonList("1abc"), Observable.from(arrString).filter(s -> isDigit(s.charAt(0))).toList().toBlocking().first());
    }

    @Test
    public void flatMapTest() throws Exception {
        List<Integer> list = just(asList(1,2), asList(3,4))
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
        Artist china = new Artist("A", "China");
        Artist london = new Artist("B", "London");
        int result = MathObservable.max(just(china, london).map(new Func1<Artist, Integer>() {
            @Override
            public Integer call(Artist artist) {
                return artist.getNationality().length();
            }
        })).toBlocking().first();
        Assert.assertEquals(london.getNationality().length(), result);
    }

    @Test
    public void reduceTest() throws Exception {
        int result = Observable.just(1,3,5,7).reduce((integer, integer2) -> integer + integer2).toBlocking().first();
        Assert.assertEquals(16, result);
    }

    /**
     * 找出某张专辑所有的乐队国籍，艺术家列表既有个人，也有乐队，假定乐队是以"The"开头
     */
    @Test
    public void findArtistNationalityInOneAlbum() throws Exception {
        Album album = new Album();
        List<String> nationality = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(ArrayList::new, new Action2<List<String>, String>() {
                    @Override
                    public void call(List<String> strings, String s) {
                        strings.add(s);
                    }
                }).toBlocking().first();
        for (String s : nationality) {
            System.out.println("result:" + s);
        }
    }


}
