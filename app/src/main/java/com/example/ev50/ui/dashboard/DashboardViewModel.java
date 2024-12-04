package com.example.ev50.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> text;

    public DashboardViewModel() {
        text = new MutableLiveData<>();
        text.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return text;
    }
}