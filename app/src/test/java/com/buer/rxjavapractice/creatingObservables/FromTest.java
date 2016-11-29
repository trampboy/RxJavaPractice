package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class FromTest {
    @Test
    public void fromTest() throws Exception {
        Observable.from(new Integer[]{1,2,3,4}).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("o:" + o);
            }
        });
    }
}
