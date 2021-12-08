package com.example.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ScoreViewModel  extends AndroidViewModel {
    //viewmode data write and retrive
    public int scoreA=10;
    public  int scoreb=0;

    public ScoreViewModel(@NonNull Application application) {
        super(application);
    }
}
