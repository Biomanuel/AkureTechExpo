package com.biomanuel97.akuretechexpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 1, 1f,
                Animation.RELATIVE_TO_SELF, 0.6f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        logoImageView = findViewById(R.id.logo);
        logoImageView.setAnimation(scaleAnimation);

        new CountDownTimer(5000, 1000) {
            public void onFinish() {
                Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(mainActivity);
                finish();
            }

            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }
}
