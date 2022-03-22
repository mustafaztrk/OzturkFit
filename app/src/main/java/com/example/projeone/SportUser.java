package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.User;

public class SportUser extends AppCompatActivity {
    private DataBaseConnection vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_user);





    }
}