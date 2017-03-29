package com.buer.rxjavapractice.errorHandlingOperators;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ErrorHandlingOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_handling_operators);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_catch_activity)
    public void toCatchActivity() {
        startActivity(new Intent(this, CatchActivity.class));
    }

    @OnClick(R.id.btn_to_retry_activity)
    public void toRetryActivity() {
        startActivity(new Intent(this, RetryActivity.class));
    }
}
