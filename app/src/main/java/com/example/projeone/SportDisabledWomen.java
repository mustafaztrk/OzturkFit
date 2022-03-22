package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SportDisabledWomen extends AppCompatActivity {

    private TextView textView14,textView19,textView16,textView23,textView22,textView24,textView21,textView20,textView18;
    private Button btnMLShoulder,btnMRShoulder,btnMLHand,btnMRHand,btnMLKnee,btnMRKnee,btnMLFoot,btnMRFoot,btnMWaist;
    private ImageButton btnNext;
    private int sayac1,sayac2,sayac3,sayac4,sayac5,sayac6,sayac7,sayac8,sayac9=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_disabled_women);

        btnMLShoulder=findViewById(R.id.button11);
        btnMRShoulder=findViewById(R.id.button10);

        btnMLHand=findViewById(R.id.button12);
        btnMRHand=findViewById(R.id.button13);

        btnMLKnee=findViewById(R.id.button17);
        btnMRKnee=findViewById(R.id.button18);

        btnMLFoot=findViewById(R.id.button15);
        btnMRFoot=findViewById(R.id.button16);

        btnMWaist=findViewById(R.id.button14);

        btnNext=findViewById(R.id.btnPoseList);

        textView14=findViewById(R.id.textView14);
        textView14.setText(" ");
        textView19=findViewById(R.id.textView19);
        textView19.setText(" ");
        textView16=findViewById(R.id.textView16);
        textView16.setText(" ");
        textView23=findViewById(R.id.textView23);
        textView23.setText(" ");
        textView22=findViewById(R.id.textView22);
        textView22.setText(" ");
        textView24=findViewById(R.id.textView24);
        textView24.setText(" ");
        textView21=findViewById(R.id.textView21);
        textView21.setText(" ");
        textView20=findViewById(R.id.textView20);
        textView20.setText(" ");
        textView18=findViewById(R.id.textView18);
        textView18.setText(" ");

        MainActivity.UserDisanled[1]=0;
        MainActivity.UserDisanled[2]=0;
        MainActivity.UserDisanled[3]=0;
        MainActivity.UserDisanled[4]=0;
        MainActivity.UserDisanled[5]=0;




        //textView14,textView19,textView16,textView23,textView22,textView24,textView21,textView20,textView18;

        //sol omuz textView14
        btnMLShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac1++;
                if (sayac1==1){
                    textView14.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac1==2){
                    textView14.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;

                }
                else if (sayac1==3){
                    textView14.setText(" ");
                    sayac1=0;
                    MainActivity.UserDisanled[1]=0;

                }


            }
        });

        //sog omuz  textView19
        btnMRShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac2++;
                if (sayac2==1){
                    textView19.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac2==2){
                    textView19.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;

                }
                else if (sayac2==3){
                    textView19.setText(" ");
                    sayac2=0;
                    MainActivity.UserDisanled[1]=0;
                }


            }
        });

        //sol el   textView16
        btnMLHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac3++;               ////////////////
                if (sayac3==1){
                    textView16.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac3==2){
                    textView16.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac3==3){
                    textView16.setText(" ");
                    sayac3=0;/////////////////
                    MainActivity.UserDisanled[2]=0;
                }


            }
        });

        //sag el   textView23

        btnMRHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac4++;               ////////////////
                if (sayac4==1){
                    textView23.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac4==2){
                    textView23.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac4==3){
                    textView23.setText(" ");
                    sayac4=0;/////////////////
                    MainActivity.UserDisanled[2]=0;
                }


            }
        });

        //sol diz textView22
        btnMLKnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac5++;               ////////////////
                if (sayac5==1){
                    textView22.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac5==2){
                    textView22.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac5==3){
                    textView22.setText(" ");
                    sayac5=0;/////////////////
                    MainActivity.UserDisanled[3]=0;
                }
            }
        });

        //sag diz textView24
        btnMRKnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac6++;               ////////////////
                if (sayac6==1){
                    textView24.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac6==2){
                    textView24.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac6==3){
                    textView24.setText(" ");
                    sayac6=0;/////////////////
                    MainActivity.UserDisanled[3]=0;
                }
            }
        });


        //sol ayak textView21

        btnMLFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac7++;               ////////////////
                if (sayac7==1){
                    textView21.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac7==2){
                    textView21.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac7==3){
                    textView21.setText(" ");
                    sayac7=0;/////////////////
                    MainActivity.UserDisanled[4]=0;
                }
            }
        });

        //sag ayak   textView20
        btnMRFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac8++;               ////////////////
                if (sayac8==1){
                    textView20.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac8==2){
                    textView20.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac8==3){
                    textView20.setText(" ");
                    sayac8=0;/////////////////
                    MainActivity.UserDisanled[4]=0;
                }
            }
        });

        //karın ve bel textView18
        btnMWaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac9++;               ////////////////
                if (sayac9==1){
                    textView18.setText("Gecici");
                    MainActivity.UserDisanled[5]++;
                }
                else if(sayac9==2){
                    textView18.setText("Kalıcı");
                    MainActivity.UserDisanled[5]++;

                }
                else if (sayac9==3){
                    textView18.setText(" ");
                    MainActivity.UserDisanled[5]=0;
                }
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SportDisabledWomen.this,SportUser.class));
            }
        });


    }
}