package com.macchli.checklist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChecklistDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "checklist_db.db";
    private static final int DATABASE_VERSION = 1;

    public ChecklistDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
       ChecklistTable.onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        ChecklistTable.onUpgrade(database, oldVersion, newVersion);
    }
}