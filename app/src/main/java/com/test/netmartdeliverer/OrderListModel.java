package com.test.netmartdeliverer;

public class OrderListModel {
    private double Send_Time;
    private int UserImage;
    private String ClientName;
    private int PriceOrder;
    private int ItemToBeDelivered;
    private String Items;
    private Boolean expanded;


    public OrderListModel(double send_Time, int userImage, String clientName, int priceOrder, int itemtobedelivered, String items) {
        this.Send_Time = send_Time;
        this.UserImage = userImage;
        this.ClientName = clientName;
        this.PriceOrder = priceOrder;
        this.ItemToBeDelivered = itemtobedelivered;
        this.Items = items;
        this.expanded = false;
    }

    public double getSend_Time() {
        return Send_Time;
    }


    public int getImage() {
        return UserImage;
    }



    public String getClientName() {
        return ClientName;
    }


    public int getPriceOrder() {
        return PriceOrder;
    }


    public int getItemToBeDelivered(){
        return ItemToBeDelivered;
    }

    public String getItems(){ return Items;}

    @Override
    public String toString() {
        return "OrderListModel{" +
                "Send_Time=" + Send_Time +
                ", UserImage=" + UserImage +
                ", ClientName='" + ClientName + '\'' +
                ", PriceOrder=" + PriceOrder +
                ", ItemToBeDelivered=" + ItemToBeDelivered +
                ", Items='" + Items + '\'' +
                '}';
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }


}
