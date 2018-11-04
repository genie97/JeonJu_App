package org.androidtown.jeonjuro2018;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomActionbar();
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);


        ImageButton tourBtn = (ImageButton) findViewById(R.id.tourBtn);
        ImageButton restBtn = (ImageButton) findViewById(R.id.restBtn);
        ImageButton accomoBtn = (ImageButton) findViewById(R.id.accomoBtn);
        RadioButton schedule_topbar = (RadioButton) findViewById(R.id.schedule_topbar);

        tourBtn.setOnClickListener(this);
        restBtn.setOnClickListener(this);
        accomoBtn.setOnClickListener(this);
        schedule_topbar.setOnClickListener(this);
    }

    private void setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        //set custom view layout
        View mCustomView = LayoutInflater.from(this).inflate(R.layout.actionbar_main, null);
        actionBar.setCustomView(mCustomView);

        //set no padding both side
        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView, params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tourBtn:
                startActivity(new Intent(MainActivity.this, TourMain.class));
                break;
            case R.id.restBtn:
                startActivity(new Intent(MainActivity.this, RestMain.class));
                break;
            case R.id.accomoBtn:
                startActivity(new Intent(MainActivity.this, AccomoMain.class));
                break;
            case R.id.schedule_topbar:
                startActivity(new Intent(MainActivity.this, scheduleMain.class));
                break;
        }
    }
}
