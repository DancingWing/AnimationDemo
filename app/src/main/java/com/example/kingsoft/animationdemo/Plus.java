package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/7/20.
 */

public class Plus implements IStyle {
    @Override
    public void onCreate(){

    }


    private void setPath1(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(x, y);
        path.lineTo(mWidth, y);
        path.lineTo(mWidth, mHeight);
        path.lineTo(x, mHeight);
        path.close();
    }

    private void setPath2(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth - x, y);
        path.lineTo(mWidth - x, mHeight);
        path.lineTo(0, mHeight);
        path.lineTo(0, y);
        path.close();
    }

    private void setPath3(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth - x, mHeight - y);
        path.lineTo(0, mHeight - y);
        path.lineTo(0, 0);
        path.lineTo(mWidth - x, 0);
        path.close();
    }

    private void setPath4(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(x, mHeight - y);
        path.lineTo(x, 0);
        path.lineTo(mWidth, 0);
        path.lineTo(mWidth, mHeight - y);
        path.close();
    }

    @Override
    public void setStylePath(Path[] mPaths,float x,float y,float mWidth,float mHeight){
        setPath1(mPaths[0],x,y,mWidth, mHeight);
        setPath2(mPaths[1],x,y,mWidth, mHeight);
        setPath3(mPaths[2],x,y,mWidth, mHeight);
        setPath4(mPaths[3],x,y,mWidth, mHeight);
    }

    @Override
    public void onDestroy(){

    }
}