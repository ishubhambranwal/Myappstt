package com.gola.myappstt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class sp extends AppCompatActivity {


    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);


       /* getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAGS_CHANGED);*/

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(sp.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}