package com.example.uberfood;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.squareup.picasso.Picasso.*;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private String[] id;
    private String[] image;
    private  String[] name;
    private String[] rate;

    private OnNoteListener mOnNoteListener;


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nametext;
        TextView ratetext;
        ImageView imageView;
        OnNoteListener onNoteListener;

        public MyViewHolder(View itemView,OnNoteListener onNoteListener) {
            super(itemView);
            this.nametext = (TextView) itemView.findViewById(R.id.nametext);
            this.ratetext = (TextView) itemView.findViewById(R.id.ratetext);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this. onNoteListener = onNoteListener ;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }


    }

    public CustomAdepter(Context mContext, String[] image,String[] title,String[] rate,OnNoteListener onNoteListener) {
        this.context = mContext;
        this.image = image;
        this.name = title;
        this.rate = rate;
        this.mOnNoteListener = onNoteListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,mOnNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder (final MyViewHolder holder, final int i) {
        holder.nametext.setText(name[i]);
        holder.ratetext.setText(rate[i]);
        with(context).load(image[i]).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return name.length;
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }


}
