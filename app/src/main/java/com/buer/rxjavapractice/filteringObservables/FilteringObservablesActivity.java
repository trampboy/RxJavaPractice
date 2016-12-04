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
        startActivity(new Intent(this, DebounceActivity.class));
    }

    @OnClick(R.id.btn_to_distinct_activity)
    public void toDistinctActivity() {
        startActivity(new Intent(this, DistinctActivity.class));
    }

    @OnClick(R.id.btn_to_element_at_activity)
    public void toElementAtActivity() {
        startActivity(new Intent(this, ElementAtActivity.class));
    }

    @OnClick(R.id.btn_to_filter_activity)
    public void toFilterActivity() {
        startActivity(new Intent(this, FilterActivity.class));
    }

    @OnClick(R.id.btn_to_first_activity)
    public void toFirstActivity () {
        startActivity(new Intent(this, FirstActivity.class));
    }

    @OnClick(R.id.btn_to_ignore_elements_activity)
    public void toIgnoreElementsActivity() {
        startActivity(new Intent(this, IgnoreElementsActivity.class));
    }

    @OnClick(R.id.btn_to_last_activity)
    public void toLastActivity() {
        startActivity(new Intent(this, LastActivity.class));
    }

    @OnClick(R.id.btn_to_sample_activity)
    public void toSampleActivity() {
        startActivity(new Intent(this, SampleActivity.class));
    }

    @OnClick(R.id.btn_to_skip_activity)
    public void toSkipActivity() {
        startActivity(new Intent(this, SkipActivity.class));
    }

    @OnClick(R.id.btn_to_skip_last_activity)
    public void toSkipLastActivity() {
        startActivity(new Intent(this, SkipLastActivity.class));
    }

    @OnClick(R.id.btn_to_take_activity)
    public void toTakeActivity() {
        startActivity(new Intent(this, TakeActivity.class));
    }

    @OnClick(R.id.btn_to_take_last_activity)
    public void toTakeLastActivity () {
        startActivity(new Intent(this, TakeLastActivity.class));
    }
}
