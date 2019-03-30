package com.example.myrecipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyRecipe.db";
    public static final String TABLE_NAME = "register_product";
    public static final String COL_1 = "PRODUCT_ID";
    public static final String COL_2 = "PRODUCT_NAME";
    public static final String COL_3 = "WEIGHT";
    public static final String COL_4 = "PRICE";
    public static final String COL_5 = "DESCRIPTION";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(PRODUCT_ID INTEGER PRIMARY KEY AUTOINCREMENT , PRODUCT_NAME TEXT, WEIGHT REAL,PRICE REAL,DESCRIPTION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //onCreate(db);
    }

    public boolean insertData(String pro_name , String weight,String price, String description){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,pro_name);
        contentValues.put(COL_3,weight);
        contentValues.put(COL_4,price);
        contentValues.put(COL_5,description);
        long results = db.insert(TABLE_NAME,null,contentValues);

        if (results == -1){
            return false;
        }else
            return true;
    }

}
