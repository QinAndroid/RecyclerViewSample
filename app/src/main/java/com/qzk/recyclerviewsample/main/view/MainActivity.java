package com.qzk.recyclerviewsample.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qzk.recyclerviewsample.R;
import com.qzk.recyclerviewsample.layoutmanager.view.RecyclerViewActivity;
import com.qzk.recyclerviewsample.main.present.IMainPresent;
import com.qzk.recyclerviewsample.main.present.MainPresent;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.main.view
 * Created by QZK on 2016/4/6.
 */
public class MainActivity extends Activity implements View.OnClickListener,IMainView {
    private Button LinearLayoutManager;
    private Button GridLayoutManager;
    private IMainPresent mainPresent;
    private Activity mActivity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresent = new MainPresent(this);
    }

    private void initView() {
        LinearLayoutManager = (Button) findViewById(R.id.LinearLayoutManager);
        GridLayoutManager = (Button) findViewById(R.id.GridLayoutManager);

        LinearLayoutManager.setOnClickListener(this);
        GridLayoutManager.setOnClickListener(this);
    }

    @Override
    public void toLinearLayoutManager() {
        Intent intent = new Intent(mActivity,RecyclerViewActivity.class);
        intent.putExtra("flag",1);
        startActivity(intent);
    }

    @Override
    public void toGridLayoutManager() {
        Intent intent = new Intent(mActivity,RecyclerViewActivity.class);
        intent.putExtra("flag",2);
        startActivity(intent);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LinearLayoutManager:{
                mainPresent.toLinearLayoutManager();
            }
                break;
            case R.id.GridLayoutManager:{
                mainPresent.toGridLayoutManager();
            }
                break;
        }
    }
}
