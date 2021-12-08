package com.example.databinding;

import android.content.Context;

public class MainActivityPresenter implements MainActivityContracter.presenter{
    private MainActivityContracter.view view;
    private Context context;

    public MainActivityPresenter(MainActivityContracter.view view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onShowData(StudentData studentData) {
    view.ShowData(studentData);
    }
}
