package com.example.leidong.streaming.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.adapters.MyAdapter;
import com.example.leidong.streaming.models.Channel;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class BaseFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private Channel[] mChannels;

    public BaseFragment(Channel[] mChannels) {
        this.mChannels = mChannels;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contaioner, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, contaioner, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initWidgets();

        initActions();
    }

    /**
     * 初始化动作
     */
    private void initActions() {

    }

    /**
     * 初始化组件
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initWidgets() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(getContext(), mChannels));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
