package com.buer.rxjavapractice.transformingObservables;

import org.junit.Test;

import rx.Observable;

/**
 * Created by YanMingDao on 30/11/2016.
 */

public class ScanTest {
    @Test
    public void scanTest() throws Exception {
        Observable.just(1,2,3,4)
                .scan((sum, item) -> sum + item)
                .subscribe(integer -> {
            System.out.println("integer:" + integer);
        });
    }

    @Test
    public void scanTest2() throws Exception {
        Observable.just(1,2,3,4)
                .scan(10, (sum, item) -> sum + item)
                .subscribe(integer -> {
                    System.out.println("integer:" + integer);
                });
    }
}
