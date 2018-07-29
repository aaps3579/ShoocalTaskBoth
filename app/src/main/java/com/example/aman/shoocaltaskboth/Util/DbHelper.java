package com.example.aman.shoocaltaskboth.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aman.shoocaltaskboth.model.Message;
import com.example.aman.shoocaltaskboth.model.MyResult;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ResponseDB";
    public static final String RESPONSE_SUCCESS = "success";
    public static final String RESPONSE_ERROR = "error";
    public static final String RESPONSE_MESSAGE = "message";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table if not exists ResponseDB" +
                        "(id integer primary key autoincrement, success text,error text,message text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    public boolean insertResponse(MyResult myResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESPONSE_SUCCESS, myResult.isSuccess());
        contentValues.put(RESPONSE_ERROR, myResult.isError());
        String message = "";
        //  __ act as a separator
        for (Message m : myResult.getMessage()) {
            message = m.getStatus() + "," + m.getMessage() + "__";
        }
        contentValues.put(RESPONSE_MESSAGE, message);
        db.insert(DATABASE_NAME, null, contentValues);
        return true;
    }
}
