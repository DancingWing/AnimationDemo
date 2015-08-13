package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/7/20.
 */

public  class Shutter  implements IStyle {
    @Override
    public void onCreate() {

    }


    private void setPath1(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth, mHeight);
        path.lineTo(x, mHeight);
        path.lineTo(x, 0);
        path.lineTo(mWidth, 0);
        path.close();

    }

    private void setPath2(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth - mWidth * 1 / 4, mHeight);
        path.lineTo(x - mWidth * 1 / 4, mHeight);
        path.lineTo(x - mWidth * 1 / 4, 0);
        path.lineTo(mWidth - mWidth * 1 / 4, 0);
        path.close();
    }

    private void setPath3(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth - mWidth * 2 / 4, mHeight);
        path.lineTo(x - mWidth * 2 / 4, mHeight);
        path.lineTo(x - mWidth * 2 / 4, 0);
        path.lineTo(mWidth - mWidth * 2 / 4, 0);
        path.close();
    }

    private void setPath4(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth - mWidth * 3 / 4, mHeight);
        path.lineTo(x - mWidth * 3 / 4, mHeight);
        path.lineTo(x - mWidth * 3 / 4, 0);
        path.lineTo(mWidth - mWidth * 3 / 4, 0);
        path.close();

    }

    @Override
    public void setStylePath(Path[] mPaths,float x,float y,float mWidth,float mHeight){
        setPath1(mPaths[0], x, y, mWidth, mHeight);
        setPath2(mPaths[1], x, y, mWidth, mHeight);
        setPath3(mPaths[2], x, y, mWidth, mHeight);
        setPath4(mPaths[3], x, y, mWidth, mHeight);
    }

    @Override
    public void onDestroy(){

    }
}
