package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by YanMingDao on 28/11/2016.
 */

public class EmptyOrNeverOrErrorTest {
    @Test
    public void EmptyTest() throws Exception {
        Observable.empty().subscribe(new Subscriber<Object>() {
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

    @Test
    public void NeverTest() throws Exception {
        Observable.never().subscribe(new Subscriber<Object>() {
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

    @Test
    public void ErrorTest() throws Exception {
        Observable.error(new NullPointerException("null"))
                .subscribe(new Subscriber<Object>() {
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
