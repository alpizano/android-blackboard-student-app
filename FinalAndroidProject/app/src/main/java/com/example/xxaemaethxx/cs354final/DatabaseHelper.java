package com.example.xxaemaethxx.cs354final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //database values
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "pass";
    SQLiteDatabase db;

    //contacts table
    private static final String TABLE_CREATE = "CREATE TABLE contacts (id integer primary key not null auto_increment , name text not null , email text not null , username text not null , pass text not null);";

    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
    this.db = db;
    }

    public void insertContact(Contact c) {

        // makes writable to database
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());

        //inserts contact object into database
        db.insert(TABLE_NAME, null , values);
    }

    public String searchPass(String username) {
        // to read database
        db = this.getReadableDatabase();
        String query = "SELECT username, password FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);

                if(a.equals(username)) {
                b = cursor.getString(1);
                break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
    db.execSQL(query);
    this.onCreate(db);
    }
}
