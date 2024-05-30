package com.example.manager_applictionsilverspoons.model;

import java.util.ArrayList;

public class TableOutputModel {


    public  Boolean status;

    public  String message;

    public ArrayList<TableModel> table;

    public TableOutputModel(Boolean status, String message, ArrayList<TableModel> table) {
        this.status = status;
        this.message = message;
        this.table = table;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<TableModel> getTable() {
        return table;
    }

    public void setTable(ArrayList<TableModel> table) {
        this.table = table;
    }
}
