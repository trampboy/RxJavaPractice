package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class RepeatTest {
    @Test
    public void repeatTest() throws Exception {
        Observable.just(1,2).repeat(2).subscribe(System.out::println);
    }
}
