package com.qzk.recyclerviewsample.layoutmanager.present;

import com.qzk.recyclerviewsample.layoutmanager.model.LayoutModel;

import java.util.List;

/**
 * 当前类注释：
 * 项目名：RecyclerViewSample
 * 包名： com.qzk.recyclerviewsample.linlayoutmanager.present
 * Created by QZK on 2016/4/6.
 */
public interface IRecyclerViewPresent {
    void setFlag(int flag);

    void setRecyclerView();

    void setDataSource(int size);

    List<LayoutModel> getDataSource();

}
