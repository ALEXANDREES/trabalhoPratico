package com.example.eduardoi.locaplus.Dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper{

    public Banco(Context context) {
        super(context, "BANCODADOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS LOCACAO(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "DATALOCACAO VARCHAR(45)," +
                "DATAENCERRAMENTO VARCHAR(45)," +
                "KM FLOAT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}