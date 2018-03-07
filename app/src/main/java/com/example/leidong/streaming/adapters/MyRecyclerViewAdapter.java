package com.example.leidong.streaming.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.streaming.MyApplication;
import com.example.leidong.streaming.R;
import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.models.Channel;
import com.example.leidong.streaming.ui.LiveActivity;

/**
 * Created by leido on 2018/3/7.
 */

public class MyRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Channel[] mChannels;

    public MyRecyclerViewAdapter(Channel[] mChannels){
        this.mChannels = mChannels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tv.setText(mChannels[position].getTitle());
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApplication.getContext(), LiveActivity.class);
                intent.putExtra(Constants.KEY_URL, mChannels[position].getUrl());
                intent.putExtra(Constants.KEY_TITLE, mChannels[position].getUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mChannels.length;
    }

    /**
     * ViewHolder
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        MyViewHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.item);
        }
    }
}
