package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projeone.Entities.Concretes.User;

public class UserGender extends AppCompatActivity {

    private ImageButton IBtnMan,IBtnWomen,IBtnNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_gender);

        IBtnMan=findViewById(R.id.IBtnMan);
        IBtnWomen=findViewById(R.id.IBtnWomen);
        IBtnNull=findViewById(R.id.IBtnNull);

        IBtnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.UserGender=1;
                Intent newIntent=new Intent(UserGender.this,SporLevel.class);
                startActivity(newIntent);
            }
        });
        IBtnWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.UserGender=2;
                Intent newIntent=new Intent(UserGender.this,SporLevel.class);
                startActivity(newIntent);
            }
        });
        IBtnNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.UserGender=3;
                Intent newIntent=new Intent(UserGender.this,SporLevel.class);
                startActivity(newIntent);
            }
        });


    }
}