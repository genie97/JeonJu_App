package net.software.jeonju;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View;

/**
 * Created by starf on 2018-11-03.
 */

public class AddPlace extends LinearLayout implements View.OnClickListener {
    int imgno = 0;
    int pos = -1;
    Context context;
    AutoCompleteTextView at;
    ImageView img;
    Button b_add;
    EditText et;
    boolean isAdd = true;

    public AddPlace (Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.place_add,this);
        at = (AutoCompleteTextView)findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);
        //b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        //b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v) {
        if (v == b_add) {
            if(isAdd) {
                onAddListener.onAdd(at.getText().toString(), imgno);
                clear();
            }
            else {
                onAddListener.onModify(at.getText().toString(),imgno,pos);
                changeButton("Add",true);
            }
        }
        else {
            imgno = (imgno + 1) % Place.placeList.length;
            img.setImageResource(Place.imglist[imgno]);
        }
    }

    interface OnAddListener {
        void onAdd(String name, int imagno);
        void onModify(String name, int imagno, int position);
        Place getData(int pos);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }

    public void putPos(int pos) {
        this.pos = pos;
    }

    public  void changeButton(String msg,boolean flag) {
        b_add.setText(msg);
        isAdd = flag;
        if(isAdd) {
            clear();
        }
        else {
            Place setData = onAddListener.getData(pos);
            at.setText(setData.getName());
            img.setImageResource(Place.imglist[imgno = setData.getImagno()]);
        }
    }

    public void clear() {
        img.setImageResource(Place.imglist[imgno = 0]);
    }
}
