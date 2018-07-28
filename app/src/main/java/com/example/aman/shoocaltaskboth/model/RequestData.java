package com.example.aman.shoocaltaskboth.model;

import com.google.gson.annotations.SerializedName;

public class RequestData {

    @SerializedName("first_name")
    String first_name;
    @SerializedName("last_name")
    String last_name;
    @SerializedName("phone")
    String phone;
    @SerializedName("address")
    String address;
    @SerializedName("restau_name")
    String restaurant_name;
    @SerializedName("requestby")
    int request_type;

    public RequestData() {
    }

    public RequestData(String first_name, String last_name, String phone, String address, String restaurant_name, int request_type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address = address;
        this.restaurant_name = restaurant_name;
        this.request_type = request_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public int getRequest_type() {
        return request_type;
    }

    public void setRequest_type(int request_type) {
        this.request_type = request_type;
    }
}
