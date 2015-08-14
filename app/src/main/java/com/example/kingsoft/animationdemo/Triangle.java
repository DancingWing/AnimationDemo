package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/8/13.
 */

public class Triangle implements IStyle {
    @Override
    public void onCreate() {

    }


    private void setPath1(Path path, float x, float y, float mWeight, float mHeight) {
        path.reset();
        path.moveTo(x, y);
        path.lineTo(mWeight - x, y);
        path.lineTo((mWeight/2), mHeight-y);
        //path.lineTo(x, y);
        path.close();
    }

    @Override
    public void setStylePath(Path[] mPaths, float x, float y, float mWeight, float mHeight) {
        setPath1(mPaths[0], x, y, mWeight, mHeight);
    }

    @Override
    public void onDestroy() {

    }
}