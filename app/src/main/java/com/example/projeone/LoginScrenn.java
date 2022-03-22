package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LoginScrenn extends AppCompatActivity {

   private ImageButton btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screnn);

        btnNext= findViewById(R.id.btnPoseList);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent newIntent=new Intent(LoginScrenn.this,SporLevel.class);
                //startActivity(newIntent);
                startActivity(new Intent(LoginScrenn.this,UserName.class));


            }
        });

    }
}