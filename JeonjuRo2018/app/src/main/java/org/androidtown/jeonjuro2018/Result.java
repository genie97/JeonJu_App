package org.androidtown.jeonjuro2018;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Result extends AppCompatActivity {
    ArrayList<Place> data = new ArrayList<>();
    GridView gridView;
    GridViewAdapter adapter;
    AddPlace addPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        init();
        setCustomActionbar();
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Result.this,Otherway.class);
                startActivity(myintent);
                finish();
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Result.this,ScheduleActivity.class);
                startActivity(myintent);
                finish();
            }
        });
    }

    private  void init() {
        gridView = (GridView)findViewById(R.id.grid);
        adapter = new GridViewAdapter(data,this);

        addPlace = (AddPlace)findViewById(R.id.add);
        addPlace.setOnAddListener(new AddPlace.OnAddListener() {
            @Override
            public void onAdd(String name, int imagno) {
                adapter.addPlace(new Place(name,imagno));
            }

            @Override
            public void onModify(String name, int imagno, int position) {
                adapter.modifyPlace(name,imagno,position);
            }

            @Override
            public Place getData(int pos) {
                return (Place)adapter.getItem(pos);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addPlace.putPos(position);
                addPlace.changeButton("M",false);
            }
        });
        gridView.setAdapter(adapter);
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
}

