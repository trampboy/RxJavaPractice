package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by YanMingDao on 28/11/2016.
 */

public class DeferTest {
    @Test
    public void deferTest() throws Exception {
        Observable.defer(() -> Observable.just(1))
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("integer:" + integer);
                    }
                });
    }
}
