package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.projeone.Business.Concretes.AkısManager;
import com.example.projeone.Business.Concretes.MovementsManager;
import com.example.projeone.Business.Concretes.PosesManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteMovementsDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLitePosesDao;
import com.example.projeone.Entities.Concretes.Movements;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    private DataBaseConnection vt;
    ArrayList<User> userArrayList=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

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


        User user=new User();
        user.setName("Mustafa");
        user.setLastName("Öztürk");
        user.setLevelId(2);
        user.setWeight(100);
        user.setAge(25);
        user.setHeight(185);
        user.setCinsiyet("Man");
        user.setTime(20);



       // userManager.Add(user);


        MovementsManager movementsManager=new MovementsManager(new SQLiteMovementsDao(vt));
        PosesManager posesManager=new PosesManager(new SQLitePosesDao(vt));
        Log.e("SJLADHAJKDAS",String.valueOf(movementsManager.GetAll().size()));
        Log.e("SJLADHAJKDAS",String.valueOf(posesManager.GetAll().size()));


    }
}