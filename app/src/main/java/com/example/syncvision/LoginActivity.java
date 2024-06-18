package com.example.syncvision;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    SwitchCompat switchMode;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Implementation of the onCreate life cycle activity
        Log.d(TAG, "OnCreate called");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        switchMode = findViewById(R.id.switchModeLogin);
        sharedPreferences = getSharedPreferences( "MODE", Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("nightMode", false);
        if(nightMode){
            switchMode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("nightMode", true);

                }
                editor.apply();
            }
        });

        TextView btn = findViewById(R.id.letsRegisterLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }

        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        //The activity is about to become visible
        //Example: Start animations, refresh UI elements
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume called");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        //The activity has become visible (it is now "resumed")
        //Example: Resume paused operations like a video or game
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        //Another activity is taking focus (this activity is about to be "paused")
        //Example: Pause ongoing actions (e.g, animations, video playback)
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        //The activity is no longer visible (It is now "stopped")
        //Example: Release resources, save data to persistent storage
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        //The activity is about to be destroyed
        //Example: Clean up resources, finalize operations
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        //The activity is about to be restarted after it was stopped
        //Example: Re-initialize components that were released in onStop()
    }
}