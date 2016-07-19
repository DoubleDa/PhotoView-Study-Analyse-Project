package com.dyx.pvp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends Activity {

    @Bind(R.id.iv)
    ImageView iv;
    private PhotoViewAttacher attacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Drawable drawable = getResources().getDrawable(R.mipmap.my_img);
        iv.setImageDrawable(drawable);

        attacher = new PhotoViewAttacher(iv);
    }


}
