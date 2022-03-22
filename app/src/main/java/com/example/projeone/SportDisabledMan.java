package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.User;

public class SportDisabledMan extends AppCompatActivity {
    private DataBaseConnection vt;
    private Button btnMLShoulder,btnMRShoulder,btnMLHand,btnMRHand,btnMLKnee,btnMRKnee,btnMLFoot,btnMRFoot,btnMWaist;
    private TextView textView1,textView2,textView33,textView30,textView28,textView32,textView34,textView26,textView31;
    private int sayac1,sayac2,sayac3,sayac4,sayac5,sayac6,sayac7,sayac8,sayac9=0;
    private ImageButton ahdhad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_disabled_man);

        btnMLShoulder=findViewById(R.id.btnMLShoulder);
        btnMRShoulder=findViewById(R.id.btnMRShoulder);

        btnMLHand=findViewById(R.id.btnMLHand);
        btnMRHand=findViewById(R.id.btnMRHand);

        btnMLKnee=findViewById(R.id.btnMLKnee);
        btnMRKnee=findViewById(R.id.btnMRKnee);

        btnMLFoot=findViewById(R.id.btnMLFoot);
        btnMRFoot=findViewById(R.id.btnMRFoot);

        btnMWaist=findViewById(R.id.btnMWaist);

        textView1=findViewById(R.id.textView1);
        textView1.setText(" ");
        textView2=findViewById(R.id.textView2);
        textView2.setText(" ");
        textView33=findViewById(R.id.textView33);
        textView33.setText(" ");
        textView30=findViewById(R.id.textView30);
        textView30.setText(" ");
        textView28=findViewById(R.id.textView28);
        textView28.setText(" ");
        textView32=findViewById(R.id.textView32);
        textView32.setText(" ");
        textView34=findViewById(R.id.textView34);
        textView34.setText(" ");
        textView26=findViewById(R.id.textView26);
        textView26.setText(" ");
        textView31=findViewById(R.id.textView31);
        textView31.setText(" ");

        ahdhad=findViewById(R.id.btnPoseList);

        MainActivity.UserDisanled[1]=0;
        MainActivity.UserDisanled[2]=0;
        MainActivity.UserDisanled[3]=0;
        MainActivity.UserDisanled[4]=0;
        MainActivity.UserDisanled[5]=0;



        UserDbWrite();


        //sal omuz
        btnMLShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac1++;
                if (sayac1==1){
                    textView1.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac1==2){
                    textView1.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;
                }
                else if (sayac1==3){
                    textView1.setText(" ");
                    sayac1=0;
                    MainActivity.UserDisanled[1]=0;
                }


            }
        });
        //sog omuz
        btnMRShoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMLShoulder.getBackgroundTintMode();

                sayac2++;
                if (sayac2==1){
                    textView2.setText("Gecici");
                    MainActivity.UserDisanled[1]++;
                }
                else if(sayac2==2){
                    textView2.setText("Kalıcı");
                    MainActivity.UserDisanled[1]++;

                }
                else if (sayac2==3){
                    textView2.setText(" ");
                    sayac2=0;
                    MainActivity.UserDisanled[1]=0;
                }


            }
        });

        //sol el   textView30
        btnMLHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac3++;               ////////////////
                if (sayac3==1){
                    textView30.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac3==2){
                    textView30.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac3==3){
                    textView30.setText(" ");
                    sayac3=0;/////////////////
                    MainActivity.UserDisanled[2]=0;
                }


            }
        });

        //sag el   textView28

        btnMRHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac4++;               ////////////////
                if (sayac4==1){
                    textView28.setText("Gecici");
                    MainActivity.UserDisanled[2]++;
                }
                else if(sayac4==2){
                    textView28.setText("Kalıcı");
                    MainActivity.UserDisanled[2]++;

                }
                else if (sayac4==3){
                    textView28.setText(" ");
                    sayac4=0;/////////////////
                    MainActivity.UserDisanled[2]=0;
                }


            }
        });

        //sol diz textView32
        btnMLKnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac5++;               ////////////////
                if (sayac5==1){
                    textView32.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac5==2){
                    textView32.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac5==3){
                    textView32.setText(" ");
                    sayac5=0;/////////////////
                    MainActivity.UserDisanled[3]=0;
                }
            }
        });

        //sag diz textView34
        btnMRKnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac6++;               ////////////////
                if (sayac6==1){
                    textView34.setText("Gecici");
                    MainActivity.UserDisanled[3]++;
                }
                else if(sayac6==2){
                    textView34.setText("Kalıcı");
                    MainActivity.UserDisanled[3]++;

                }
                else if (sayac6==3){
                    textView34.setText(" ");
                    sayac6=0;/////////////////
                    MainActivity.UserDisanled[3]=0;

                }
            }
        });


        //sol ayak textView26

        btnMLFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac7++;               ////////////////
                if (sayac7==1){
                    textView26.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac7==2){
                    textView26.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac7==3){
                    textView26.setText(" ");
                    MainActivity.UserDisanled[4]=0;
                }
            }
        });

        //sag ayak   textView31
        btnMRFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac8++;               ////////////////
                if (sayac8==1){
                    textView31.setText("Gecici");
                    MainActivity.UserDisanled[4]++;
                }
                else if(sayac8==2){
                    textView31.setText("Kalıcı");
                    MainActivity.UserDisanled[4]++;

                }
                else if (sayac8==3){
                    textView31.setText(" ");
                    sayac8=0;/////////////////
                    MainActivity.UserDisanled[4]=0;
                }
            }
        });

        //karın ve bel textView33
        btnMWaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac9++;               ////////////////
                if (sayac9==1){
                    textView33.setText("Gecici");
                    MainActivity.UserDisanled[5]++;
                }
                else if(sayac9==2){
                    textView33.setText("Kalıcı");
                    MainActivity.UserDisanled[5]++;

                }
                else if (sayac9==3){
                    textView33.setText(" ");
                    MainActivity.UserDisanled[5]=0;
                }
            }
        });

        ahdhad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SportDisabledMan.this,Home.class));

            //    startActivity(new Intent(SportDisabledMan.this,test.class));
            }
        });

    }
    void UserDbWrite(){
        String name=MainActivity.UserName;
        String lastName=MainActivity.UserLastName;

        int gender=MainActivity.UserGender;

        String sporLevel=MainActivity.sporLevel;

        String sporAim=MainActivity.sporAim;

        int sporTime=MainActivity.sporTimeD;

        int sporTimeW=MainActivity.sporTimeW;

        String dailyDrink=MainActivity.dailyDrink;

        String dailySleep=MainActivity.dailySleep;

        int height=MainActivity.height;
        int age=MainActivity.age;
        int weight=MainActivity.weight;

        int[] UserDisanled=MainActivity.UserDisanled;


        vt=new DataBaseConnection(this);

        UserManager userManager=new UserManager(new SQLiteUserDao(vt));


        User user=new User();
        user.setName(name);
        user.setLastName(lastName);

        if (gender==1){user.setCinsiyet("Man");}
        else if(gender==2){user.setCinsiyet("Woman");}
        else{user.setCinsiyet("Null");}

        if (sporLevel=="Beginner"){user.setLevelId(1);}
        else if(sporLevel=="Intermediate"){user.setLevelId(2);}
        else{user.setLevelId(3);}

        user.setTime(sporTime);

        user.setWeight(weight);
        user.setHeight(height);
        user.setAge(age);

        userManager.Add(user);



        Log.e("Useer",String.valueOf(userManager.GetAll().size()));
    }
}