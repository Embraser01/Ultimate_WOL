package com.embraser01.android.ultimate_wol.model;

import java.util.ArrayList;

public class ListComputer {

    private ArrayList<Computer> computers;

    public ListComputer(){
        computers = new ArrayList<>();
    }

    public void addComputer(Computer computer){
        computers.add(computer);
        // TODO Add in the database
    }

    public ArrayList<Computer> getList(){
        return this.computers;
    }
}
