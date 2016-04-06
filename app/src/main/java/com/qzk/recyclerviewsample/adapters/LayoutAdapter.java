package com.qzk.recyclerviewsample.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qzk.recyclerviewsample.R;
import com.qzk.recyclerviewsample.layoutmanager.model.LayoutModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.adapters
 * Created by QZK on 2016/4/6.
 */
public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.MyViewHolder> {
    private List<LayoutModel> dataSources = new ArrayList<>();
    private Context mContext;
    private RecyclerViewOnItemClickListener onItemClickListener;

    public LayoutAdapter(Context context, List<LayoutModel> dataSources, RecyclerViewOnItemClickListener onItemClickListener) {
        this.dataSources = dataSources;
        this.onItemClickListener = onItemClickListener;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(position%2==0){
            holder.tv_item.setBackgroundColor(Color.BLUE);
        }else{
            holder.tv_item.setBackgroundColor(Color.RED);
        }
        holder.setPositon(position);
        holder.tv_item.setText(dataSources.get(position).getWords());

    }

    @Override
    public int getItemCount() {
        return dataSources.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       private View root;
        private TextView tv_item;
        public int positon;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.root = itemView;
            this.tv_item = (TextView) itemView.findViewById(R.id.item_tv);
            this.root.setOnClickListener(this);
        }

        public int getPositon() {
            return positon;
        }

        public void setPositon(int positon) {
            this.positon = positon;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(positon);
        }
    }
}
