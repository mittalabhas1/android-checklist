package com.macchli.checklist.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ChecklistTable{
    public static final String TABLE_NAME = "checklist";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ITEM = "item";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_ITEM + " text not null, "
            + ");";

    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    public static void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.w(ChecklistTable.class.getName(), "Upgrading database version from " + oldVersion + " to " + newVersion);
        database.execSQL(DATABASE_DROP);
        onCreate(database);
    }
}