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

public class FirstActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)
    TextView tvResult;
    StringBuilder sb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_first_test)
    public void clickFirstTest() {
        sb = new StringBuilder();
        Observable.just(1,2,3).first().subscribe(getSubscriber());
    }

    @OnClick(R.id.btn_take_first_test)
    public void clickTakeFirstTest() {
        sb = new StringBuilder();
        Observable.empty()
                .takeFirst(integer -> integer == null)
                .subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                sb.append("onCompleted").append("\n");
                tvResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {
                sb.append("onError:").append(e).append("\n");
                tvResult.setText(sb.toString());
            }

            @Override
            public void onNext(Object o) {
                sb.append("onNext:").append(o).append("\n");
                tvResult.setText(sb.toString());
            }
        });
    }

    @OnClick(R.id.btn_single_test)
    public void clickSingleTest () {
        sb = new StringBuilder();
        Observable.just(1,2,3).single().subscribe(getSubscriber());
    }

    @NonNull
    private Subscriber<Integer> getSubscriber() {
        return new Subscriber<Integer>() {
            @Override
            public void onNext(Integer item) {
                sb.append("Next: ").append(item).append("\n");
                tvResult.setText(sb.toString());
            }

            @Override
            public void onError(Throwable error) {
                sb.append("Error: ").append(error.getMessage()).append("\n");
                tvResult.setText(sb.toString());
            }

            @Override
            public void onCompleted() {
                sb.append("Sequence complete.\n");
                tvResult.setText(sb.toString());
            }
        };
    }
}
