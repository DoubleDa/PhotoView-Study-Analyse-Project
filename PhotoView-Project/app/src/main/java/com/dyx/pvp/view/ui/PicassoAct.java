package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.os.Bundle;

import com.dyx.pvp.R;
import com.dyx.pvp.constant.Constants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午11:14
 * alter person：dayongxin
 * alter time：16/7/20 上午11:14
 * alter remark：
 */
public class PicassoAct extends Activity {
    @Bind(R.id.pv_sample)
    PhotoView pvSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_picasso_layout);
        ButterKnife.bind(this);

        final PhotoViewAttacher attacher = new PhotoViewAttacher(pvSample);

        Picasso.with(this).load(Constants.URL_IMG).into(pvSample, new Callback() {
            @Override
            public void onSuccess() {
                attacher.update();
            }

            @Override
            public void onError() {

            }
        });
    }
}
