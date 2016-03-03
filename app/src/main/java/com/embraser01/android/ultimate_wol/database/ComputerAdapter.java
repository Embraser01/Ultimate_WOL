package com.embraser01.android.ultimate_wol.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.embraser01.android.ultimate_wol.model.Computer;

import java.util.ArrayList;

public class ComputerAdapter {

    private static SQLiteDatabase bdd;

    private BaseSQL myBaseSQL;

    // Initialisation

    public ComputerAdapter(Context context) {
        // Creation - Chargement de la bdd + table
        myBaseSQL = new BaseSQL(context, "LocalData.db", null);
    }

    // Ouverture et fermeture

    public void open() {
        //ouverture de la BDD en l'ecriture
        bdd = myBaseSQL.getWritableDatabase();
    }

    public void close() {
        //fermeture de la BDD en l'ecriture
        bdd.close();
    }


    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public int getCount() {
        return bdd.rawQuery("SELECT " + BaseSQL.COL_ID + " FROM " + BaseSQL.TABLE_COMPUTER, null).getCount();
    }


    public long addComputer(Computer computer) throws ReadOnlyException {

        //if (bdd.isReadOnly()) throw new ReadOnlyException();

        ContentValues values = new ContentValues();

        values.put(BaseSQL.COL_NAME, computer.getName());
        values.put(BaseSQL.COL_MAC, computer.getMac());
        values.put(BaseSQL.COL_IP, computer.getIp());
        values.put(BaseSQL.COL_PORT, computer.getPort());
        values.put(BaseSQL.COL_LAST_USED, computer.getLast_used());
        values.put(BaseSQL.COL_USED_CNT, 0);

        return bdd.insert(BaseSQL.TABLE_COMPUTER, null, values);
    }

    public int updateComputer(Computer computer, int id) throws ReadOnlyException {

        if (bdd.isReadOnly()) throw new ReadOnlyException();

        ContentValues values = new ContentValues();

        values.put(BaseSQL.COL_NAME, computer.getName());
        values.put(BaseSQL.COL_MAC, computer.getMac());
        values.put(BaseSQL.COL_IP, computer.getIp());
        values.put(BaseSQL.COL_PORT, computer.getPort());
        values.put(BaseSQL.COL_LAST_USED, computer.getLast_used());
        values.put(BaseSQL.COL_USED_CNT, 0);

        return bdd.update(BaseSQL.TABLE_COMPUTER, values, BaseSQL.COL_ID + " = " + id, null);
    }

    public int deleteComputer(Computer computer) throws ReadOnlyException {
        if (bdd.isReadOnly()) throw new ReadOnlyException();

        return bdd.delete(BaseSQL.TABLE_COMPUTER, BaseSQL.COL_ID + " = " + computer.getId(), null);
    }


    // Select all PC

    public ArrayList<Computer> getAllComputer() {

        ArrayList<Computer> computers = new ArrayList<>();

        Cursor c = bdd.rawQuery("SELECT *" + " FROM " + BaseSQL.TABLE_COMPUTER, null);

        if(c.getCount() == 0) return computers;

        while (c.moveToNext()) {
            Log.d("ComputerAdapter",Integer.toString(c.getPosition()));
            computers.add(new Computer(c.getInt(BaseSQL.NUM_COL_ID),
                    c.getString(BaseSQL.NUM_COL_NAME),
                    c.getString(BaseSQL.NUM_COL_MAC),
                    c.getString(BaseSQL.NUM_COL_IP),
                    c.getString(BaseSQL.NUM_COL_PORT),
                    c.getString(BaseSQL.NUM_COL_LAST_USED),
                    c.getInt(BaseSQL.NUM_COL_USED_CNT)));
        }

        c.close();

        return computers;
    }


    public Computer selectComputer(int id) {

        Cursor c = bdd.rawQuery("SELECT *" + " FROM " + BaseSQL.TABLE_COMPUTER + " WHERE _id = '" + id + "'", null);

        if (c.getCount() <= 0) return null;
        c.moveToFirst();

        Computer computer = new Computer(c.getInt(BaseSQL.NUM_COL_ID),
                c.getString(BaseSQL.NUM_COL_NAME),
                c.getString(BaseSQL.NUM_COL_MAC),
                c.getString(BaseSQL.NUM_COL_IP),
                c.getString(BaseSQL.NUM_COL_PORT),
                c.getString(BaseSQL.NUM_COL_LAST_USED),
                c.getInt(BaseSQL.NUM_COL_USED_CNT));
        c.close();
        return computer;
    }
}
