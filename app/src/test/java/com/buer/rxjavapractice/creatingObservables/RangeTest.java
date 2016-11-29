package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class RangeTest {
    @Test
    public void rangTest() throws Exception {
        Observable.range(0,10).subscribe(System.out::println);
    }
}
