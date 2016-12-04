package com.buer.rxjavapractice.combiningObservables;

import android.os.Bundle;

import com.buer.rxjavapractice.BaseActivity;
import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Func2;

public class ZipActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_zip_test)
    public void clickZipTest() {
        Observable.zip(Observable.just(1, 2, 3), Observable.just(5, 6, 7), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_zip_with_test)
    public void clickZipWithTest () {
        Observable.just(1,2,3).zipWith(Observable.just(5, 6, 7), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer * integer2;
            }
        }).subscribe(getSubscriber());
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_zip;
    }
}
