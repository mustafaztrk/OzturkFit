package com.example.projeone.DataAccess.Concretes.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.projeone.DataAccess.Abstracts.IAkısDao;
import com.example.projeone.Entities.Concretes.Akıs;

import java.util.ArrayList;

public class SQLiteAkısDao implements IAkısDao {
    private DataBaseConnection vt;

    public SQLiteAkısDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<Akıs> GetAll() {

        ArrayList<Akıs> AkısList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM Akis",null);

        while (c.moveToNext()){
            @SuppressLint("Range") Akıs akıs=new Akıs(
                    c.getInt(c.getColumnIndex("Id")),
                    c.getString(c.getColumnIndex("Poses")),
                    c.getInt(c.getColumnIndex("Time")));
            AkısList.add(akıs);
        }

        return AkısList;
    }

    @Override
    public void Add(Akıs akıs) {

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("Poses",akıs.getPoses());
        degerler.put("Time",akıs.getTime());

        dbx.insertOrThrow("Akis",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(Akıs entity) {

    }

    @Override
    public void Delete(Akıs akıs) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("Akis","Id",new String[]{String.valueOf(akıs.getId())});
        dbx.close();

    }
}
