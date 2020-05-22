package com.test.netmartdeliverer;

import java.sql.Date;
import java.sql.Time;

public class payment_model {
    private int payId;
    private String payer_Name;
    private String payee_Name;
    private Date Date;
    private Time Time;
    private String itemsId;
    private String itemsName;
    private String itemsDetail;
    private int itemsPrice;
    private int itemsQty;
    private int TotalPayment;

    public payment_model(int payId, String payer_Name, String payee_Name, java.sql.Date date, java.sql.Time time, String itemsId, String itemsName, String itemsDetail, int itemsPrice, int itemsQty, int totalPayment) {
        this.payId = payId;
        this.payer_Name = payer_Name;
        this.payee_Name = payee_Name;
        Date = date;
        Time = time;
        this.itemsId = itemsId;
        this.itemsName = itemsName;
        this.itemsDetail = itemsDetail;
        this.itemsPrice = itemsPrice;
        this.itemsQty = itemsQty;
        TotalPayment = totalPayment;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayer_Name() {
        return payer_Name;
    }

    public void setPayer_Name(String payer_Name) {
        this.payer_Name = payer_Name;
    }

    public String getPayee_Name() {
        return payee_Name;
    }

    public void setPayee_Name(String payee_Name) {
        this.payee_Name = payee_Name;
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

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsDetail() {
        return itemsDetail;
    }

    public void setItemsDetail(String itemsDetail) {
        this.itemsDetail = itemsDetail;
    }

    public int getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(int itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public int getItemsQty() {
        return itemsQty;
    }

    public void setItemsQty(int itemsQty) {
        this.itemsQty = itemsQty;
    }

    public int getTotalPayment() {
        return TotalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        TotalPayment = totalPayment;
    }
}
