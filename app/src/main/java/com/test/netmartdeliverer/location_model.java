package com.test.netmartdeliverer;

public class location_model {

    private int locationID;
    private String Pickup;
    private String Destination;
    private int InitialLat;
    private int InitialLng;
    private int CurrentLat;
    private int CurrentLng;
    private int Pickup_LatLng;
    private int Destination_LatLng;
    private String Transport_type;
    private String geolocation;
    private String Notes;
    private int Price;
    private int ChatID;
    private String ChatName;
    private String ChatDetails;
    private String Call_details;
    private String Available;
    private String startDelivery;

    public location_model(int locationID, String pickup, String destination, int initialLat, int initialLng, int currentLat, int currentLng, int pickup_LatLng, int destination_LatLng, String transport_type, String geolocation, String notes, int price, int chatID, String chatName, String chatDetails, String call_details, String available, String startDelivery) {
        this.locationID = locationID;
        Pickup = pickup;
        Destination = destination;
        InitialLat = initialLat;
        InitialLng = initialLng;
        CurrentLat = currentLat;
        CurrentLng = currentLng;
        Pickup_LatLng = pickup_LatLng;
        Destination_LatLng = destination_LatLng;
        Transport_type = transport_type;
        this.geolocation = geolocation;
        Notes = notes;
        Price = price;
        ChatID = chatID;
        ChatName = chatName;
        ChatDetails = chatDetails;
        Call_details = call_details;
        Available = available;
        this.startDelivery = startDelivery;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getPickup() {
        return Pickup;
    }

    public void setPickup(String pickup) {
        Pickup = pickup;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public int getInitialLat() {
        return InitialLat;
    }

    public void setInitialLat(int initialLat) {
        InitialLat = initialLat;
    }

    public int getInitialLng() {
        return InitialLng;
    }

    public void setInitialLng(int initialLng) {
        InitialLng = initialLng;
    }

    public int getCurrentLat() {
        return CurrentLat;
    }

    public void setCurrentLat(int currentLat) {
        CurrentLat = currentLat;
    }

    public int getCurrentLng() {
        return CurrentLng;
    }

    public void setCurrentLng(int currentLng) {
        CurrentLng = currentLng;
    }

    public int getPickup_LatLng() {
        return Pickup_LatLng;
    }

    public void setPickup_LatLng(int pickup_LatLng) {
        Pickup_LatLng = pickup_LatLng;
    }

    public int getDestination_LatLng() {
        return Destination_LatLng;
    }

    public void setDestination_LatLng(int destination_LatLng) {
        Destination_LatLng = destination_LatLng;
    }

    public String getTransport_type() {
        return Transport_type;
    }

    public void setTransport_type(String transport_type) {
        Transport_type = transport_type;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getChatID() {
        return ChatID;
    }

    public void setChatID(int chatID) {
        ChatID = chatID;
    }

    public String getChatName() {
        return ChatName;
    }

    public void setChatName(String chatName) {
        ChatName = chatName;
    }

    public String getChatDetails() {
        return ChatDetails;
    }

    public void setChatDetails(String chatDetails) {
        ChatDetails = chatDetails;
    }

    public String getCall_details() {
        return Call_details;
    }

    public void setCall_details(String call_details) {
        Call_details = call_details;
    }

    public String getAvailable() {
        return Available;
    }

    public void setAvailable(String available) {
        Available = available;
    }

    public String getStartDelivery() {
        return startDelivery;
    }

    public void setStartDelivery(String startDelivery) {
        this.startDelivery = startDelivery;
    }
}
