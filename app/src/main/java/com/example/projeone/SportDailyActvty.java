package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportDailyActvty extends AppCompatActivity {
    private Button btnStill,btnSit,btnOnFaat,btnEnergetic;
    public static String dailyActvty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_daily_actvty);

        btnStill=findViewById(R.id.btnStill);
        btnSit=findViewById(R.id.btnSit);
        btnOnFaat=findViewById(R.id.btnOnFaat);
        btnEnergetic=findViewById(R.id.btnEnergetic);

        btnStill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailyActvty="Evde, genellikle hareketsiz";
                startActivity(new Intent(SportDailyActvty.this,SportDailyDrink.class));
            }
        });
        btnSit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailyActvty="Genellikle oturarak";
                startActivity(new Intent(SportDailyActvty.this,SportDailyDrink.class));
            }
        });
        btnOnFaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailyActvty="Genellikle Ayakta";
                startActivity(new Intent(SportDailyActvty.this,SportDailyDrink.class));

            }
        });
        btnEnergetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailyActvty="Genellikle yürüyerek ve aktif";
                startActivity(new Intent(SportDailyActvty.this,SportDailyDrink.class));

            }
        });

    }
}