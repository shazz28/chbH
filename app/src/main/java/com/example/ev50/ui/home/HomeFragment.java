package com.example.ev50.ui.home;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ev50.R;
import com.example.ev50.BluetoothService;

public class HomeFragment extends Fragment implements BluetoothService.ConnectionListener {

    private HomeViewModel homeViewModel;
    private BluetoothService bluetoothService;
    private boolean isBound = false;

    private TextView textViewConnecting;
    private ImageView imageViewCar;
    private TextView textViewConnected;
    private TextView textViewBattery;
    private TextView textViewRange;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize ViewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Initialize views
        textViewConnecting = root.findViewById(R.id.textView);
        imageViewCar = root.findViewById(R.id.car);
        textViewConnected = root.findViewById(R.id.textView2);
        textViewBattery = root.findViewById(R.id.textView3);
        textViewRange = root.findViewById(R.id.textView4);

        // Set initial text
        textViewConnecting.setText("Connecting to your vehicle...");
        imageViewCar.setImageResource(R.drawable.car);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Intent intent = new Intent(getActivity(), BluetoothService.class);
        getActivity().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (isBound) {
            getActivity().unbindService(serviceConnection);
            isBound = false;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BluetoothService.LocalBinder binder = (BluetoothService.LocalBinder) service;
            isBound = true;
            bluetoothService.setConnectionListener(HomeFragment.this);
            bluetoothService.simulateBluetoothConnection();  // Start simulation for demo
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    public void onConnectionStatusChanged(boolean isConnected) {
        if (isConnected) {
            textViewConnected.setVisibility(View.VISIBLE);
            textViewConnected.setText("Connected Successfully");
            textViewConnecting.setVisibility(View.GONE);
        } else {
            textViewConnected.setVisibility(View.GONE);
            textViewConnecting.setVisibility(View.VISIBLE);
            textViewConnecting.setText("Connecting to your vehicle...");
        }
    }

    @Override
    public void onBatteryPercentageReceived(String percentage) {
        textViewBattery.setText("Battery %: " + percentage);
        homeViewModel.setBatteryPercentage(percentage); // Update ViewModel
    }

    @Override
    public void onRangeReceived(String range) {
        textViewRange.setText("Range: " + range);
        homeViewModel.setRange(range); // Update ViewModel
    }
}
