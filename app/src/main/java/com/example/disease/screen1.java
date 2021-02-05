package com.example.disease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class screen1 extends AppCompatActivity {
    private static int siri = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_screen1);
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( screen1.this,MainActivity .class );
                startActivity( i );
                finish();
            }
        }, siri );
    }
}
