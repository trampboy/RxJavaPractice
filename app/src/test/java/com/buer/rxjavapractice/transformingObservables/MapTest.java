package com.buer.rxjavapractice.transformingObservables;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;

import rx.Observable;
import rx.observables.StringObservable;

/**
 * Created by YanMingDao on 30/11/2016.
 */

public class MapTest {
    @Test
    public void mapTest() throws Exception {
        Observable.just(1,2,3,4)
                .map(integer -> integer > 2)
                .subscribe(System.out::println);

    }

    @Test
    public void castTest() throws Exception {
        Observable.just(1,2,3,4)
                .cast(Number.class)
                .subscribe(System.out::println);
    }

    @Test
    public void encodeTest() throws Exception {
        StringObservable.encode(Observable.just("qqw2", "342j"), Charset.defaultCharset())
                .subscribe(bytes -> {
            System.out.println("bytes:" + Arrays.toString(bytes));
        });
    }

    @Test
    public void byLineTest() throws Exception {
        StringObservable.byLine(Observable.just("123\n", "idyw\niweu", "sjsj"))
                .subscribe(s -> {
            System.out.println("s:" + s);
        });
    }
}
