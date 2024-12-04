package com.example.ev50.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {
    private final MutableLiveData<String> username;
    private final MutableLiveData<String> email;
    private final MutableLiveData<String> phone;

    public NotificationsViewModel() {
        username = new MutableLiveData<>();
        email = new MutableLiveData<>();
        phone = new MutableLiveData<>();

        // Set default values
        username.setValue("abc");
        email.setValue("abc@gmail.com");
        phone.setValue("1234567890");
    }

    // Getters for LiveData
    public LiveData<String> getUsername() {
        return username;
    }

    public LiveData<String> getEmail() {
        return email;
    }

    public LiveData<String> getPhone() {
        return phone;
    }
}