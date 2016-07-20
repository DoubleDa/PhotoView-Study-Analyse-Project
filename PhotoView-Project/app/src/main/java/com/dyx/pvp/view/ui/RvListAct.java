package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.dyx.pvp.R;
import com.dyx.pvp.constant.Constants;
import com.dyx.pvp.view.adapter.RvListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午11:23
 * alter person：dayongxin
 * alter time：16/7/20 上午11:23
 * alter remark：
 */
public class RvListAct extends Activity {
    @Bind(R.id.rv_list)
    RecyclerView rvList;

    private RvListAdapter mRvListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rv_list_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        rvList.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        rvList.setHasFixedSize(true);
        mRvListAdapter = new RvListAdapter(getImgUrls(), this);
        rvList.setAdapter(mRvListAdapter);

        mRvListAdapter.setmOnRvItemClickListener(new RvListAdapter.OnRvItemClickListener() {
            @Override
            public void itemClicked(int pos) {
                intentTo(PhotoViewDetail.class, getImgUrls().get(pos));
            }
        });
    }

    private void intentTo(Class<?> cla, String imgUrl) {
        Intent intent = new Intent(RvListAct.this, cla);
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_IMAGE_URL", imgUrl);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private List<String> getImgUrls() {
        List<String> list = new ArrayList<>();
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        list.add(Constants.URL_IMG);
        list.add(Constants.URL_IMG0);
        list.add(Constants.URL_IMG1);
        list.add(Constants.URL_IMG2);
        list.add(Constants.URL_IMG3);
        return list;
    }
}
