package com.example.lifecyclejet;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init()
    {
        Log.i("tag","on created is called");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause()
    {
        Log.i("tag","on Pause is called");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop()
    {
        Log.i("tag","on stop is called");
    }
}
