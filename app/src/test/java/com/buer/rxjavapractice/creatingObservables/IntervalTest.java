package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class IntervalTest {
    @Test
    public void intervalTest() throws Exception {
        Observable.interval(1, TimeUnit.SECONDS).buffer(3, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);
    }
}
