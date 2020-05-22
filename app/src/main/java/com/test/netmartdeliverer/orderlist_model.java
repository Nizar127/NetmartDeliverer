package com.test.netmartdeliverer;

import java.sql.Time;
import java.sql.Timestamp;

public class orderlist_model {

    private int orderId;
    private Time DeliveryTime;
    private String orderTitle;
    private String Location;
    private String itemsID;
    private String itemsTitle;
    private String itemsNum;
    private String itemsDetails;
    private String message;
    private int totalprice;
    private String Map;
    private Timestamp updated;

    public orderlist_model(int orderId, Time deliveryTime, String orderTitle, String location, String itemsID, String itemsTitle, String itemsNum, String itemsDetails, String message, int totalprice, String map, Timestamp updated) {
        this.orderId = orderId;
        DeliveryTime = deliveryTime;
        this.orderTitle = orderTitle;
        Location = location;
        this.itemsID = itemsID;
        this.itemsTitle = itemsTitle;
        this.itemsNum = itemsNum;
        this.itemsDetails = itemsDetails;
        this.message = message;
        this.totalprice = totalprice;
        Map = map;
        this.updated = updated;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Time getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(Time deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getItemsID() {
        return itemsID;
    }

    public void setItemsID(String itemsID) {
        this.itemsID = itemsID;
    }

    public String getItemsTitle() {
        return itemsTitle;
    }

    public void setItemsTitle(String itemsTitle) {
        this.itemsTitle = itemsTitle;
    }

    public String getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(String itemsNum) {
        this.itemsNum = itemsNum;
    }

    public String getItemsDetails() {
        return itemsDetails;
    }

    public void setItemsDetails(String itemsDetails) {
        this.itemsDetails = itemsDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getMap() {
        return Map;
    }

    public void setMap(String map) {
        Map = map;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
