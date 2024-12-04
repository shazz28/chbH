package com.example.ev50;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BluetoothService extends Service {
    private final IBinder binder = new LocalBinder();
    private ConnectionListener connectionListener;

    public class LocalBinder extends Binder {
        BluetoothService getService() {
            return BluetoothService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void setConnectionListener(ConnectionListener listener) {
        this.connectionListener = listener;
    }

    // Simulate Bluetooth connection and data
    public void simulateBluetoothConnection() {
        if (connectionListener != null) {
            // Simulate Bluetooth connection in a separate thread
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Simulate Bluetooth connection
                    connectionListener.onConnectionStatusChanged(true);
                    connectionListener.onBatteryPercentageReceived("80%");
                    connectionListener.onRangeReceived("150 km");
                }
            }).start();
        }
    }

    public interface ConnectionListener {
        void onConnectionStatusChanged(boolean isConnected);
        void onBatteryPercentageReceived(String percentage);
        void onRangeReceived(String range);
    }
}