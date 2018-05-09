package com.lv77android.layout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static long FADE_DURATION=3000;
    private static long SHOW_DURATION=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fade(View view){
        ImageView imv = findViewById(R.id.image1);
        ImageView imv2 = findViewById(R.id.image2);
        Button bt = findViewById(R.id.fade_button);

        ObjectAnimator ironmanFade = ObjectAnimator.ofFloat(imv, "alpha", 1f, 0f);
        ironmanFade.setDuration(FADE_DURATION);
        ObjectAnimator evilShow = ObjectAnimator.ofFloat(imv2, "alpha", 0f, 1f);
        evilShow.setDuration(FADE_DURATION);
        ObjectAnimator buttonFade = ObjectAnimator.ofFloat(bt, "alpha", 1f, 0f);
        buttonFade.setDuration(FADE_DURATION);


        AnimatorSet ani = new AnimatorSet();
        ani.play(ironmanFade).with(evilShow);
        ani.play(ironmanFade).with(buttonFade);
        ani.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Button bt = findViewById(R.id.fade_button);
                bt.setAlpha(1f);
                bt.setVisibility(View.INVISIBLE);
                Button bt2 = findViewById(R.id.come_button);
                bt2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        ani.start();

    }


    public void fade2(View view){
        ImageView imv = findViewById(R.id.image1);
        ImageView imv2 = findViewById(R.id.image2);
        imv2.animate().alpha(1f).setDuration(500);
        imv.animate().alpha(0f).setDuration(500);

        Button bt = findViewById(R.id.fade_button);
        bt.setVisibility(View.INVISIBLE);

        Button bt2 = findViewById(R.id.come_button);
        bt2.setVisibility(View.VISIBLE);

    }

    public void show(View view) throws InterruptedException {
        ImageView imv = findViewById(R.id.image2);
        ImageView imv2 = findViewById(R.id.image1);
        imv2.animate().alpha(1f).setDuration(500);
        imv.animate().alpha(0f).setDuration(500);

        imv2.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        
        imv2.animate().scaleY(2f).scaleX(2f).setDuration(5000);

        Button bt = findViewById(R.id.fade_button);
        bt.setVisibility(View.VISIBLE);

        Button bt2 = findViewById(R.id.come_button);
        bt2.setVisibility(View.INVISIBLE);

    }
}
