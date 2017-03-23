package com.yang.blog.launcher;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yang.blog.R;
import com.yang.blog.base.BaseActivity;
import com.yang.blog.home.activity.MainActivity;

public class WelcomeActivity extends BaseActivity {

    private YoYo.YoYoString rope;
    private TextView welcomeactivitynametv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        welcomeactivitynametv = (TextView) findViewById(R.id.welcome_activity_name_tv);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            YoYo.with(Techniques.DropOut).duration(2000)
                    .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                    .interpolate(new AccelerateDecelerateInterpolator())
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                            finish();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    }).playOn(welcomeactivitynametv);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        rope = YoYo.with(Techniques.FadeIn).duration(1000).playOn(welcomeactivitynametv);
    }
}
