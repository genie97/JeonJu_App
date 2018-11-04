package net.software.jeonju;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
                int num = 10;
                Toast.makeText(getApplicationContext(),num, Toast.LENGTH_LONG).show();
                //Intent myintent = new Intent(otherway.this,bestway.class); 예지페이지로 넘어가라
                //startActivity(myintent);
                //finish();
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
}
