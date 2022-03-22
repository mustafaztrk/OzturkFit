package com.example.projeone.DataAccess.Concretes.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeone.Business.Abstracts.IUserService;
import com.example.projeone.DataAccess.Abstracts.IUserDao;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;

public class SQLiteUserDao implements IUserDao {
    private DataBaseConnection vt;

    public SQLiteUserDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<User> GetAll() {
        ArrayList<User> UserList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM User",null);

        while (c.moveToNext()){
            @SuppressLint("Range") User user=new User(
                    c.getInt(c.getColumnIndex("Id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("lastName")),
                    c.getString(c.getColumnIndex("cinsiyet")),
                    c.getInt(c.getColumnIndex("time")),
                    c.getInt(c.getColumnIndex("weight")),
                    c.getInt(c.getColumnIndex("age")),
                    c.getInt(c.getColumnIndex("height")),
                    c.getInt(c.getColumnIndex("levelId")));

                    UserList.add(user);
        }


        return UserList;
    }

    @Override
    public void Add(User user) {


        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("name",user.getName());
        degerler.put("lastName",user.getLastName());
        degerler.put("cinsiyet",user.getCinsiyet());
        degerler.put("time",user.getTime());
        degerler.put("weight",user.getWeight());
        degerler.put("age",user.getAge());
        degerler.put("height",user.getHeight());
        degerler.put("levelId",user.getLevelId());

        dbx.insertOrThrow("User",null,degerler);
        dbx.close();

    }

    @Override
    public void Update(User entity) {

    }

    @Override
    public void Delete(User user) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("User","Id?",new String[]{String.valueOf(user.getId())});
        dbx.close();

    }
}
