package com.buer.rxjavapractice.filteringObservables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.buer.rxjavapractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

public class FilterActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)
    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_filter_test)
    public void clickFilterTest() {
        StringBuilder sb = new StringBuilder();
        Observable.just(1,2,3,4)
                .filter(integer -> integer > 2)
                .subscribe(integer -> {
                    sb.append(integer).append("\n");
                    mResult.setText(sb.toString());
                });
    }

    @OnClick(R.id.btn_of_type_test)
    public void clickOfTypeTest () {
        StringBuilder sb = new StringBuilder();
        Observable.just(1,2,3,4).ofType(Integer.class).subscribe(integer -> {
            sb.append(integer).append("\n");
            mResult.setText(sb.toString());
        });
    }
}
