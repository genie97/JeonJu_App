package org.androidtown.jeonjuro2018;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class TourMain extends AppCompatActivity {
    RecyclerView tourRecyclerView;
    RecyclerView.LayoutManager tourLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_main);
        setCustomActionbar();

        tourRecyclerView  = findViewById(R.id.recycler_view);
        tourRecyclerView.setHasFixedSize(true);
        tourLayoutManager = new LinearLayoutManager(this);
        tourRecyclerView.setLayoutManager(tourLayoutManager);

        ArrayList<TourInfo> tourInfoArrayList = new ArrayList<>();

        tourInfoArrayList.add(new TourInfo(R.drawable.tour,"전주한옥2","위치는~"));
        tourInfoArrayList.add(new TourInfo(R.drawable.tour,"전주한옥3","위치는~"));
        tourInfoArrayList.add(new TourInfo(R.drawable.tour,"전주한옥4","위치는~"));

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TourMain.this, LocationDialog.class);
                startActivity(intent);
            }
        };


        MyAdapter myAdapter = new MyAdapter(this,tourInfoArrayList,mListener);
        tourRecyclerView.setAdapter(myAdapter);

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

