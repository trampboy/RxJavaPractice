package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;

import com.buer.rxjavapractice.BaseActivity;
import com.buer.rxjavapractice.R;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

public class SkipActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_skip_test)
    public void clickSkipTest() {
        Observable.just(1,2,3).skip(2).subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_skip_with_time_test)
    public void clickSkipWithTimeTest() {
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
        }).skip(500, TimeUnit.MILLISECONDS).subscribe(getSubscriber());
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_skip;
    }
}
