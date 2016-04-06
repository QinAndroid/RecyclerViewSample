package com.qzk.recyclerviewsample.layoutmanager.present;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.qzk.recyclerviewsample.adapters.LayoutAdapter;
import com.qzk.recyclerviewsample.adapters.RecyclerViewOnItemClickListener;
import com.qzk.recyclerviewsample.layoutmanager.model.LayoutModel;
import com.qzk.recyclerviewsample.layoutmanager.view.IRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.linlayoutmanager.present
 * Created by QZK on 2016/4/6.
 */
public class RecyclerViewPresent implements IRecyclerViewPresent {
    private List<LayoutModel> dataSource = new ArrayList<>();
    private IRecycleView linearLayoutRecycleView;
    private RecyclerViewOnItemClickListener onItemClickListener;
    private Context mContext;
    public RecyclerViewPresent(Context context,IRecycleView linearLayoutRecycleView, RecyclerViewOnItemClickListener onItemClickListener) {
        this.linearLayoutRecycleView = linearLayoutRecycleView;
        this.onItemClickListener = onItemClickListener;
        this.mContext = context;
    }

    @Override
    public void setRecyclerView() {
        linearLayoutRecycleView.getRecyclerView().setAdapter(new LayoutAdapter(mContext,dataSource,onItemClickListener));
    }

    @Override
    public void setFlag(int flag) {
        if(flag == 1){
            linearLayoutRecycleView.getRecyclerView().setLayoutManager(new LinearLayoutManager(mContext));
        }else{
            linearLayoutRecycleView.getRecyclerView().setLayoutManager(new GridLayoutManager(mContext,4));
        }
    }

    @Override
    public void setDataSource(int size) {
        for(int i = 0;i<size;i++){
            dataSource.add(new LayoutModel("test"+i));
        }
    }

    @Override
    public List<LayoutModel> getDataSource() {
        return dataSource;
    }
}
