package com.example.manager_applictionsilverspoons.model;

import java.util.ArrayList;

public class OrderOutputModel {

    public  Boolean status;

    public String message;

    public ArrayList<OrderModel> order;

    public OrderOutputModel(Boolean status, String message, ArrayList<OrderModel> order) {
        this.status = status;
        this.message = message;
        this.order = order;
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

    public ArrayList<OrderModel> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<OrderModel> order) {
        this.order = order;
    }
}

