package com.buer.rxjavapractice.combiningObservables;

import android.os.Bundle;

import com.buer.rxjavapractice.BaseActivity;
import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

// TODO: 04/12/2016 not done
public class AndOrThenOrWhenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_and_then_when_test)
    public void clickAndThenWhenTest () {
//        Pattern5<Integer> pattern = JoinObservable.from(Observable.just(1,2,3));
//        Plan0<Observable<Integer>> plan = pattern.then(Observable.just(4,5,6));
//        JoinObservable.from(Observable.just(1,2,3)).and(Observable.just(4,5,6)).then()
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_and_or_then_or_when;
    }
}
