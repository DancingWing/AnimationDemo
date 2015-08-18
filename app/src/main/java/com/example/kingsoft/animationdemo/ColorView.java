package com.example.kingsoft.animationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kingsoft on 2015/8/18.
 */
public class ColorView extends View {
    int R = 255, G = 0, B = 0;
    private Paint mPain = null;

    public ColorView(Context context, AttributeSet set) {
        super(context, set);
        this.R = R;
        this.G = G;
        this.B = B;
        mPain = new Paint();
    }

    public void setRGB(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPain.setAntiAlias(true);
        mPain.setColor(Color.rgb(R, G, B));
        int viewWidth = this.getWidth();
        //设置风格为实心
        mPain.setStyle(Paint.Style.FILL);
        canvas.drawCircle(viewWidth * 1 / 2 + 10, viewWidth * 2 / 3 + 10, viewWidth / 3, mPain);
    }


}
