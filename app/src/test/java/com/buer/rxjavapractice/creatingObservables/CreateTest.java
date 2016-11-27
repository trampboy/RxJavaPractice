package com.buer.rxjavapractice.creatingObservables;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by YanMingDao on 28/11/2016.
 */
public class CreateTest {
    @Test
    public void createTest() throws Exception {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i <= 5; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }
        });

    }
}