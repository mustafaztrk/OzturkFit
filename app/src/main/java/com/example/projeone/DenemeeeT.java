package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.projeone.Business.Concretes.MovementsManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteMovementsDao;
import com.example.projeone.Entities.Concretes.Movements;

import java.util.ArrayList;

public class DenemeeeT extends AppCompatActivity {
    private DataBaseConnection vt;
    ArrayList<Movements> movementsArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calis_baba_laa);


       // startActivity(new Intent(DenemeeeT.this,PoseList.class));

        Intent yeniInstant=new Intent(DenemeeeT.this, SportFitness.class);
        yeniInstant.putExtra("Egzersiz",true);

        startActivity(yeniInstant);

        vt=new DataBaseConnection(this);


        MovementsManager movementsManager=new MovementsManager(new SQLiteMovementsDao(vt));


        Movements m1=new Movements();
        m1.setName("sinav");
        m1.setLevelId(1);
        m1.setArea("gögüs");


        Movements m2=new Movements();
        m2.setName("mekik");
        m2.setLevelId(1);
        m2.setArea("karin");

        Movements m3=new Movements();
        m3.setName("plank");
        m3.setLevelId(1);
        m3.setArea("karin");


    //   movementsManager.Add(m1);
      //  movementsManager.Add(m2);
        //movementsManager.Add(m3);

        Log.e("h-geldi",String.valueOf(movementsManager.GetAll().size()));
       for (Movements m: movementsManager.GetAll()){
            Log.e(m.getName(),m.getArea());
        }

       finish();



    }
}