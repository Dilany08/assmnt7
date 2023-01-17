package com.example.assmnt7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tvAll = findViewById(R.id.tvAll);


        final DataManager dm = new DataManager(this);
        Intent intent = getIntent();
        tvAll.setText(intent.getStringExtra("showall"));



    }
}