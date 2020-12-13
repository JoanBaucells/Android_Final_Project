package com.uvic.jbaucellsssales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.uvic.jbaucellsssales.ui.login.LoginActivity;
import com.uvic.jbaucellsssales.R;
import com.uvic.jbaucellsssales.Singleton.App_singleton;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final long DELAY = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String username = App_singleton.getInstance().getUser().getUsername();
                if(username.toString().equals("")){
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