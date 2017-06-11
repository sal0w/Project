package com.example.akashsalow.project.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.akashsalow.project.Bean.Registration;

/**
 * Created by Akash Salow on 11-06-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "userDetails";

    private static final String DETAILS = "details";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phonenumber";
    private static final String KEY_UNIT = "unit_task";
    private static final String KEY_TECH = "technology";
    private static final String KEY_DC = "dc_tab";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, "
                + KEY_PH_NO + " TEXT, " +KEY_UNIT + " TEXT, " + KEY_TECH + " TEXT, " + KEY_DC + " TEXT" + ")";
        Log.d("Reading: ", CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DETAILS);
        onCreate(db);
    }

    public void addRegistration(Registration registration) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, registration.getName());
        values.put(KEY_PH_NO, registration.getPhoneNumber());
        values.put(KEY_UNIT, registration.getUnit().toString());
        values.put(KEY_TECH, registration.getTechnology());
        values.put(KEY_DC, registration.getDc());



        db.insert(DETAILS, null, values);
        db.close();
    }
}
