package com.buer.rxjavapractice.combiningObservables;

import android.os.Bundle;

import com.buer.rxjavapractice.BaseActivity;
import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Func2;

public class CombineLatestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_combine_latest;
    }

    @OnClick(R.id.btn_combine_latest_test)
    public void clickCombineLatestTest() {
        Observable.combineLatest(Observable.just(1, 2, 3), Observable.just(5, 6, 7), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer * integer2;
            }
        }).subscribe(getSubscriber());
    }
}
