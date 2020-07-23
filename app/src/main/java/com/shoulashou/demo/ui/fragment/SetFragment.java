package com.shoulashou.demo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.shoulashou.demo.R;
import com.shoulashou.demo.ui.adapter.ViewPagerAdapter;
import com.shoulashou.demo.ui.adapter.ViewPagerTopAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2020/7/22 9:57.
 **/
public class SetFragment extends Fragment {
    private View mView;

    @BindView(R.id.tab_layout_set)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager_set)
    ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this,mView);
        initTabLayout();
        return mView;
    }
    private void initTabLayout() {
        PagerAdapter adapter=new ViewPagerTopAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
