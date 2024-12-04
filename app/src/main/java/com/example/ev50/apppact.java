package com.example.ev50;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.ev50.databinding.appactBinding; // Ensure this matches your layout file name

public class AppAct extends AppCompatActivity { // Renamed class to follow Java conventions

    private AppactBinding binding; // Use the correct binding class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AppactBinding.inflate(getLayoutInflater()); // Inflate the correct layout
        setContentView(binding.getRoot());

        BottomNavigationView navView = binding.navView; // Corrected to match the generated binding

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_appact);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController); // Use navView directly
    }
}