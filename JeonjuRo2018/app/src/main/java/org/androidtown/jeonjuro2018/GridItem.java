package org.androidtown.jeonjuro2018;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by starf on 2018-11-03.
 */

public class GridItem extends LinearLayout {
    TextView tv1;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.grid_view_item,this);

        tv1 = (TextView)findViewById(R.id.placename);
        img = (ImageView)findViewById(R.id.img);
    }

    public void setData(Place one) {
        tv1.setText(one.getName());
        //img.setImageResource(Place.imglist[one.getImagno()]);
    }
}

    /*private class back extends AsyncTask<String, Integer,Bitmap> {
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
            img2.setImageBitmap(bmImg);
        }
    }*/

