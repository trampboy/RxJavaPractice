package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.buer.rxjavapractice.R;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class DebounceActivity extends AppCompatActivity {
    public static final String TAG = DebounceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debounce);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_debounce_test)
    public void clickDebounceTest() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
                .subscribe(
                        integer -> Log.e(TAG, "Next:" + integer),
                        throwable -> Log.e(TAG, "Error:" + throwable.getMessage()),
                        () -> Log.e(TAG, "completed!"));
    }

    @OnClick(R.id.btn_throttle_with_timeout_test)
    public void clickThrottleWithTimeout() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .throttleWithTimeout(400, TimeUnit.MILLISECONDS)
                .subscribe(
                        integer -> Log.e(TAG, "Next:" + integer),
                        throwable -> Log.e(TAG, "Error:" + throwable.getMessage()),
                        () -> Log.e(TAG, "completed!"));
    }
}
