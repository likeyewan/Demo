package com.shoulashou.demo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shoulashou.demo.R;
import com.shoulashou.demo.ui.bean.ProductRecord;

import java.util.List;

/**
 * Created by Administrator on 2020/7/22 15:39.
 **/
public class ProductRecordAdapter extends RecyclerView.Adapter<ProductRecordAdapter.ViewHolder> {
    private List<ProductRecord> list;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.item);
        }
    }
    public ProductRecordAdapter(List<ProductRecord> proudctRecords){
        list=proudctRecords;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_record,parent,false);
        final ProductRecordAdapter.ViewHolder holder=new ProductRecordAdapter.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRecord proudctRecord=list.get(position);
        holder.name.setText(proudctRecord.getMessage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
