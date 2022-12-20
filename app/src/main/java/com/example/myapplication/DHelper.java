package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DHelper extends SQLiteOpenHelper {

    public DHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table in database
        db.execSQL(Constants.CREATE_TABLE_USER);
        //db.execSQL(Constants.CREATE_TABLE_PRODUCT);
        //db.execSQL(Constants.CREATE_TABLE_CREDIT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertUser(String name,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.U_NAME,name);
        contentValues.put(Constants.U_EMAIL,email);
        contentValues.put(Constants.U_PASSWORD,password);
        long id = db.insert(Constants.TABLE_USER,null,contentValues);
        db.close();
        return id;

    }

    public Boolean checkemail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USER_TABLE where EMAIL = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from USER_TABLE where EMAIL = ? and PASSWORD = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Cursor getData()
    {
        SQLiteDatabase MyDB  = this.getWritableDatabase() ;
        Cursor  cursor = MyDB.rawQuery("Select * from PRODUCT_TABLE " , null) ;
        return  cursor ;
    }
}


