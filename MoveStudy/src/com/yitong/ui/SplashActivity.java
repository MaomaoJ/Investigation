package com.yitong.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

import com.example.movestudy.R;

import com.umeng.update.UmengUpdateAgent;
import com.yitong.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.start_activity, null);
        setContentView(view);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);//使用AnimationUtils类的静态方法loadAnimation()来加载XML中的动画XML文件
        view.startAnimation(animation);
        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        goHome();
                    }
                }, 500);//启动一个定时器，使0.5秒后执行这个线程
            }
        });
      
    }

    protected void onResume() {
        super.onResume();
    }

    private void goHome() {
        openActivity(LoginActivity.class);
        defaultFinish();
    }

    ;

}
