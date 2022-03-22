package com.example.projeone.DataAccess.Concretes.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeone.DataAccess.Abstracts.IMovementsDao;
import com.example.projeone.Entities.Concretes.Movements;


import java.util.ArrayList;


public class SQLiteMovementsDao implements IMovementsDao {
    private DataBaseConnection vt;

    public SQLiteMovementsDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<Movements> GetAll() {
        ArrayList<Movements> MovementsList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM Movements",null);

        while (c.moveToNext()){
            @SuppressLint("Range") Movements movements=new Movements(
                    c.getInt(c.getColumnIndex("Id")),
                    c.getInt(c.getColumnIndex("levelId")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("area")));


            MovementsList.add(movements);
        }

        return MovementsList;
    }

    @Override
    public void Add(Movements movements) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("name",movements.getName());
        degerler.put("area",movements.getArea());
        degerler.put("levelId",movements.getLevelId());

        dbx.insertOrThrow("Movements",null,degerler);
        dbx.close();
    }

    @Override
    public void Update(Movements movements) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("Movements","Id?",new String[]{String.valueOf(movements.getId())});
        dbx.close();
    }

    @Override
    public void Delete(Movements entity) {

    }
}
