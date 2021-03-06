package com.shoulashou.demo.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shoulashou.demo.ui.bean.FragmentInfo;
import com.shoulashou.demo.ui.fragment.AxleFragment;
import com.shoulashou.demo.ui.fragment.RecordFragment;
import com.shoulashou.demo.ui.fragment.RunFragment;
import com.shoulashou.demo.ui.fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/7/22 10:47.
 **/
public class ViewPagerTopAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragments = new ArrayList<>(3);

    public ViewPagerTopAdapter(@NonNull FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments() {
        mFragments.add(new FragmentInfo("轴", AxleFragment.class));
        mFragments.add(new FragmentInfo("IO", AxleFragment.class));
        mFragments.add(new FragmentInfo("记录", RecordFragment.class));

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}