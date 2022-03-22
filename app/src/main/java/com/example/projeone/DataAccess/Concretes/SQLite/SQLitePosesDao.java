package com.example.projeone.DataAccess.Concretes.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeone.DataAccess.Abstracts.IPosesDao;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;

public class SQLitePosesDao implements IPosesDao {
   private DataBaseConnection vt;

    public SQLitePosesDao(DataBaseConnection vt) {
        this.vt = vt;
    }

    @Override
    public ArrayList<Poses> GetAll() {
        ArrayList<Poses> PosesList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();

        Cursor c=dbx.rawQuery("SELECT*FROM Poses",null);

        while (c.moveToNext()){
            @SuppressLint("Range") Poses pose=new Poses(
                    c.getInt(c.getColumnIndex("Id")),
                    c.getString(c.getColumnIndex("nameIng")),
                    c.getString(c.getColumnIndex("nameSnk")),
                    c.getInt(c.getColumnIndex("levelId")));

            PosesList.add(pose);
        }

        return PosesList;
    }

    @Override
    public void Add(Poses pose) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put("nameIng",pose.getNameIng());
        degerler.put("nameSnk",pose.getNameSnk());
        degerler.put("levelId",pose.getLevelId());

        dbx.insertOrThrow("Poses",null,degerler);
        dbx.close();
    }



    @Override
    public void Update(Poses pose) {

    }

    @Override
    public void Delete(Poses pose) {
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("Poses","Id?",new String[]{String.valueOf(pose.getId())});
        dbx.close();
    }


}
