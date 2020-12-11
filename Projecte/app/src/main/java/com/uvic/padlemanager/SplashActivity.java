package com.uvic.padlemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.uvic.padlemanager.Entitats.User;
import com.uvic.padlemanager.Singleton.App_singleton;
import com.uvic.padlemanager.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final long DELAY = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User u = App_singleton.getInstance().getUser();
                if(u == null){
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(SplashActivity.this, CompetitionGalleryActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, DELAY);
    }

}