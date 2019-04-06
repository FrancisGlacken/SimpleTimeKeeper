package com.deltorostudios.punchclockmockup2.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.Timer;

public class TimerViewModel extends AndroidViewModel {
    public TimerViewModel(@NonNull Application application) {
        super(application);
    }

    private LiveData<Long> observedTime = new MutableLiveData<>();

    // Method that returns liveData Object
    public LiveData<Long> getObservedTime() {
        return observedTime;
    }

    public void setTimer(long displayTime) {
        ((MutableLiveData<Long>) observedTime).setValue(displayTime);
    }
}
