package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.AkısManager;
import com.example.projeone.Business.Concretes.FitnessAkisManager;
import com.example.projeone.Business.Concretes.MovementsManager;
import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteAkısDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteMovementsDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLitePosesDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.Movements;
import com.example.projeone.Entities.Concretes.Poses;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;

public class FitnessListDevam extends AppCompatActivity {
    private DataBaseConnection vt;
    public TextView txtTime;
    private TextView txtPoseName;

    private Handler h;
    private Handler h2;
    private Handler h3;


    private  int sayac=50;
    private  int dinlen=10;
    private  int duraklat=0;
    private ArrayList<Movements> pozlar=new ArrayList<>();
    private String str;
    private int poseNum=0;
    private  int time;
    private ImageView img;
    private String imgId="anonim";
    private int temp = 0;
    private ImageView imgClose;
    private int extra=0; // program yarısında cıkarsa arta kalan süreyi konturol edicek
    private String experience;
    private int level;
    private String Area;
    private ImageButton imgclose;


    /////
    private ImageButton IBtnFoto;
    private Movements m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_list_devam);


        Area=getIntent().getStringExtra("Area");


        vt=new DataBaseConnection(this);


        IBtnFoto=findViewById(R.id.IBtnFoto); //

        txtTime=findViewById(R.id.txtTime);
        txtPoseName=findViewById(R.id.txtPoseName);



        imgclose=findViewById(R.id.imgclose);
        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FitnessListDevam.this,Home.class));
            }
        });




        String gelen=getIntent().getStringExtra("süre"); ///



       // Log.e("spor süresiii",gelen);

        MovementsManager movementsManager=new MovementsManager(new SQLiteMovementsDao(vt));


        FitnessAkisManager akis=new FitnessAkisManager(new SQLiteMovementsDao(vt));
        UserManager userManager=new UserManager(new SQLiteUserDao(vt));
        for (User u:userManager.GetAll()){
            level=u.getLevelId();
        }


        time=Integer.parseInt(gelen);
        h=new Handler();
        h2=new Handler();
        h3=new Handler();

        Log.e("Gelen",String.valueOf(time));



        switch (Area) {
            case "Full":
                pozlar = akis.Get_Full(level, time);
                break;
            case "bacak":
                pozlar= akis.Get_Area(level,time,"bacak");
                break;
            case "gögüs":
                pozlar= akis.Get_Area(level,time,"gögüs");
                break;
            case "karın":
                pozlar= akis.Get_Area(level,time,"karın");
                break;
            case "omuz ve sırt":
                pozlar= akis.Get_Area(level,time,"omuz ve sırt");
                break;
            case "kol":
                pozlar= akis.Get_Area(level,time,"kol");
                break;
        }



      //  pozlar= akis.Get_Area(level,time,Area);//movementsManager.GetAll();
        Log.e("Poz list size",String.valueOf(time));

        akis.Get_Area(level,time,Area);






        h.postDelayed(runnable,1000);
        str=pozlar.get(poseNum).getName();
        txtPoseName.setText(str);
        poseNum++;
        IBtnFoto.setImageResource(getResources().getIdentifier(str,"drawable",getPackageName()));




    }


    private final Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (poseNum==time){
                h.postDelayed(runnable,1000);
                str=pozlar.get(poseNum).getName();


                h.removeCallbacks(runnable);

            }
            extra++;
          //  Log.e("Kalan süre: ",String.valueOf(sayac));
            txtTime.setText("Kalan süre: "+String.valueOf(sayac));
            sayac--;
            h.postDelayed(runnable,1000);
            str=pozlar.get(poseNum).getName();
            imgId=String.valueOf(pozlar.get(poseNum).getId());
            IBtnFoto.setImageResource(getResources().getIdentifier(String.valueOf(txtPoseName.getText()),"drawable",getPackageName()));

            if (sayac==0) {
                txtPoseName.setText(String.valueOf(pozlar.get(poseNum).getName()));

                poseNum++;
                Log.e("Hareket adı",str);
                h.removeCallbacks(runnable);
                dinlen=10;

                h2.postDelayed(runnable2,1000);
            }
            if (time==poseNum+1){
                return;
            }

        }
    };

    private final Runnable runnable2=new Runnable() {
        @Override
        public void run() {
            txtPoseName.setText(str);
            IBtnFoto.setImageResource(getResources().getIdentifier(String.valueOf(txtPoseName.getText()),"drawable",getPackageName()));
          //  Log.e("Dinlen! Kalan süre: ",String.valueOf(dinlen));
            txtTime.setText("Dinlen! Kalan süre: "+String.valueOf(dinlen));
            dinlen--;
            h2.postDelayed(runnable2,1000);
            if (dinlen==0){

                h2.removeCallbacks(runnable2);
                sayac=50;
                extra=0;
                if (time!=poseNum){
                    h.postDelayed(runnable,1000);
                }else{
                    sayac=50;
                    h3.postDelayed(runnable3,1000);

                }

            }
        }
    };
    private final Runnable runnable3=new Runnable() {
        @Override
        public void run() {
            Log.e("Kalan süre: ",String.valueOf(sayac));
            txtTime.setText("Kalan süre: "+String.valueOf(sayac));
            sayac--;
            if (sayac!=0){
                h3.postDelayed(runnable3,1000);
            }
            else {//            Akışın bittigi bölüm
                h3.removeCallbacks(runnable3);
              //  Log.e("progggram bitti", "dhasjas");
                Intent yeniInstant=new Intent(FitnessListDevam.this, PoseList.class);

                startActivity(yeniInstant);

            }
        }
    };
}