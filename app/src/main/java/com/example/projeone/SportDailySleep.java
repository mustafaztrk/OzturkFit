package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportDailySleep extends AppCompatActivity {

    private Button btnLitS,btnMidS,btnMorS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_daily_sleep);

        btnLitS=findViewById(R.id.btnLitS);
        btnMidS=findViewById(R.id.btnMidS);
        btnMorS=findViewById(R.id.btnMorS);

        btnLitS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailySleep="5 Saaten Az";
                startActivity(new Intent(SportDailySleep.this,SportHeightWA.class));
            }
        });
        btnMidS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailySleep="5-8 Saat Arası";
                startActivity(new Intent(SportDailySleep.this,SportHeightWA.class));
            }
        });
        btnMorS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.dailySleep="8 Saaten Fazla";
                startActivity(new Intent(SportDailySleep.this,SportHeightWA.class));
            }
        });

    }
}