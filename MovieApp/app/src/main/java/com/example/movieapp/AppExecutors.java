package com.example.movieapp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {
    //singletton pattern
    private static AppExecutors instance;
    public static AppExecutors getInstance()
    {
        if(instance==null)
        {
            return new AppExecutors();
        }
        return instance;
    }
    private final ScheduledExecutorService mNetwrokIO= Executors.newScheduledThreadPool(3);
    public ScheduledExecutorService getmNetwrokIO()
    {
        return mNetwrokIO;
    }
}
