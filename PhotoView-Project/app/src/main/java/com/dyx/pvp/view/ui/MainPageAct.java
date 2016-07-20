package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.pp.library.view.DividerItemDecoration;
import com.dyx.pvp.R;
import com.dyx.pvp.view.adapter.MainPageAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午9:54
 * alter person：dayongxin
 * alter time：16/7/20 上午9:54
 * alter remark：
 */
public class MainPageAct extends Activity {
    @Bind(R.id.rv_main)
    RecyclerView rvMain;
    private MainPageAdapter mMainPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_page_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setHasFixedSize(true);
        rvMain.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void initData() {
        String[] arrays = getResources().getStringArray(R.array.menu_names);
        List<String> list = Arrays.asList(arrays);
        mMainPageAdapter = new MainPageAdapter(list, this);
        rvMain.setAdapter(mMainPageAdapter);
        mMainPageAdapter.setMonRvItemClickListener(new MainPageAdapter.onRvItemClickListener() {
            @Override
            public void itemClick(int position) {
                switch (position) {
                    case 0:
                        intentTo(SimpleUseAct.class);
                        break;
                    case 1:
                        intentTo(ViewPagerAct.class);
                        break;
                    case 2:
                        intentTo(RotateAct.class);
                        break;
                    case 3:
                        intentTo(PicassoAct.class);
                        break;
                    case 4:
                        intentTo(RvListAct.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void intentTo(Class<?> cla) {
        Intent intent = new Intent(MainPageAct.this, cla);
        startActivity(intent);
    }
}
