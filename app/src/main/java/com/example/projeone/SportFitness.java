package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class SportFitness extends AppCompatActivity {
    private ImageButton IBtnFullBody,IBtnLegWorkout,IBtnChest,IBtnSixpack,IBtnArm,IBtnShoulderBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_fitness);


        IBtnFullBody=findViewById(R.id.IBtnFitness);
        IBtnLegWorkout=findViewById(R.id.IBtnYoga);
        IBtnChest=findViewById(R.id.IBtnChest);
        IBtnSixpack=findViewById(R.id.IBtnSixpack);
        IBtnShoulderBack=findViewById(R.id.IBtnShoulderBack);
        IBtnArm=findViewById(R.id.IBtnArm);


        IBtnFullBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(HomeFragment.this,PoseList.class);


                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","Full");
                startActivity(yeniInstant);
            }
        });
        IBtnLegWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","bacak");
                startActivity(yeniInstant);
            }
        });

        IBtnChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","gögüs");
                startActivity(yeniInstant);
            }
        });

        IBtnSixpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","karın");
                startActivity(yeniInstant);
            }
        });

        IBtnShoulderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","omuz ve sırt");
                startActivity(yeniInstant);
            }
        });

        IBtnArm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yeniInstant=new Intent(SportFitness.this, PoseList.class);
                yeniInstant.putExtra("Egzersiz",true);
                yeniInstant.putExtra("Area","kol");
                startActivity(yeniInstant);
            }
        });


    }
}