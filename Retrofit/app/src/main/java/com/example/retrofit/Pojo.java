package com.example.retrofit;

public class Pojo {
    private String name;
    private   String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Pojo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
