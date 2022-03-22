package com.example.projeone.DataAccess.Concretes.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseConnection extends SQLiteOpenHelper {

    public DataBaseConnection(@Nullable Context context) {
        super(context, "ProjeOnee.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"Movements\" (\n" +
                "\t\"Id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"area\"\tTEXT,\n" +
                "\t\"levelId\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"levelId\") REFERENCES \"Level\"(\"Id\"),\n" +
                "\tPRIMARY KEY(\"Id\"  )\n" + ");");
        db.execSQL("CREATE TABLE \"Poses\" (\n" +
                "\t\"Id\"\tINTEGER,\n" +
                "\t\"nameIng\"\tTEXT,\n" +
                "\t\"nameSnk\"\tTEXT,\n" +
                "\t\"levelId\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"levelId\") REFERENCES \"Level\"(\"Id\"),\n" +
                "\tPRIMARY KEY(\"Id\"  )\n" + ");");

        db.execSQL("CREATE TABLE \"Level\" (\n" +
                "\t\"Id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"Id\"  )\n" + ");");

        db.execSQL("CREATE TABLE \"User\" (\n" +
                "\t\"Id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"lastName\"\tTEXT,\n" +
                "\t\"cinsiyet\"\tTEXT,\n" +
                "\t\"time\"\tINTEGER,\n" +
                "\t\"weight\"\tINTEGER,\n" +
                "\t\"age\"\tINTEGER,\n" +
                "\t\"height\"\tINTEGER,\n" +
                "\t\"levelId\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"levelId\") REFERENCES \"Level\"(\"Id\"),\n" +
                "\tPRIMARY KEY(\"Id\")\n" +
                ");");

        db.execSQL("CREATE TABLE \"Akis\" (\n" +
                "\t\"Id\"\tINTEGER,\n" +
                "\t\"Poses\"\tTEXT,\n" +
                "\t\"Time\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"Id\" )\n" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Poses");
        db.execSQL("DROP TABLE IF EXISTS Level");
        db.execSQL("DROP TABLE IF EXISTS Movements");
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Akis");

        onCreate(db);
    }
}
