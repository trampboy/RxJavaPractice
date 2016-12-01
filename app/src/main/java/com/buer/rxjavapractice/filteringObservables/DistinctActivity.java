package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.buer.rxjavapractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

public class DistinctActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)
    TextView mTvResult;

    StringBuilder sb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distinct);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_distinct_test)
    public void doDistinctTest() {
        sb = new StringBuilder(100);
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct()
                .subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_distinct_func1_test)
    public void doDistinctFunc1Test () {
        sb = new StringBuilder(100);
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct(integer -> integer > 2)
                .subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_distinct_until_changed_test)
    public void doDistinctUntilChangedTest () {
        sb = new StringBuilder(100);
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinctUntilChanged()
                .subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_distinct_until_changed_func1_test)
    public void doDistinctUntilChangedFunc1Test () {
        sb = new StringBuilder(100);
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinctUntilChanged(integer -> integer > 2)
                .subscribe(getSubscriber());
    }

    @NonNull
    private Subscriber<Integer> getSubscriber() {
        return new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                sb.append("Next: ").append(item).append("\n");
                mTvResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable error) {
                sb.append("Error: ").append(error.getMessage()).append("\n");
                mTvResult.setText(sb.toString());
            }

            @Override
            public void onCompleted() {
                sb.append("Sequence complete.\n");
                mTvResult.setText(sb.toString());
            }
        };
    }

}
