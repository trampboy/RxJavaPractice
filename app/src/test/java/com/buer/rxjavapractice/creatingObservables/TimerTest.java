package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class TimerTest {
    @Test
    public void timerTest() throws Exception {
        Observable.timer(1, TimeUnit.SECONDS).subscribe(System.out::println);
    }
}
