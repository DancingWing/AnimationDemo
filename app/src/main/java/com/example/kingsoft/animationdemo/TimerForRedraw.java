package com.example.kingsoft.animationdemo;

import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kingsoft on 2015/7/24.
 */

public class TimerForRedraw {


    private static final int UPDATE_VIEW1 = 1;
    private static final int UPDATE_VIEW2 = 2;
    final Timer mTimer = new Timer();
    public int delay = 100;
    private Handler mHandler;

    public TimerForRedraw(Handler handler) {
        this.mHandler = handler;

    }

    //剪裁的计时器
    public void schedule1() {

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(UPDATE_VIEW1);
            }
        }, 0, delay);
    }

    //位移的计时器
    public void schedule2(){
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(UPDATE_VIEW2);
            }
        },0,delay);
    }


}
