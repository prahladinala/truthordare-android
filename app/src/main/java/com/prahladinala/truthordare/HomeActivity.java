package com.prahladinala.truthordare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Random mRandomNumber = new Random();
    private int lastDirection;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mImageView = findViewById(R.id.imageView);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newDirection = mRandomNumber.nextInt(3600) + 360;
                float pivoitX = (float) mImageView.getWidth() / 2;
                float pivoitY = (float) mImageView.getHeight() / 2;

                Animation rotate = new RotateAnimation(lastDirection, newDirection, pivoitX, pivoitY);
                rotate.setDuration(2000);
                rotate.setFillAfter(true);
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mButton.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mButton.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                lastDirection = newDirection;
                mImageView.startAnimation(rotate);
            }
        });
    }
}