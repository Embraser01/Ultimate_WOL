package com.embraser01.android.ultimate_wol.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * class qui permet de creer une BDD ou juste la charger
 */

public class BaseSQL extends SQLiteOpenHelper {

    public static final int VERSION_BDD = 1;

    public static final String TABLE_COMPUTER = "table_computer";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "Name";
    public static final String COL_MAC = "Adresse_mac";
    public static final String COL_IP = "Adresse_IP";
    public static final String COL_PORT = "Port";
    public static final String COL_LAST_USED = "Last_used";
    public static final String COL_USED_CNT = "Used_cnt";

    public static final int NUM_COL_ID = 0;
    public static final int NUM_COL_NAME = 1;
    public static final int NUM_COL_MAC = 2;
    public static final int NUM_COL_IP = 3;
    public static final int NUM_COL_PORT = 4;
    public static final int NUM_COL_LAST_USED = 5;
    public static final int NUM_COL_USED_CNT = 6;

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_COMPUTER + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT NOT NULL, "
            + COL_MAC + " TEXT NOT NULL, " + COL_IP + " TEXT NOT NULL, " + COL_PORT + " TEXT NOT NULL, "
            + COL_LAST_USED + " TEXT, " + COL_USED_CNT + " INTEGER);";


    public BaseSQL(Context context, String name, CursorFactory factory) {
        super(context, name, factory, VERSION_BDD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // on cree la table à partir de la requete écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_COMPUTER + ";");
        onCreate(db);

    }



}