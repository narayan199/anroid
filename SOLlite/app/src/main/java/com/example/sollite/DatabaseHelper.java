package com.example.sollite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CUSTOMER_NAME ="CUSTOMER_NAME" ;
    private static final String CUSTOMER_AGE ="CUSTOMER_AGE" ;
    private static final String ACTIVE_STATUS ="ACTIVE_STATUS" ;
    private static final String CUSTOMER_TABLE ="CUSTOMER_TABLE" ;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatement="CREATE TABLE CUSTOMER_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT,CUSTOMER_NAME TEXT,CUSTOMER_AGE INT,ACTIVE_STATUS BOOL)";
        db.execSQL(CreateTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean add(customerModel c) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CUSTOMER_NAME,c.getName());
        cv.put(CUSTOMER_AGE,c.getAge());
        cv.put(ACTIVE_STATUS,c.isActive());
        db.insert(CUSTOMER_TABLE,null,cv);
        return true;
    }
    public List<customerModel> getEveryone()
    {
        List<customerModel>  returnList  = new ArrayList<>();
        String query="SELECT * FROM CUSTOMER_TABLE";
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                //   boolean check = cursor.getInt(3) = 1;
                customerModel customerModel1= new customerModel(id,name,age,true);
                returnList.add(customerModel1);
            }
            while (cursor.moveToNext());

        }
        else
        {
        //close
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
