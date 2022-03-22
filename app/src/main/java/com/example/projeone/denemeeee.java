package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.AkısManager;
import com.example.projeone.Business.Concretes.PosesManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteAkısDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLitePosesDao;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;

public class denemeeee extends AppCompatActivity {
    private DataBaseConnection vt;
    public TextView txtTime;
    private TextView txtPoseName;
    private ImageView imgPose;

    private Handler h;
    private Handler h2;



    private  int sayac=3;
    private  int dinlen=3;


    private ArrayList<Poses> pozlar=new ArrayList<>();
    private String str;
    private int poseNum=0;
    private  int time;
    private ImageView img;
    private String imgId="anonim";
    private Boolean Egzersiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemeeee);


        Intent yeniInstant=new Intent(denemeeee.this, PoseList.class);
    //   Intent yeniInstant=new Intent(denemeeee.this, SportUser.class);
        Egzersiz=getIntent().getBooleanExtra("Egzersiz",false);
        yeniInstant.putExtra("Egzersiz",Egzersiz);
        yeniInstant.putExtra("Area"," ");
        startActivity(yeniInstant);


        startActivity(yeniInstant);
        finish();



        time=20;
        int levelİd=2;



    }

    private final Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (poseNum==time){
                h.postDelayed(runnable,1000);
                str=pozlar.get(poseNum).getNameIng();

                h.removeCallbacks(runnable);

            }
            Log.e("Kalan süre: ",String.valueOf(sayac));
            // txtTime.setText("Kalan süre: "+String.valueOf(sayac));
            sayac--;
            h.postDelayed(runnable,1000);
            str=pozlar.get(poseNum).getNameIng();
            imgId=String.valueOf(pozlar.get(poseNum).getId());
            //for (Poses p:pozlar){Log.e(String.valueOf(poseNum),p.getNameIng());}
            if (sayac==0) {
                //txtPoseName.setText(String.valueOf(pozlar.get(poseNum).getNameIng()));

                poseNum++;
                Log.e("Hareket adı",str);
                h.removeCallbacks(runnable);
                dinlen=3;

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
//            txtPoseName.setText(str);

            Log.e("Dinlen! Kalan süre: ",String.valueOf(dinlen));
            //txtTime.setText("Dinlen! Kalan süre: "+String.valueOf(dinlen));
            dinlen--;
            h2.postDelayed(runnable2,1000);
            if (dinlen==0){

                h2.removeCallbacks(runnable2);
                sayac=3;
                if (time!=poseNum){
                    h.postDelayed(runnable,1000);
                }

            }
        }
    };

}