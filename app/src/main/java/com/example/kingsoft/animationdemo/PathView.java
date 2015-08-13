package com.example.kingsoft.animationdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kingsoft on 2015/7/20.
 */




/*
    //进行图片回收，不回收的话可能会导致程序内存占用过多而崩溃
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(null!=mBitmap0&&!mBitmap0.isRecycled()) mBitmap0.recycle();
        if(null!=mBitmap1&&!mBitmap1.isRecycled()) mBitmap1.recycle();
        if(null!=mBitmap2&&!mBitmap2.isRecycled()) mBitmap2.recycle();
    }
*/

public class PathView extends View {


    private Bitmap mBitmap0 = null;
    private Bitmap mBitmap1 = null;
    private Bitmap mBitmap2 = null;
    private Path[] mPaths = new Path[4];
    private Canvas mCanvas = null;
    float x;
    float y;
    float index = 0;
    float mHeight = 1248;
    float mWidth = 1080;
    IStyle mIStyle;

    public void setStyle(IStyle iStyle) {
        this.mIStyle = iStyle;
    }

    public PathView(Context context, AttributeSet set) {
        super(context, set);
        mBitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.image1);
        mBitmap2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.image2);
        for (int i = 0; i < 4; i++) {
            mPaths[i] = new Path();
        }

        mBitmap0 = Bitmap.createBitmap((int) mWidth, (int) mHeight, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap0);
        mCanvas.drawColor(Color.WHITE);
        x = mWidth;
        y = mHeight;
    }


    public void drawPlus(Canvas canvas) {
        mIStyle.setStylePath(mPaths, x, y, mWidth, mHeight);
        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.XOR);
        mCanvas.drawBitmap(mBitmap1, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[1], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[2], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[3], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        canvas.drawBitmap(mBitmap0, 0, 0, null);
    }

    public void drawShutter(Canvas canvas) {
        mIStyle.setStylePath(mPaths, x, y, mWidth, mHeight);
        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.XOR);
        mCanvas.drawBitmap(mBitmap1, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[1], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[2], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[3], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();

        canvas.drawBitmap(mBitmap0, 0, 0, null);
    }

    public void drawTranslate(Canvas canvas) {
        mIStyle.setStylePath(mPaths, x, y, mWidth, mHeight);
        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.XOR);
        mCanvas.drawBitmap(mBitmap1, 0, 0, null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap2, 0, 0, null);
        mCanvas.restore();
        canvas.drawBitmap(mBitmap0, 0, 0, null);
    }


    public void drawBox(Canvas canvas){
        mIStyle.setStylePath(mPaths,x,y,mWidth,mHeight);
        mCanvas.save();
        mCanvas.clipPath(mPaths[0],Region.Op.XOR);
        mCanvas.drawBitmap(mBitmap2,0,0,null);
        mCanvas.restore();

        mCanvas.save();
        mCanvas.clipPath(mPaths[0], Region.Op.INTERSECT);
        mCanvas.drawBitmap(mBitmap1, 0, 0, null);
        mCanvas.restore();
        canvas.drawBitmap(mBitmap0, 0, 0, null);

    }

    protected void stopDraw(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0, 0, null);
        index = 0;
    }


    public void init() {
        index = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIStyle instanceof Plus) {
            drawPlus(canvas);
            if (x < mWidth / 2.0) {
                stopDraw(canvas, mBitmap2);
            }

        } else if (mIStyle instanceof Shutter) {
            drawShutter(canvas);
            if (x < mWidth * 3.0 / 4.0) {
                stopDraw(canvas, mBitmap2);
            }
        } else if (mIStyle instanceof Translate) {
            drawTranslate(canvas);
            if (x < 0) {
                stopDraw(canvas, mBitmap2);
            }
        }else if(mIStyle instanceof Box){
            drawBox(canvas);
            if(x<mWidth/2.0){
                stopDraw(canvas,mBitmap2);
            }
        }
    }
}

