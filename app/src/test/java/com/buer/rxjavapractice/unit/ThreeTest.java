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
        album.addArtist(new Artist("The A", "China"));
        album.addArtist(new Artist("The B", "London"));
        album.addArtist(new Artist("C", "China"));
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

    /**
     * 找出长度大于1分钟的曲目
     *
     */
    @Test
    public void findLongTracksTest() throws Exception {
        List<Album> albums = new ArrayList<>();
        Album album = new Album();
        album.addTrack(new Track("A", 45));
        album.addTrack(new Track("B", 70));
        albums.add(album);
        album = new Album();
        album.addTrack(new Track("C", 80));
        album.addTrack(new Track("D", 100));
        albums.add(album);

        Observable.from(albums.toArray(new Album[albums.size()]))
                .flatMap(new Func1<Album, Observable<Track>>() {
                    @Override
                    public Observable<Track> call(Album album) {
                        List<Track> listTracks = album.getListTracks();
                        return Observable.from(listTracks.toArray(new Track[listTracks.size()]));
                    }
                })
                .filter(track -> track.getLength() > 60)
                .map(track -> {
                    String name = track.getName();
                    System.out.println(name);
                    return name;
                })
                .toList().toBlocking().first();
    }

    /**
     * 求和函数
     */
    @Test
    public void sumTest() throws Exception {
        int result = Observable.just(1,3,5,7,9)
                .reduce((integer, integer2) -> integer + integer2)
                .toBlocking().first();
        Assert.assertEquals(25, result);
    }

    /**
     * 返回字符串，其中包含艺术家的姓名和国籍
     */
    @Test
    public void findArtistNameAndNationalityTest() throws Exception {
        Album album = new Album();
        album.addArtist(new Artist("The A", "China"));
        album.addArtist(new Artist("The B", "London"));
        album.addArtist(new Artist("C", "China"));
//        album.getMusicians().forEach(new Action1<Artist>() {
//            @Override
//            public void call(Artist artist) {
//
//            }
//        }))
    }

    /**
     * 接受专辑列表，返回一个最多包含3首歌的专辑组成的列表
     */
    @Test
    public void findAlbumsLessThanThree() throws Exception {
        List<Album> albums = new ArrayList<>();
        Album album = new Album();
        album.addTrack(new Track("A1", 45));
        album.addTrack(new Track("A2", 70));
        album.addTrack(new Track("A3", 70));
        album.addTrack(new Track("A4", 70));
        albums.add(album);
        album = new Album();
        album.addTrack(new Track("B1", 80));
        album.addTrack(new Track("B2", 100));
        albums.add(album);

        Observable.from(albums.toArray(new Album[albums.size()]))
                .filter(album1 -> album1.getListTracks().size() <= 3)
                .collect(ArrayList::new, new Action2<ArrayList<Album>, Album>() {
                    @Override
                    public void call(ArrayList<Album> alba, Album album) {
                        System.out.println(album.toString());
                        alba.add(album);
                    }
                })
                .toBlocking().first();

    }
}
