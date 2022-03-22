package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class UserName extends AppCompatActivity {
    private ImageButton btnNext;

    private EditText edTxtName,edTxtLastName;
    private String ism="MUSTAFA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        btnNext=findViewById(R.id.btnPoseList);
        edTxtName=findViewById(R.id.edTxtName);
        edTxtLastName=findViewById(R.id.edTxtLastName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.UserName=String.valueOf(edTxtName.getText());
                MainActivity.UserLastName=String.valueOf(edTxtLastName.getText());
                startActivity(new Intent(UserName.this,UserGender.class));


            }
        });
    }
}