package com.test.netmartdeliverer;

import com.google.type.Date;
import com.google.type.DayOfWeek;
import com.google.type.TimeOfDay;

import java.io.StringReader;
import java.sql.Timestamp;

public class main_model {
    private int deliveredID;
    private String Name;
    private int TrackID;
    private DayOfWeek Day;
    private TimeOfDay Time;
    private Date Date;
    private String Notifcation;
    private String OrderList;
    private String Benefit;
    private int Payment;
    private String Receipt;
    private String Profile;
    private Timestamp updated;

    public main_model(int deliveredID, String name, int trackID, DayOfWeek day, TimeOfDay time, com.google.type.Date date, String notifcation, String orderList, String benefit, int payment, String receipt, String profile, Timestamp updated) {
        this.deliveredID = deliveredID;
        Name = name;
        TrackID = trackID;
        Day = day;
        Time = time;
        Date = date;
        Notifcation = notifcation;
        OrderList = orderList;
        Benefit = benefit;
        Payment = payment;
        Receipt = receipt;
        Profile = profile;
        this.updated = updated;
    }

    public int getDeliveredID() {
        return deliveredID;
    }

    public void setDeliveredID(int deliveredID) {
        this.deliveredID = deliveredID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTrackID() {
        return TrackID;
    }

    public void setTrackID(int trackID) {
        TrackID = trackID;
    }

    public DayOfWeek getDay() {
        return Day;
    }

    public void setDay(DayOfWeek day) {
        Day = day;
    }

    public TimeOfDay getTime() {
        return Time;
    }

    public void setTime(TimeOfDay time) {
        Time = time;
    }

    public com.google.type.Date getDate() {
        return Date;
    }

    public void setDate(com.google.type.Date date) {
        Date = date;
    }

    public String getNotifcation() {
        return Notifcation;
    }

    public void setNotifcation(String notifcation) {
        Notifcation = notifcation;
    }

    public String getOrderList() {
        return OrderList;
    }

    public void setOrderList(String orderList) {
        OrderList = orderList;
    }

    public String getBenefit() {
        return Benefit;
    }

    public void setBenefit(String benefit) {
        Benefit = benefit;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public String getReceipt() {
        return Receipt;
    }

    public void setReceipt(String receipt) {
        Receipt = receipt;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
