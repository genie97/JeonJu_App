package org.androidtown.jeonjuro2018;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    ArrayList<TourInfo> tourInfoArrayList;
    View.OnClickListener mListener;

    public MyAdapter(Context context, ArrayList<TourInfo> items, View.OnClickListener mListener) {
        this.mContext = context;
        this.tourInfoArrayList = items;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);

        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tourPicture.setImageResource(tourInfoArrayList.get(position).drawableId);
        myViewHolder.tourName.setText(tourInfoArrayList.get(position).tourName);
        myViewHolder.tourLocation.setText(tourInfoArrayList.get(position).tourLocation);
    }

    @Override
    public int getItemCount() {
        return tourInfoArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tourPicture;
        TextView tourName;
        TextView tourLocation;

        MyViewHolder(View view) {
            super(view);
            tourPicture = view.findViewById(R.id.tour_picture);
            tourName = view.findViewById(R.id.tour_name);
            tourLocation = view.findViewById(R.id.tour_location);

            if(mListener !=null)
                view.setOnClickListener(mListener);
        }
    }

 }
