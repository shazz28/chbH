package com.example.ev50.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<Boolean> connectionStatus = new MutableLiveData<>();
    private final MutableLiveData<String> batteryPercentage = new MutableLiveData<>();
    private final MutableLiveData<String> range = new MutableLiveData<>();

    public LiveData<Boolean> getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(Boolean status) {
        connectionStatus.setValue(status);
    }

    public LiveData<String> getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(String percentage) {
        batteryPercentage.setValue(percentage);
    }

    public LiveData<String> getRange() {
        return range;
    }

    public void setRange(String rangeValue) {
        range.setValue(rangeValue);
    }
}