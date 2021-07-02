package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int SPLASH_TIME = 3000; //This is 3 seconds
    ImageView splash_imageView_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        splash_imageView_logo=(ImageView)findViewById(R.id.splash_logo_image_view);
        Animation animation = new AlphaAnimation(0,1);
        animation.setDuration(1500);
        splash_imageView_logo.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME);

    }
}