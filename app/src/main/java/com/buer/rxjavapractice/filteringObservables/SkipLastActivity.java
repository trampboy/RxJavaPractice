package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;

import com.buer.rxjavapractice.BaseActivity;
import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

public class SkipLastActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_skip_last_test)
    public void clickSkipLastTest() {
        Observable.just(1,2,3,4,5).skipLast(2).subscribe(getSubscriber());
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_skip_last;
    }
}
