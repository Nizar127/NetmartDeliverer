package com.test.netmartdeliverer;

import java.sql.Date;
import java.sql.Time;

public class receipt_model {
    private int receiptId;
    private String receiptTitle;
    private Date Date;
    private Time Time;
    private int Price;
    private String Location;
    private int Total;

    public receipt_model(int receiptId, String receiptTitle, java.sql.Date date, java.sql.Time time, int price, String location, int total) {
        this.receiptId = receiptId;
        this.receiptTitle = receiptTitle;
        Date = date;
        Time = time;
        Price = price;
        Location = location;
        Total = total;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
