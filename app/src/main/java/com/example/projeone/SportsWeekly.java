package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SportsWeekly extends AppCompatActivity {

    private ImageButton IBtnDown,IBtnUp;
    private ImageButton btnNxt2;
    private TextView txtTimee;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_weekly);

        IBtnDown=findViewById(R.id.IBtnDown);
        IBtnUp=findViewById(R.id.IBtnUp);
        btnNxt2=findViewById(R.id.btnPoseList);

        time=1;
        txtTimee=findViewById(R.id.txtTimee);
        txtTimee.setText(time+" Gün");

        IBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (time>1){
                    time--;
                    txtTimee.setText(time+" Gün");

                }
            }
        });
        IBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (time<7){
                    time++;
                    txtTimee.setText(time+" Gün");

                }
            }
        });
        btnNxt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporTimeW=time;
                startActivity(new Intent(SportsWeekly.this,SportDailyDrink.class));
            }
        });



    }
}