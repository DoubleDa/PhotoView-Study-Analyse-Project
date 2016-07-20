package com.dyx.pvp.view.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.dyx.pvp.R;

import uk.co.senab.photoview.PhotoView;

/**
 * project name：PhotoView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/20 上午11:02
 * alter person：dayongxin
 * alter time：16/7/20 上午11:02
 * alter remark：
 */
public class RotateAct extends AppCompatActivity {
    private PhotoView mPhotoView;
    private final Handler mHandler = new Handler();
    private boolean isRotate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPhotoView = new PhotoView(this);
        mPhotoView.setImageResource(R.mipmap.my_img);
        setContentView(mPhotoView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 0, Menu.NONE, "Rotate 10° Right");
        menu.add(Menu.NONE, 1, Menu.NONE, "Rotate 10° Left");
        menu.add(Menu.NONE, 2, Menu.NONE, "Toggle automatic rotation");
        menu.add(Menu.NONE, 3, Menu.NONE, "Reset to 0");
        menu.add(Menu.NONE, 4, Menu.NONE, "Reset to 90");
        menu.add(Menu.NONE, 5, Menu.NONE, "Reset to 180");
        menu.add(Menu.NONE, 6, Menu.NONE, "Reset to 270");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                mPhotoView.setRotationBy(10);
                return true;
            case 1:
                mPhotoView.setRotationBy(-10);
                return true;
            case 2:
                toggleRotation();
                return true;
            case 3:
                mPhotoView.setRotationTo(0);
                return true;
            case 4:
                mPhotoView.setRotationTo(90);
                return true;
            case 5:
                mPhotoView.setRotationTo(180);
                return true;
            case 6:
                mPhotoView.setRotationTo(270);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleRotation() {
        if (isRotate) {
            mHandler.removeCallbacksAndMessages(null);
        } else {
            rotateLoop();
        }
        isRotate = !isRotate;
    }

    private void rotateLoop() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPhotoView.setRotationBy(1);
                rotateLoop();
            }
        }, 20);
    }

}
