package com.example.kingsoft.animationdemo;

import android.app.TabActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    private boolean mTimeOn1 = false;
    private boolean mTimeOn2 = true;
    private static final int UPDATE_VIEW1 = 1;
    private double step = 0;


    Plus mPlus = new Plus();
    Shutter mShutter = new Shutter();
    Translate mTranslate = new Translate();
    Box mBox=new Box();
    Triangle mTriangle=new Triangle();
    PathView mPathView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取该Activity里面的TabHost组件
        TabHost tabHost = getTabHost();
        // 创建并添加第一个Tab页
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator("剪裁") // 设置标题
                .setContent(R.id.tab01); //设置内容
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                // 在标签标题上放置图标
                .setIndicator("位移")
                .setContent(R.id.tab02);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("缩放/旋转")
                .setContent(R.id.tab03);
        tabHost.addTab(tab3);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("tab4")
                .setIndicator("颜色")
                .setContent(R.id.tab04);
        tabHost.addTab(tab4);

        mPathView = (PathView) findViewById(R.id.pathView);
        Button bPlus = (Button) findViewById(R.id.plus);
        Button bShutter = (Button) findViewById(R.id.shutter);
        Button bTranslate = (Button) findViewById(R.id.translate);
        Button bBox=(Button) findViewById(R.id.box);
        Button bTriangle=(Button) findViewById(R.id.triangle);
        final Button bSubmit = (Button) findViewById(R.id.submit);

        final EditText eTime = (EditText) findViewById(R.id.time);

        //获取View的高和宽
        ViewTreeObserver vto = mPathView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mPathView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mPathView.mHeight = mPathView.getHeight();
                mPathView.mWidth = mPathView.getWidth();
            }
        });


        final Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == UPDATE_VIEW1) {
                    mPathView.index += step;
                    mPathView.x = mPathView.mWidth - mPathView.index;
                    mPathView.y = mPathView.x * (mPathView.mHeight / mPathView.mWidth);
                    mPathView.invalidate();

                }
            }
        };


        //获取高宽

        final TimerForRedraw mTimerForRedraw = new TimerForRedraw(mHandler);

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //避免出现点击按钮会越来越快
                mPathView.setStyle(mPlus);
                mPathView.init();
                bSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            //根据用户输入的时间确定步长
                            step = (mPathView.mWidth / (2.0 * 10)) / (Integer.parseInt(eTime.getText().toString()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!mTimeOn1) {
                            mTimeOn1 = true;
                            mPathView.init();
                            mTimerForRedraw.schedule1();

                        } else {
                            mPathView.init();
                        }

                    }
                });
            }
        });
        //设置百叶窗效果
        bShutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                mPathView.setStyle(mShutter);
                mPathView.init();
                bSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            step = (mPathView.mWidth / (4 * 10)) / (Integer.parseInt(eTime.getText().toString()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!mTimeOn1) {
                            mTimeOn1 = true;
                            mPathView.init();
                            mTimerForRedraw.schedule1();
                        } else {
                            mPathView.init();
                        }
                    }
                });
            }
        });

        //设置切换效果
        bTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPathView.setStyle(mTranslate);
                mPathView.init();
                bSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            step = (mPathView.mWidth / 10) / (Integer.parseInt(eTime.getText().toString()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!mTimeOn1) {
                            mTimeOn1 = true;
                            mPathView.init();
                            mTimerForRedraw.schedule1();
                        } else {
                            mPathView.init();
                        }

                    }

                });
            }
        });

        //设置盒状效果
        bBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPathView.setStyle(mBox);
                mPathView.init();
                bSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            step = (mPathView.mWidth / (2*10)) / (Integer.parseInt(eTime.getText().toString()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!mTimeOn1) {
                            mTimeOn1 = true;
                            mPathView.init();
                            mTimerForRedraw.schedule1();
                        } else {
                            mPathView.init();
                        }

                    }

                });
            }
        });


        bTriangle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPathView.setStyle(mTriangle);
                mPathView.init();
                bSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            step = (mPathView.mWidth / (2*10)) / (Integer.parseInt(eTime.getText().toString()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!mTimeOn1) {
                            mTimeOn1 = true;
                            mPathView.init();
                            mTimerForRedraw.schedule1();
                        } else {
                            mPathView.init();
                        }

                    }

                });
            }
        });
    }


}

