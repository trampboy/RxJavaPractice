package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.buer.rxjavapractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class ElementAtActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)
    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_at);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_element_at_test)
    public void clickElementAtTest () {
        Observable.just(1,2,3).elementAt(1).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                mResult.setText("integer:" + integer);
            }
        });
    }

    @OnClick(R.id.btn_element_at_or_default_test)
    public void clickElementAtOrDefaultTest () {
        Observable.just(1,2,3).elementAtOrDefault(4, 10).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        mResult.setText("integer:" + integer);
                    }
                });
    }
}
