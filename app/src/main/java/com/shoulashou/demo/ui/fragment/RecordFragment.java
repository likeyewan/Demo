package com.shoulashou.demo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.shoulashou.demo.R;
import com.shoulashou.demo.ui.adapter.ProductRecordAdapter;
import com.shoulashou.demo.ui.bean.ProductRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/7/22 9:57.
 **/
public class RecordFragment extends Fragment {
    private List<ProductRecord> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_record,container,false);
        for(int i=0;i<10;i++){
            ProductRecord productRecord=new ProductRecord();
            productRecord.setMessage("记录"+i);
            list.add(productRecord);
        }
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.record_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        ProductRecordAdapter adapter=new ProductRecordAdapter(list);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
