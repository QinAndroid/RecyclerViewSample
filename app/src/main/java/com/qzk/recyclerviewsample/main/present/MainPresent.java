package com.qzk.recyclerviewsample.main.present;

import com.qzk.recyclerviewsample.main.view.IMainView;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.main.present
 * Created by QZK on 2016/4/6.
 */
public class MainPresent implements IMainPresent{

    private IMainView mainView;
    public MainPresent(IMainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void toLinearLayoutManager() {
        this.mainView.toLinearLayoutManager();
    }

    @Override
    public void toGridLayoutManager() {
        this.mainView.toGridLayoutManager();
    }


}
