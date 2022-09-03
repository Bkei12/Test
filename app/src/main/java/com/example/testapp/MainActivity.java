package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botton;
    private Button botton2;
    private Button botton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botton = findViewById(R.id.button);
        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
            }
        });

        botton2 = findViewById(R.id.button2);
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MultiActivity.class);
                startActivity(intent);
            }
        });

        botton3 = findViewById(R.id.button3);
        botton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntervalActivity.class);
                startActivity(intent);
            }
        });

    }
}