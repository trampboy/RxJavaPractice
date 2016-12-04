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

public class IgnoreElementsActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)
    TextView tvResult;

    private StringBuilder sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ignore_elements);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_ignore_elements_test)
    public void clickIgnoreElementsTest () {
        sb = new StringBuilder();
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++) {
                    if (i < 5) {
                        subscriber.onNext(i);
                    } else {
                        subscriber.onCompleted();
                    }
                }
            }
        }).ignoreElements().subscribe(getSubscriber());
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
