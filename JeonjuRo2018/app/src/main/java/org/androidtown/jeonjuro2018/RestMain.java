package org.androidtown.jeonjuro2018;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RestMain extends AppCompatActivity {
    RecyclerView restRecyclerView;
    RecyclerView.LayoutManager restLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_main);
        setCustomActionbar();

        restRecyclerView  = findViewById(R.id.recycler_view);
        restRecyclerView.setHasFixedSize(true);
        restLayoutManager = new LinearLayoutManager(this);
        restRecyclerView.setLayoutManager(restLayoutManager);

        ArrayList<TourInfo> tourInfoArrayList = new ArrayList<>();
       // tourInfoArrayList.add(new TourInfo(R.drawable.rest,"전주한옥2","위치는~"));
        //tourInfoArrayList.add(new TourInfo(R.drawable.rest,"전주한옥3","위치는~"));
       // tourInfoArrayList.add(new TourInfo(R.drawable.rest,"전주한옥4","위치는~"));

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestMain.this, LocationDialog.class);
                startActivity(intent);
            }
        };

        MyAdapter myAdapter = new MyAdapter(this,tourInfoArrayList);
        restRecyclerView.setAdapter(myAdapter);

    }


    private void setCustomActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        //set custom view layout
        View mCustomView = LayoutInflater.from(this).inflate(R.layout.actionbar_main,null);
        actionBar.setCustomView(mCustomView);

        //set no padding both side
        Toolbar parent = (Toolbar)mCustomView.getParent();
        parent.setContentInsetsAbsolute(0,0);

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView,params);
    }
}
