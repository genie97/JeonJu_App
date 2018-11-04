package net.software.jeonju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Otherway extends AppCompatActivity {

    private ListView listView = null;
    private ListAdapter listViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherway);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Otherway.this,Result.class);
                startActivity(myintent);
                finish();
            }
        });

        String[] str = {"1번 경로","2번 경로","3번 경로","4번 경로"};
        ListView listview = (ListView)findViewById(R.id.list);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        Intent myintent = new Intent(Otherway.this,Result.class);
                        startActivity(myintent);
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
}
