package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SportsTime extends AppCompatActivity {

    private ImageButton btnDown,btnUp;
    private TextView txtTime;
    private int time=10;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_time);

        btnUp=findViewById(R.id.btnUp);
        btnDown=findViewById(R.id.btnDown);
        txtTime=findViewById(R.id.txtTime);
        btnNext=findViewById(R.id.btnPoseList);

        txtTime.setText(time+" dk");


        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (time>10){
                    time--;
                    txtTime.setText(time+" dk");
                }
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (time<200){
                    time++;
                    txtTime.setText(time+" dk");
                }

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporTimeD=time;
                startActivity(new Intent(SportsTime.this,SportsWeekly.class));

            }
        });
    }
}