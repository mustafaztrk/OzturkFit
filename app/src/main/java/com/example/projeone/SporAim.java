package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SporAim extends AppCompatActivity {


    private Button btnFat,btnFit,btnHealth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spor_aim);

        btnFat=findViewById(R.id.btnLit);
        btnFit=findViewById(R.id.btnMiddle);
        btnHealth=findViewById(R.id.btnMore);


        btnFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporAim="Kilo Vermek";
                startActivity(new Intent(SporAim.this,SportsWeekly.class));
            }
        });
        btnFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporAim="Kas Yapmak";
                startActivity(new Intent(SporAim.this,SportsTime.class));
            }
        });
        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporAim="Saglıklı Yaşam";
                startActivity(new Intent(SporAim.this,SportsTime.class));
            }
        });

    }
}