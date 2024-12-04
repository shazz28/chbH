package com.example.ev50.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ev50.R; // Adjust the package name based on your project structure

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private TextView usernameTextView;
    private EditText emailEditText;
    private EditText phoneEditText;
    private ImageView profileImageView;
    private ImageView carImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Initialize views
        usernameTextView = view.findViewById(R.id.username);
        emailEditText = view.findViewById(R.id.editTextTextEmailAddress);
        phoneEditText = view.findViewById(R.id.editTextPhone);
        profileImageView = view.findViewById(R.id.imageView);
        carImageView = view.findViewById(R.id.imageView2);

        // Initialize ViewModel
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        // Observe LiveData from ViewModel
        notificationsViewModel.getUsername().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String username) {
                usernameTextView.setText(username);
            }
        });

        notificationsViewModel.getEmail().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String email) {
                emailEditText.setText(email);
            }
        });

        notificationsViewModel.getPhone().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String phone) {
                phoneEditText.setText(phone);
            }
        });

        return view;
    }
}