package com.buer.rxjavapractice.transformingObservables;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by YanMingDao on 30/11/2016.
 */

public class WindowTest {
    @Test
    public void windowTest() throws Exception {
        Observable.just(1,2,3,4).window(2).subscribe(new Subscriber<Observable<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                System.out.println("onNext");
                integerObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("integer:" + integer);
                    }
                });
            }
        });
    }
}
