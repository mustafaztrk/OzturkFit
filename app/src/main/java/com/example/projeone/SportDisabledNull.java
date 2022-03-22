package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SportDisabledNull extends AppCompatActivity {

    private TextView textView27,textView36,textView37,textView25,textView38,textView35,textView39,textView40,textView29;
    private Button btnMLShoulder,btnMRShoulder,btnMLHand,btnMRHand,btnMLKnee,btnMRKnee,btnMLFoot,btnMRFoot,btnMWaist;
    private ImageButton btnNext;
    private int sayac1,sayac2,sayac3,sayac4,sayac5,sayac6,sayac7,sayac8,sayac9=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_disabled_null);

        btnMLShoulder=findViewById(R.id.button19);
        btnMRShoulder=findViewById(R.id.button20);

        btnMLHand=findViewById(R.id.button21);
        btnMRHand=findViewById(R.id.button22);

        btnMLKnee=findViewById(R.id.button24);
        btnMRKnee=findViewById(R.id.button25);

        btnMLFoot=findViewById(R.id.button26);
        btnMRFoot=findViewById(R.id.button27);

        btnMWaist=findViewById(R.id.button23);

        btnNext=findViewById(R.id.btnPoseList);

        textView27=findViewById(R.id.textView27);
        textView27.setText(" ");
        textView36=findViewById(R.id.textView36);
        textView36.setText(" ");
        textView37=findViewById(R.id.textView37);
        textView37.setText(" ");
        textView25=findViewById(R.id.textView25);
        textView25.setText(" ");
        textView38=findViewById(R.id.textView38);
        textView38.setText(" ");
        textView35=findViewById(R.id.textView35);
        textView35.setText(" ");
        textView39=findViewById(R.id.textView39);
        textView39.setText(" ");
        textView40=findViewById(R.id.textView40);
        textView40.setText(" ");
        textView29=findViewById(R.id.textView29);
        textView29.setText(" ");

        MainActivity.UserDisanled[1]=0;
        MainActivity.UserDisanled[2]=0;
        MainActivity.UserDisanled[3]=0;
        MainActivity.UserDisanled[4]=0;
        MainActivity.UserDisanled[5]=0;


        //sol omuz textView27
        btnMLShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac1++;
                if (sayac1==1){
                    textView27.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac1==2){
                    textView27.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;

                }
                else if (sayac1==3){
                    textView27.setText(" ");
                    sayac1=0;
                    MainActivity.UserDisanled[1]=0;
                }


            }
        });

        //sog omuz  textView36
        btnMRShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac2++;
                if (sayac2==1){
                    textView36.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac2==2){
                    textView36.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;

                }
                else if (sayac2==3){
                    textView36.setText(" ");
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
                    textView37.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac3==2){
                    textView37.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac3==3){
                    textView37.setText(" ");
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
                    textView25.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac4==2){
                    textView25.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac4==3){
                    textView25.setText(" ");
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
                    textView38.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac5==2){
                    textView38.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac5==3){
                    textView38.setText(" ");
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
                    textView35.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac6==2){
                    textView35.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac6==3){
                    textView35.setText(" ");
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
                    textView39.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac7==2){
                    textView39.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac7==3){
                    textView39.setText(" ");
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
                    textView40.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac8==2){
                    textView40.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac8==3){
                    textView40.setText(" ");
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
                    textView29.setText("Gecici");
                    MainActivity.UserDisanled[5]++;
                }
                else if(sayac9==2){
                    textView29.setText("Kalıcı");
                    MainActivity.UserDisanled[5]++;

                }
                else if (sayac9==3){
                    textView29.setText(" ");
                    sayac9=0;/////////////////
                    MainActivity.UserDisanled[5]=0;
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SportDisabledNull.this,Home.class));
            }
        });

    }
}