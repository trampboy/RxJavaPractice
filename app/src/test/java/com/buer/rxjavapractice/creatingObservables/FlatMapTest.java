package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

import static java.util.Arrays.asList;

/**
 * Created by YanMingDao on 30/11/2016.
 */

public class FlatMapTest {
    @Test
    public void flatMapTest() throws Exception {
        Observable.just(asList(1,2,7,8), asList(3,4,5,6,7))
                .flatMap((Func1<List<Integer>, Observable<?>>) Observable::from)
                .subscribe(integer -> {System.out.println("integer:" + integer);});
    }

    @Test
    public void flatMapIterableTest() throws Exception {
        Observable.just(asList(1,2), asList(3,4)).flatMapIterable(new Func1<List<Integer>, Iterable<Integer>>() {
            @Override
            public Iterable<Integer> call(List<Integer> integers) {
                return integers;
            }
        }).subscribe(integer -> {System.out.println("integer:" + integer);});
    }

    @Test
    public void concatMapTest() throws Exception {
        Observable.just(asList(1,2,7,8), asList(3,4,5,6,7))
                .concatMap((Func1<List<Integer>, Observable<?>>) Observable::from)
                .subscribe(integer -> {System.out.println("integer:" + integer);});
    }

    @Test
    public void switchMapTest() throws Exception {
        Observable.just(asList(1,2,7,8), asList(3,4,5,6,7))
                .switchMap((Func1<List<Integer>, Observable<?>>) Observable::from)
                .subscribe(integer -> {System.out.println("integer:" + integer);});
    }
}
