package com.buer.rxjavapractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import rx.Subscriber;

public abstract class BaseActivity extends AppCompatActivity {
    TextView tvResult;
    LinearLayout llContent;

    StringBuilder sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        tvResult = (TextView) findViewById(R.id.tv_result);
        llContent = (LinearLayout) findViewById(R.id.ll_content);
        View contentView = View.inflate(this, getContentLayoutId(), null);
        llContent.addView(contentView);
    }

    @NonNull
    public Subscriber<Integer> getSubscriber() {
        sb = new StringBuilder();
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

    public abstract int getContentLayoutId();
}
