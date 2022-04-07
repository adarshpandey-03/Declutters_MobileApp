package com.example.declutters_userdashboard;

public class RequestedUser {
     String fName;
     String lastName;
     String address;

    public RequestedUser() {
    }

    public RequestedUser(String fName, String lastName, String address) {
        this.fName = fName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}