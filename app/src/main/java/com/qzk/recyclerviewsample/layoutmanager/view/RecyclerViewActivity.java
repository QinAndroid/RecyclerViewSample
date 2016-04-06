package com.qzk.recyclerviewsample.layoutmanager.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qzk.recyclerviewsample.R;
import com.qzk.recyclerviewsample.adapters.RecyclerViewOnItemClickListener;
import com.qzk.recyclerviewsample.layoutmanager.present.IRecyclerViewPresent;
import com.qzk.recyclerviewsample.layoutmanager.present.RecyclerViewPresent;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.linlayoutmanager.view
 * Created by QZK on 2016/4/6.
 */
public class RecyclerViewActivity extends Activity implements IRecycleView,RecyclerViewOnItemClickListener {
    private RecyclerView my_linearlayout_recyclerview;
    private Activity mActivity = RecyclerViewActivity.this;
    private IRecyclerViewPresent linearLayoutRecyclerViewPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        linearLayoutRecyclerViewPresent = new RecyclerViewPresent(mActivity,this,this);
        linearLayoutRecyclerViewPresent.setFlag(getIntent().getIntExtra("flag",1));
        linearLayoutRecyclerViewPresent.setDataSource(50);
        linearLayoutRecyclerViewPresent.setRecyclerView();
    }

    private void initView() {
        my_linearlayout_recyclerview = (RecyclerView) findViewById(R.id.my_linearlayout_recyclerview);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return my_linearlayout_recyclerview;
    }

    @Override
    public void onItemClick(int position) {
        Log.e("====>"+position,linearLayoutRecyclerViewPresent.getDataSource().get(position).getWords());

    }
}
