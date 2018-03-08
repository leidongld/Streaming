package com.example.leidong.streaming.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.models.Channel;
import com.example.leidong.streaming.ui.LiveActivity;
import com.example.leidong.streaming.utils.FontUtils;
import com.example.leidong.streaming.utils.NetUtils;

/**
 * Created by leidong on 2018/3/7
 */

public class MyRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Channel[] mChannels;
    private Context mContext;

    public MyRecyclerViewAdapter(Channel[] mChannels, Context mContext){
        this.mChannels = mChannels;
        this.mContext = mContext;
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
        FontUtils.setFontFromAssets(holder.tv, "fonts/xingshu.ttf");
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isWiFi = NetUtils.isWiFiEnvironment(mContext);
                if(isWiFi) {
                    Intent intent = new Intent(mContext, LiveActivity.class);
                    intent.putExtra(Constants.KEY_TITLE, mChannels[position].getTitle());
                    intent.putExtra(Constants.KEY_URL, mChannels[position].getUrl());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle(mContext.getString(R.string.warning));
                    builder.setMessage(mContext.getString(R.string.no_wifi));
                    builder.setPositiveButton(mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(mContext, LiveActivity.class);
                            intent.putExtra(Constants.KEY_TITLE, mChannels[position].getTitle());
                            intent.putExtra(Constants.KEY_URL, mChannels[position].getUrl());
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }
                    });
                    builder.setNegativeButton(mContext.getString(R.string.cannel), null);
                    builder.create();
                    builder.show();
                }
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
