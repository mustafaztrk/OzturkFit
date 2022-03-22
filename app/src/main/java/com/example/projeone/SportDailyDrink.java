package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportDailyDrink extends AppCompatActivity {

    private Button btnLittle,btnMiddle,btnMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_daily_drink);

        btnLittle=findViewById(R.id.btnLit);
        btnMiddle=findViewById(R.id.btnMiddle);
        btnMore=findViewById(R.id.btnMore);


        btnLittle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailyDrink="1.5 Litreden Az";
                startActivity(new Intent(SportDailyDrink.this,SportDailySleep.class));
            }
        });
        btnMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailyDrink="1.5-3 Litre Arasında";
                startActivity(new Intent(SportDailyDrink.this,SportDailySleep.class));
            }
        });
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailyDrink="3 Litreden Fazla";
                startActivity(new Intent(SportDailyDrink.this,SportDailySleep.class));
            }
        });

    }
}