package com.example.extendsadpater;
public class Student {
    private int mImageDrwable;
    private  String mName;
    private String mAddress;


    public Student(int mImageDrwable, String mName, String mAddress) {
        this.mImageDrwable = mImageDrwable;
        this.mName = mName;
        this.mAddress = mAddress;
    }


    public int getmImageDrwable() {
        return mImageDrwable;
    }


    public void setmImageDrwable(int mImageDrwable) {
        this.mImageDrwable = mImageDrwable;
    }


    public String getmName() {
        return mName;
    }


    public void setmName(String mName) {
        this.mName = mName;
    }


    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }


}
