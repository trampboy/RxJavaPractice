package com.buer.rxjavapractice.combiningObservables;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CombiningObservablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combining_observables);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_and_or_then_or_when_activity)
    public void toAndOrThenOrWhenActivity () {
        startActivity(new Intent(this, AndOrThenOrWhenActivity.class));
    }

    @OnClick(R.id.btn_to_combine_latest_activity)
    public void toCombiningObservablesActivity() {
        startActivity(new Intent(this, CombineLatestActivity.class));
    }

    @OnClick(R.id.btn_to_join_activity)
    public void toJoinActivity() {
        startActivity(new Intent(this, JoinActivity.class));
    }

    @OnClick(R.id.btn_to_merge_activity)
    public void toMergeActivity() {
        startActivity(new Intent(this, MergeActivity.class));
    }

    @OnClick(R.id.btn_to_start_with_activity)
    public void toStartWithActivity() {
        startActivity(new Intent(this, StartWithActivity.class));
    }

    @OnClick(R.id.btn_to_switch_activity)
    public void toSwitchActivity() {
        startActivity(new Intent(this, SwitchActivity.class));
    }

    @OnClick(R.id.btn_to_zip_activity)
    public void toZipActivity() {
        startActivity(new Intent(this, ZipActivity.class));
    }

}
