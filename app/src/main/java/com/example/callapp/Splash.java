package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread td = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent it = new Intent(Splash.this,LoginActivity.class);
                    startActivity(it);
                }
            }
        };
        td.start();

    }
}
