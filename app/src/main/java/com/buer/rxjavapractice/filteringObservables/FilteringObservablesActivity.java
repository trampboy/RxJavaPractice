package com.buer.rxjavapractice.filteringObservables;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.buer.rxjavapractice.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilteringObservablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtering_observables);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_debounce_activity)
    public void toDebounceActivity() {
        Intent intent = new Intent(this, DebounceActivity.class);
        startActivity(intent);
    }
}