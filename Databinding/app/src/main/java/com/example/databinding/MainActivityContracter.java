package com.example.databinding;

public interface MainActivityContracter {
    public interface presenter{
        void onShowData(StudentData studentData);
    }
    public interface view{
        void ShowData(StudentData studentData);
    }
}
