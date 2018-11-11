package org.androidtown.jeonjuro2018;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.provider.MediaStore;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.support.v7.widget.Toolbar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    HorizontalScrollView scrollbar_accomo;
    RadioButton homeTopbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomActionbar();

        homeTopbar = (RadioButton) findViewById(R.id.home_topbar);
        homeTopbar.toggle();


        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        //   LinearLayout container = (LinearLayout)findViewById(R.id.container);
        ImageButton tourBtn = (ImageButton) findViewById(R.id.tourBtn);
        ImageButton restBtn = (ImageButton) findViewById(R.id.restBtn);
        ImageButton accomoBtn = (ImageButton) findViewById(R.id.accomoBtn);
        //     scrollbar_accomo = (HorizontalScrollView) findViewById(R.id.s);
        //    scrollbar_accomo.setVerticalScrollBarEnabled(false);
        //   scrollbar_accomo.setHorizontalScrollBarEnabled(false);


        RadioButton schedule_topbar = (RadioButton) findViewById(R.id.schedule_topbar);
        RadioButton custom_topbar = (RadioButton) findViewById(R.id.custom_topbar);

        tourBtn.setOnClickListener(this);
        restBtn.setOnClickListener(this);
        accomoBtn.setOnClickListener(this);
        schedule_topbar.setOnClickListener(this);
        custom_topbar.setOnClickListener(this);
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

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT);

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
            case R.id.custom_topbar:
                startActivity(new Intent(MainActivity.this, CustomActivity.class));
                break;
        }
    }
}
