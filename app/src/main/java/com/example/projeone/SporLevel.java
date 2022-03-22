package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SporLevel extends AppCompatActivity {

    private Button btnBeginner,btnIntermediate,btnAdvanced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spor_level);



        btnBeginner=findViewById(R.id.btnBeginner);
        btnIntermediate=findViewById(R.id.btnIntermediate);
        btnAdvanced=findViewById(R.id.btnAdvanced);


        btnBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporLevel="Beginner";
                startActivity(new Intent(SporLevel.this,SporAim.class));
            }
        });
        btnIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporLevel="Intermediate";
                startActivity(new Intent(SporLevel.this,SporAim.class));
            }
        });
        btnAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.sporLevel="Advanced";
                startActivity(new Intent(SporLevel.this,SporAim.class));
            }
        });

    }

}