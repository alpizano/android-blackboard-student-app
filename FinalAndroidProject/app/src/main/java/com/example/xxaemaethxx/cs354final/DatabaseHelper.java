package com.example.xxaemaethxx.cs354final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //database values
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;

    //contacts table
    private static final String TABLE_CREATE = " CREATE TABLE contacts (id integer primary key not null , " +
            "name text not null , email text not null , username text not null , password text not null);";

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

        // grabs count of contacts id 0, 1, 2, 3, 4
        String query = "SELECT * FROM contacts ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());

        //inserts contact object into database
        db.insert(TABLE_NAME, null , values);
        db.close();
    }

    public String searchPass(String username) {
        // to read database
        db = this.getReadableDatabase();

        // needs space after FROM clause
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        // needs to be 3 and 4
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(3);

                if(a.equals(username))
                {
                b = cursor.getString(4);
                break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
    db.execSQL(query);
    this.onCreate(db);
    }
}
