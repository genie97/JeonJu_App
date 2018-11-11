package org.androidtown.jeonjuro2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

public class Result extends AppCompatActivity {
    ArrayList<Place> placelist = new ArrayList<>();
    GridView gridView;
    GridViewAdapter adapter;

    boolean storeName = false, storeImg = false;
    String storeNm = null, ImgURL = null;

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
                Intent myintent = new Intent(Result.this,ScheduleActivity.class);
                startActivity(myintent);
                finish();
            }
        });
    }

    private  void init() {
        gridView = (GridView)findViewById(R.id.grid);
        adapter = new GridViewAdapter(placelist,this);

        /*addPlace = (AddPlace)findViewById(R.id.add);
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
        });*/
        gridView.setAdapter(adapter);

        try {
            String rl = "http://openapi.jeonju.go.kr/rest/jeonjufood/getWhiteRiceList?authApiKey=";
            String key = "l%2Fbl3sZQ3YhS3%2BFhJ2byNgr0196DxOsYpBwiuxXai9lXFDCQk0uLB6cCO3K8sNazZBbLeDQigvUWgmkZn3i86A%3D%3D";
            String data = "&keyword=%EC%88%98%EB%9D%BC%EC%98%A8";
            URL url = new URL(rl+key);//검색 URL부분

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            while (parserEvent != XmlPullParser.END_DOCUMENT) {
                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                        if (parser.getName().equals("storeNm")) {
                            storeName = true;
                        }
                        if (parser.getName().equals("mainImgUrl")) {
                            storeImg = true;
                        }
                        break;
                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if (storeName) { //isTitle이 true일 때 태그의 내용을 저장.
                            storeNm = parser.getText();
                            storeName = false;
                        }
                        if (storeImg) { //isTitle이 true일 때 태그의 내용을 저장.
                            ImgURL = parser.getText();
                            storeImg = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("list")) {
                            placelist.add(new Place(storeNm,ImgURL));
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        } catch (Exception e) {
            ;
        }
    }
}

