package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.dyx.pvp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午9:59
 * alter person：dayongxin
 * alter time：16/7/20 上午9:59
 * alter remark：
 */
public class SimpleUseAct extends Activity {
    @Bind(R.id.iv_simple_use)
    ImageView ivSimpleUse;
    private PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_use_layout);
        ButterKnife.bind(this);

        Drawable drawable = getResources().getDrawable(R.mipmap.my_img, null);
        ivSimpleUse.setImageDrawable(drawable);

        attacher = new PhotoViewAttacher(ivSimpleUse);
    }
}
