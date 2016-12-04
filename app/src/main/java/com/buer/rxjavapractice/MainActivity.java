package com.buer.rxjavapractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.buer.rxjavapractice.combiningObservables.CombiningObservablesActivity;
import com.buer.rxjavapractice.filteringObservables.FilteringObservablesActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_filtering_observables_click)
    public void clickFilteringObservables(){
        startActivity(new Intent(this, FilteringObservablesActivity.class));
    }

    @OnClick(R.id.btn_combining_observables_click)
    public void clickCombiningObservablesClick() {
        startActivity(new Intent(this, CombiningObservablesActivity.class));
    }
}
