package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.easybuy.ui.mainorders.MainordersFragment;

public class Mainorders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainorders_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainordersFragment.newInstance())
                    .commitNow();
        }
    }
}
