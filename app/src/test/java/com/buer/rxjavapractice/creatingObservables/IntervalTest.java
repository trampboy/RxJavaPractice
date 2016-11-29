package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class IntervalTest {
    @Test
    public void intervalTest() throws Exception {
        AtomicLong lastTick = new AtomicLong(0L);
        Observable.interval(1, TimeUnit.SECONDS, Schedulers.io())
                .map(new Func1<Long, Long>() {

            @Override
            public Long call(Long aLong) {
                return lastTick.getAndIncrement();
            }
        }).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(aLong);
            }
        });
    }
}
