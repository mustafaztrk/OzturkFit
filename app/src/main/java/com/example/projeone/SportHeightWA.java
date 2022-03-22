package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SportHeightWA extends AppCompatActivity {

    private ImageButton IBtnDown1,IBtnDown2,IBtnDown3,IBtnUp1,IBtnUp2,IBtnUp3;
    private TextView txtV1,txtV2,txtV3;

    private int temp1,temp2,temp3=0;
    private ImageButton btnHwa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_height_wa);

        IBtnDown1=findViewById(R.id.IBtnDown1);
        IBtnDown2=findViewById(R.id.IBtnDown2);
        IBtnDown3=findViewById(R.id.IBtnDown3);

        IBtnUp1=findViewById(R.id.IBtnUp1);
        IBtnUp2=findViewById(R.id.IBtnUp2);
        IBtnUp3=findViewById(R.id.IBtnUp3);

        txtV1=findViewById(R.id.txtV1);
        txtV2=findViewById(R.id.txtV2);
        txtV3=findViewById(R.id.txtV3);

        btnHwa=findViewById(R.id.btnPoseList);

        //height
        temp1=150;
        IBtnDown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp1>0){
                    temp1--;
                }
                txtV1.setText(temp1+" CM");
            }
        });
        IBtnUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp1<300){
                    temp1++;
                }
                txtV1.setText(temp1+" CM");
            }
        });
        //height

        //weight
        temp2=50;
        IBtnDown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp2>0){
                    temp2--;
                }
                txtV2.setText(temp2+" Kg");
            }
        });
        IBtnUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp2<1000){
                    temp2++;
                }
                txtV2.setText(temp2+" Kg");
            }
        });
        //weight

        //age
        temp3=20;
        IBtnDown3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp3>0){
                    temp3--;
                }
                txtV3.setText(temp3+" ");
            }
        });
        IBtnUp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (temp3<1000){
                    temp3++;
                }
                txtV3.setText(temp3+" ");
            }
        });
        //age


        btnHwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.height=temp1;
                MainActivity.age=temp3;
                MainActivity.weight=temp2;
                if (MainActivity.UserGender==1){
                    startActivity(new Intent(SportHeightWA.this,SportDisabledMan.class));
                }
                else if(MainActivity.UserGender==2){
                    startActivity(new Intent(SportHeightWA.this,SportDisabledWomen.class));
                }
                else{
                    startActivity(new Intent(SportHeightWA.this,SportDisabledNull.class));
                }


            }
        });
    }
}