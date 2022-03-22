package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;

import java.util.ArrayList;

public class PoseList extends AppCompatActivity {
    private ImageButton btnPoseList;
    private Spinner spinner;
    private ArrayList<String> BgnList=new ArrayList<String>();
    private ArrayList<String> IntList=new ArrayList<String>();
    private ArrayList<String> AdvList=new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapter;
    private int userChoice=0; //Kullanıcının kayıt bilgilerinde belirttigi günlük spor süresi
    private String temp="";

    private String Area="";
    private Boolean Egzersiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pose_list);


        Egzersiz=getIntent().getBooleanExtra("Egzersiz",false);
        Area=getIntent().getStringExtra("Area");
        if(!Area.equals(" ")){
            Log.e("buradaaaa","asda");
            if (!Area.equals("Full")){
                Intent yeniInstant=new Intent(PoseList.this, FitnessListDevam.class);

                yeniInstant.putExtra("süre","5");
                yeniInstant.putExtra("Area",Area);

                finish();


                startActivity(yeniInstant);
            }
        }




        btnPoseList=findViewById(R.id.btnPoseList);
        spinner=findViewById(R.id.spinner);

        BgnList.add("5");
        BgnList.add("10");
        BgnList.add("15");

        IntList.add("20");
        IntList.add("25");
        IntList.add("30");

        AdvList.add("30");
        AdvList.add("35");

        userChoice=10;///////////// db den gelicek

        if (userChoice<16){
            arrayAdapter=new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,BgnList);
        }
        else if (userChoice>15&&userChoice<30){
            arrayAdapter=new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,IntList);
        }
        else{
            arrayAdapter=new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,AdvList);




        }


        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (userChoice<16){
                    temp=BgnList.get(i);
                }
                else if (userChoice>15&&userChoice<30){
                    temp=IntList.get(i);
                }
                else{
                    temp=AdvList.get(i);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });





        btnPoseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // Intent yeniInstant=new Intent(PoseList.this, PoseListDevam.class);
                if (Egzersiz){
                    Intent yeniInstant=new Intent(PoseList.this, FitnessListDevam.class);
                    yeniInstant.putExtra("süre",temp);
                    yeniInstant.putExtra("Area",Area);


                    startActivity(yeniInstant);
                }
                 else {
                    Intent yeniInstant=new Intent(PoseList.this, PoseListDevam.class);
                    yeniInstant.putExtra("süre",temp);
                    yeniInstant.putExtra("Area"," ");
                    startActivity(yeniInstant);
                }

                Log.e("Secilen",temp);


            }

        });




    }
}