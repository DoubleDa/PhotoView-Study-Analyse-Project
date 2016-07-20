package com.dyx.pvp.view.ui;

import android.app.Activity;
import android.os.Bundle;

import com.dyx.pvp.R;
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
 * create time：16/7/20 上午11:49
 * alter person：dayongxin
 * alter time：16/7/20 上午11:49
 * alter remark：
 */
public class PhotoViewDetail extends Activity {
    @Bind(R.id.pv_sample)
    PhotoView pvSample;
    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_photo_view_detail_layout);
        imgUrl = getIntent().getStringExtra("INTENT_IMAGE_URL");
        ButterKnife.bind(this);


        final PhotoViewAttacher attacher = new PhotoViewAttacher(pvSample);

        Picasso.with(this).load(imgUrl).into(pvSample, new Callback() {
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
