package com.example.allinone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists PERSONDETAILS(email varchar primary key,phoneno char(10) default null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insertData(String n,String p){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("phoneno",p);
        return db.insert("PERSONDETAILS",null,c);
    }
    public Cursor send(String n) {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from PERSONDETAILS where email=?",new String[]{n+""});
        return c;
    }

    public long insertemail(String emails) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("email",emails);
        long res= db.insert("PERSONDETAILS",null,c);
        return res;
    }
    public int updates(String emails,String number){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put("phoneno",number);
        int res = db.update("PERSONDETAILS",c,"email=?",new String[]{emails+""});
        return res;
    }
    public Cursor check(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cx=db.rawQuery("select * from PERSONDETAILS",null);
        return cx;
    }
}
