package com.example.leidong.streaming.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.models.Channel;
import com.example.leidong.streaming.ui.LiveActivity;
import com.example.leidong.streaming.utils.NetUtils;
import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private Channel[] mChannels;

    public MyAdapter(Context context, Channel[] mChannels) {
        this.mContext = context;
        this.mChannels = mChannels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.channel_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(mChannels != null) {

            holder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, LiveActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.KEY_TITLE, mChannels[position].getTitle());
                    bundle.putString(Constants.KEY_URL, mChannels[position].getUrl());
                    bundle.putString(Constants.KEY_IMAGE_URL, mChannels[position].getImageUrl());
                    intent.putExtra(Constants.ITEM_DATA, bundle);
                    mContext.startActivity(intent);
                }
            });

            if (NetUtils.isWiFiEnvironment(mContext)) {
                Picasso.get().load(mChannels[position].getImageUrl()).into(holder.itemImage);
            } else {
                holder.itemImage.setImageResource(R.drawable.image_not_load);
            }

            holder.itemName.setText(mChannels[position].getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if(mChannels != null){
            return mChannels.length;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout itemLayout;
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);

            itemLayout = itemView.findViewById(R.id.item_layout);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
}
