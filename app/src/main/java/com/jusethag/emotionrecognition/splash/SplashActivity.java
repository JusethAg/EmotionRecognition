package com.jusethag.emotionrecognition.splash;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.jusethag.emotionrecognition.R;
import com.jusethag.emotionrecognition.login.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity{
    @Bind(R.id.logo)
    ImageView logo;
    @Bind(R.id.credits)
    TextView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        showUIElements();

    }

    private void showUIElements() {
        YoYo.with(Techniques.ZoomInUp).duration(700).playOn(logo);

        new CountDownTimer(3000, 3000) {

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }.start();
    }
}
