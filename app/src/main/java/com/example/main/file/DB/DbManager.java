package com.example.main.file.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Main on 2018-04-25.
 */

public class DbManager extends SQLiteOpenHelper{
    public DbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE Content (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name STRING,leview STRING,location STRING);";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void deleteData(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("Delete from Content where id=" + id);
    }
    public void insertData(String name,String leview,String location) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Insert into Content Values (null,"+ name +"," + leview + ","
                + location +");");
    }
}
