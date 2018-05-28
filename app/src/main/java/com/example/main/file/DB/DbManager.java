package com.example.main.file.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.main.file.Model.Content;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Main on 2018-04-25.
 */

public class DbManager extends SQLiteOpenHelper {

    String DBname = "FoodStore";
    String locationfield = "location";
    String namefield = "name";

    public DbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS FoodStore (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT,review TEXT,location TEXT,time TEXT, score TEXT);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void deleteData(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Delete from Content where id=" + id);
    }

    public void insertData(String name, String review, String location, String time, String score) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO FoodStore VALUES (null,'" + name + "','" + review + "','"
                + location + "','" + time + "','" + score + "');");



    }


}
