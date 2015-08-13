package com.example.kingsoft.animationdemo;

import android.graphics.Path;

/**
 * Created by kingsoft on 2015/7/25.
 */
public interface IStyle {
    public abstract void onCreate();
    public abstract void setStylePath(Path[] mPaths, float x, float y, float mWidth, float mHeight);
    public abstract void onDestroy();
}
