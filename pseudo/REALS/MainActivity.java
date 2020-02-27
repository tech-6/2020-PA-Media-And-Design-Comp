package com.iantimchak.aquasafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    WaterData none = new WaterData();

    Button samples;
    Button newsample;
    Button analyze;

    TextView listsize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listsize = findViewById(R.id.sizelist);

        String num = "";
        num+= none.getList().size();

        listsize.setText(num);

        samples = findViewById(R.id.List);
        newsample = findViewById(R.id.NewSample);
        analyze = findViewById(R.id.Analyze);

        samples.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SampleList.class));
            }
        });

        newsample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewSample.class));
            }
        });

    }
}
