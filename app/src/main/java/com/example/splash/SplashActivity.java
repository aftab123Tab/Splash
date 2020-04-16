package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {
      Thread objectThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startsplash();
    }
    private void startsplash() {

        try {
            Animation objectAnimation= AnimationUtils.loadAnimation(this,R.anim.translate);

            objectAnimation.reset();
            ImageView objectImageView=findViewById(R.id.splash);



            objectImageView.clearAnimation();
            objectImageView.startAnimation(objectAnimation);
            objectThread = new Thread() {                             ///Create Anonimus class
                @Override
                public void run() {
                    int pauseIt = 0;
                    while (pauseIt < 6000) {


                        try {
                            sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        pauseIt += 100;
                    }
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }
            };
            objectThread.start();




        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }


}
