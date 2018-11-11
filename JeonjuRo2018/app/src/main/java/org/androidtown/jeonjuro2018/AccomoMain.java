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

public class AccomoMain extends AppCompatActivity {
    RecyclerView accomoRecyclerView;
    RecyclerView.LayoutManager accomoLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomo_main);
        setCustomActionbar();

        accomoRecyclerView  = findViewById(R.id.recycler_view);
        accomoRecyclerView.setHasFixedSize(true);
        accomoLayoutManager = new LinearLayoutManager(this);
        accomoRecyclerView.setLayoutManager(accomoLayoutManager);


        ArrayList<TourInfo> tourInfoArrayList = new ArrayList<>();
        //tourInfoArrayList.add(new TourInfo(R.drawable.accomo,"전주한옥2","위치는~"));
        //tourInfoArrayList.add(new TourInfo(R.drawable.accomo,"전주한옥3","위치는~"));
        //tourInfoArrayList.add(new TourInfo(R.drawable.accomo,"전주한옥4","위치는~"));

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccomoMain.this, LocationDialog.class);
                startActivity(intent);
            }
        };

        MyAdapter myAdapter = new MyAdapter(this,tourInfoArrayList);
        accomoRecyclerView.setAdapter(myAdapter);
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
