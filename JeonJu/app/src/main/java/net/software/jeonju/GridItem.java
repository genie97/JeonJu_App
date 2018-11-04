package net.software.jeonju;

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
        img.setImageResource(Place.imglist[one.getImagno()]);
    }
}
