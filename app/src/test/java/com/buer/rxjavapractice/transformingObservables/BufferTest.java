package com.buer.rxjavapractice.transformingObservables;

import org.junit.Test;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/**
 * Created by YanMingDao on 29/11/2016.
 */

public class BufferTest {
    @Test
    public void bufferTest() throws Exception {
        Observable.just(1,2,3,4).buffer(2).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println("onNext:" + integers);
            }
        });
    }

    @Test
    public void bufferWithSkipTest() throws Exception {
        Observable.just(1,2,3,4,5,6).buffer(2, 3).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println("onNext:" + integers);
            }
        });
    }

    // TODO: 30/11/2016 用法还有问题 
    @Test
    public void bufferWithBufferClosingSelector() throws Exception {
        Observable.just(1,2,3,4,5,6).buffer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                System.out.println("call");
                return Observable.just(7,8,9);
            }
        }).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println("integers:" + integers);
            }
        });
    }

    // TODO: 30/11/2016 用法还有问题
    @Test
    public void bufferWithBoundary() throws Exception {
        Observable.just(1,2,3,4).buffer(Observable.just(1,2)).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e);
            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println("integers:" + integers);
            }
        });
    }
}
