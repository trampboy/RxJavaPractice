package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class JustTest {
    @Test
    public void justTest() throws Exception {
        Observable.just(1,2,3,4).subscribe(integer -> {
            System.out.println("integer:" + integer);
        });
    }
}
