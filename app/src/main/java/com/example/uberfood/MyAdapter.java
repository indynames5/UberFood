package com.example.uberfood;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private String[] mDataset;
    private Context mContext;
    private String[] pic;
    private String[] name;
    private String[] rate;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView rate;
        ImageView img;

        public MyViewHolder(View v) {
            super(v);
            this.name = (TextView) itemView.findViewById(R.id.nametext);
            this.rate = (TextView) itemView.findViewById(R.id.ratetext);
            this.img = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public MyAdapter(Context mContext, String[] pic , String[] name, String[] rate) {

        this.mContext = mContext;
        this.rate=rate;
        this.pic=pic;
        this.name=name;


    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(name[position]);
        holder.rate.setText(rate[position]);
//        Picasso.with(mContext).load(pic[position]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

}
