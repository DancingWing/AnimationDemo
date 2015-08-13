package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/7/20.
 */

public class Translate implements IStyle {
    @Override
    public void onCreate(){
    }

    private void setPath1(Path path,float x,float y,float mWidth,float mHeight){
        path.reset();
        path.moveTo(mWidth, mHeight);
        path.lineTo(x, mHeight);
        path.lineTo(x, 0);
        path.lineTo(mWidth, 0);
        path.close();

    }

    @Override
    public void setStylePath(Path[] mPaths,float x,float y,float mWidth,float mHeight){
        setPath1(mPaths[0],x,y,mWidth, mHeight);
    }

    @Override
   public void onDestroy(){
    }
}

