package org.androidtown.jeonjuro2018;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocationDialog extends AppCompatActivity {

    TextView title_text, location, description;
    ImageView tourImage;
    Uri mUri;
    Bitmap bmImg;
    back task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_dialog);

        task = new back();
        tourImage = (ImageView)findViewById(R.id.tourImage) ;
        title_text = (TextView) findViewById(R.id.title_text);
        location = (TextView) findViewById(R.id.location);
        description = (TextView) findViewById(R.id.description);

        String url = getIntent().getStringExtra("url");
        String locat = getIntent().getStringExtra("location");
        String name = getIntent().getStringExtra("name");
        String des = getIntent().getStringExtra("des");

        task.execute(url);
        title_text.setText(name);
        location.setText(locat);
        description.setText(des);

        /*if (url != null && url.isEmpty()) {
            //if(gno.indexOf("file://") == -1)

            url = "file://"+url;
            mUri = Uri.parse(url);

            try {

                bmImg = MediaStore.Images.Media.getBitmap(getContentResolver(), mUri);
                tourImage.setImageBitmap(bmImg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tourImage.setImageBitmap(bmImg);
        }*/

        Button okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private class back extends AsyncTask<String, Integer,Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try{
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);

            }catch(IOException e){
                e.printStackTrace();
            }
            return bmImg;
        }
        protected void onPostExecute(Bitmap img){
            tourImage.setImageBitmap(bmImg);
        }
    }
}
