package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.AkısManager;
import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteAkısDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLitePosesDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class PoseListDevam extends AppCompatActivity {
    private DataBaseConnection vt;
    public TextView txtTime;
    private TextView txtPoseName;

    private Handler h;
    private Handler h2;
    private Handler h3;


    private  int sayac=50;
    private  int dinlen=10;
    private  int duraklat=0;
    private ArrayList<Poses> pozlar=new ArrayList<>();
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
    private GifImageView gifKar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pose_list_devam);



        vt=new DataBaseConnection(this);
        imgClose = findViewById(R.id.imgclose);

        gifKar=findViewById(R.id.gifKar);

        txtTime=findViewById(R.id.txtTime);
        txtPoseName=findViewById(R.id.txtPoseName);

        String gelen=getIntent().getStringExtra("süre");
        Log.e("spor süresiii",gelen);
        AkısManager akısManager=new AkısManager(new SQLiteAkısDao(vt),new SQLitePosesDao(vt));



        time=Integer.parseInt(gelen);
        h=new Handler();
        h2=new Handler();
        h3=new Handler();

        if (experience == "Beginner"){
            level = 1;
        }
        else if (experience == "Intermediate")
        {
            level = 2;
        }
        else if (experience == "Advanced")
        {
            level = 3;
        }
        else if (experience == null) {
            level = 1;
        }

        pozlar=akısManager.GetPose(level,time);

        h.postDelayed(runnable,1000);
        str=pozlar.get(poseNum).getNameIng();
        txtPoseName.setText(str);
        poseNum++;
        gifKar.setImageResource(getResources().getIdentifier(str,"drawable",getPackageName()));



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h.removeCallbacks(runnable);
                h2.removeCallbacks(runnable2);
                startActivity(new Intent(PoseListDevam.this,Home.class));
            }
        });




    }

    private final Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (poseNum==time){
                h.postDelayed(runnable,1000);
                str=pozlar.get(poseNum).getNameIng();

                h.removeCallbacks(runnable);

            }
            extra++;
            Log.e("Kalan süre: ",String.valueOf(sayac));
            txtTime.setText("Kalan süre: "+String.valueOf(sayac));
            sayac--;
            h.postDelayed(runnable,1000);
            str=pozlar.get(poseNum).getNameIng();
            imgId=String.valueOf(pozlar.get(poseNum).getId());
            gifKar.setImageResource(getResources().getIdentifier(str,"drawable",getPackageName()));
            //for (Poses p:pozlar){Log.e(String.valueOf(poseNum),p.getNameIng());}
            if (sayac==0) {
                txtPoseName.setText(String.valueOf(pozlar.get(poseNum).getNameIng()));

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

            Log.e("Dinlen! Kalan süre: ",String.valueOf(dinlen));
            txtTime.setText("Dinlen! Kalan süre: "+String.valueOf(dinlen));
            dinlen--;
            h2.postDelayed(runnable2,1000);
            gifKar.setImageResource(getResources().getIdentifier(str,"drawable",getPackageName()));
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
                Log.e("progggram bitti", "dhasjas");
                Intent yeniInstant=new Intent(PoseListDevam.this, PoseList.class);

                startActivity(yeniInstant);

            }
        }
    };

}