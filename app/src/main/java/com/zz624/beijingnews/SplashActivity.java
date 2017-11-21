package com.zz624.beijingnews;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends Activity {

    private RelativeLayout rl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);


        //渐变动画，缩放动画，旋转动画
        AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setDuration(500);//持续播放时间
        aa.setFillAfter(true);//播放完成停留状态

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        //添加三个动画没有先后,便于同时播放动画
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(2000);//这里设置了时间之后就会覆盖之间的动画时间设置

        rl_splash_root.startAnimation(set);
        set.setAnimationListener(new MyAnimationListener());
    }
    class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {
            /**
             * 当动画开始播放的时候回调这个方法
             */
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            /**
             * 当动画播放完成的时候回调这个方法
             */
            Toast.makeText(SplashActivity.this, "动画播放完成了",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            /**
             * 当动画重复播放的时候回调这个方法
             */
        }
    }
}
