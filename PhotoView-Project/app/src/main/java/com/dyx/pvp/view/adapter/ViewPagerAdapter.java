package com.dyx.pvp.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import uk.co.senab.photoview.PhotoView;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午10:49
 * alter person：dayongxin
 * alter time：16/7/20 上午10:49
 * alter remark：
 */
public class ViewPagerAdapter extends PagerAdapter {
    private int[] mResId;

    public ViewPagerAdapter(int[] mResId) {
        this.mResId = mResId;
    }

    @Override
    public int getCount() {
        return mResId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
        photoView.setImageResource(mResId[position]);

        container.addView(photoView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
