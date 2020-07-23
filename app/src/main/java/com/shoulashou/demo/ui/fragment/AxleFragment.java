package com.shoulashou.demo.ui.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.shoulashou.demo.R;
import com.shoulashou.demo.ui.view.SuspendButtonLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AxleFragment extends Fragment {
    @BindView(R.id.layout)
    SuspendButtonLayout suspendButtonLayout;
    View mView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.axle_fragment, container, false);
        ButterKnife.bind(this,mView);
        init();
        return mView;

    }
    private void init(){
        suspendButtonLayout.setOnSuspendListener(new SuspendButtonLayout.OnSuspendListener() {
            @Override
            public void onButtonStatusChanged(int status) {

            }
            @Override
            public void onChildButtonClick(int index) {
                Toast.makeText(mView.getContext(), "李" + index, Toast.LENGTH_SHORT).show();
            }
        });
        suspendButtonLayout.setPosition(true,100);
    }
}
