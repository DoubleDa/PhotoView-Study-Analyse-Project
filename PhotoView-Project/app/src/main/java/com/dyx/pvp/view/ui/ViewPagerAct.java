package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.dyx.pvp.R;
import com.dyx.pvp.view.adapter.ViewPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午10:43
 * alter person：dayongxin
 * alter time：16/7/20 上午10:43
 * alter remark：
 */
public class ViewPagerAct extends Activity {
    @Bind(R.id.vp_sample)
    ViewPager vpSample;
    private int[] mResId = {R.mipmap.my_img, R.mipmap.my_img, R.mipmap.my_img, R.mipmap.my_img, R.mipmap.my_img, R.mipmap.my_img};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_pager_layout);
        ButterKnife.bind(this);
        vpSample.setAdapter(new ViewPagerAdapter(mResId));
    }

}
