package com.test.netmartdeliverer;

import java.sql.Date;
import java.sql.Timestamp;

public class notification_model {
    private int notifyId;
    private String Image;
    private String Title;
    private int DeliveryTime;
    private Date Date;
    private String Items_list;
    private int Items_listId;
    private int ItemsNum;
    private String Items_Details;
    private int Price;
    private Timestamp Updated;


    public notification_model(int notifyId, String image, String title, int deliveryTime, java.sql.Date date, String items_list, int items_listId, int itemsNum, String items_Details, int price, Timestamp updated) {
        this.notifyId = notifyId;
        Image = image;
        Title = title;
        DeliveryTime = deliveryTime;
        Date = date;
        Items_list = items_list;
        Items_listId = items_listId;
        ItemsNum = itemsNum;
        Items_Details = items_Details;
        Price = price;
        Updated = updated;
    }

    public int getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(int notifyId) {
        this.notifyId = notifyId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public String getItems_list() {
        return Items_list;
    }

    public void setItems_list(String items_list) {
        Items_list = items_list;
    }

    public int getItems_listId() {
        return Items_listId;
    }

    public void setItems_listId(int items_listId) {
        Items_listId = items_listId;
    }

    public int getItemsNum() {
        return ItemsNum;
    }

    public void setItemsNum(int itemsNum) {
        ItemsNum = itemsNum;
    }

    public String getItems_Details() {
        return Items_Details;
    }

    public void setItems_Details(String items_Details) {
        Items_Details = items_Details;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Timestamp getUpdated() {
        return Updated;
    }

    public void setUpdated(Timestamp updated) {
        Updated = updated;
    }
}
