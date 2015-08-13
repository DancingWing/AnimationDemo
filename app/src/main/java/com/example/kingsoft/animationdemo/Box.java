package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/8/13.
 */
public class Box implements IStyle{
    @Override
    public void onCreate(){

    }


    private void setPath1(Path path,float x,float y,float mWeight,float mHeight){
        path.reset();
        path.moveTo(x, y);
        path.lineTo(mWeight-x, y);
        path.lineTo(mWeight-x, mHeight-y);
        path.lineTo(x, mHeight-y);
        path.close();
    }

    @Override
    public void setStylePath(Path[] mPaths,float x,float y,float mWidth,float mHeight){
        setPath1(mPaths[0], x, y, mWidth, mHeight);
    }

    @Override
    public void onDestroy(){

    }
}
