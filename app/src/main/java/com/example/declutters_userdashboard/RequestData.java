package com.example.declutters_userdashboard;

public class RequestData {
    public String totalamount,garbagetype, weight,status;

    public RequestData() {
    }

    public RequestData(String weight, String totalamount, String garbagetype, String status) {
        this.weight = weight;
        this.totalamount = totalamount;
        this.garbagetype = garbagetype;
        this.status = status;
    }
}
