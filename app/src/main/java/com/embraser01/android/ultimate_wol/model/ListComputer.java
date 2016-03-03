package com.embraser01.android.ultimate_wol.model;

import android.content.Context;

import com.embraser01.android.ultimate_wol.database.BaseSQL;
import com.embraser01.android.ultimate_wol.database.ComputerAdapter;
import com.embraser01.android.ultimate_wol.database.ReadOnlyException;

import java.util.ArrayList;

public class ListComputer {

    private ArrayList<Computer> computers;

    private ComputerAdapter computerAdapter;
    private Computer undoPending;
    private int undoPosition;

    public ListComputer(Context context){
        computerAdapter = new ComputerAdapter(context);
        computerAdapter.open();
        computers = computerAdapter.getAllComputer();
    }

    public void addComputer(Computer computer){
        this.addComputer(computer, -1);
    }

    public void addComputer(Computer computer, int position){
        try {
            computer.setId(((int) computerAdapter.addComputer(computer)));

            if(position == -1) computers.add(computer);
            else computers.add(position, computer);

        } catch (ReadOnlyException e) {
            e.printStackTrace();
        }
    }

    public void deleteComputer(Computer computer){
        try {
            undoPending = computer;
            undoPosition = computers.indexOf(computer);
            computerAdapter.deleteComputer(computer);
            computers.remove(computer);
        } catch (ReadOnlyException e) {
            e.printStackTrace();
        }
    }

    public int undo(){
        int pos = -1;
        if(undoPending != null){
            this.addComputer(undoPending, undoPosition);
            pos = undoPosition;
            clearPending();
        }
        return pos;
    }

    public void clearPending(){
        undoPending = null;
        undoPosition = -1;
    }

    public void clear(){
        computerAdapter.getBDD().delete(BaseSQL.TABLE_COMPUTER, "1=1", null);
        computers.clear();
    }

    public ArrayList<Computer> getList(){
        return this.computers;
    }

    public int size(){
        return this.computers.size();
    }
}
