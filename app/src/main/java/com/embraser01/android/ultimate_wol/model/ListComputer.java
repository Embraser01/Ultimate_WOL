package com.embraser01.android.ultimate_wol.model;

import android.content.Context;

import com.embraser01.android.ultimate_wol.database.ComputerAdapter;
import com.embraser01.android.ultimate_wol.database.ReadOnlyException;

import java.util.ArrayList;

public class ListComputer {

    private ArrayList<Computer> computers;

    private ComputerAdapter computerAdapter;

    public ListComputer(Context context){
        computerAdapter = new ComputerAdapter(context);
        computerAdapter.open();
        computers = computerAdapter.getAllComputer();
    }

    public void addComputer(Computer computer){
        try {
            computer.setId(((int) computerAdapter.addComputer(computer)));
            computers.add(computer);
        } catch (ReadOnlyException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Computer> getList(){
        return this.computers;
    }
}
