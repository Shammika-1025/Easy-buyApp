package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.easybuy.ui.mainsignout.MainsignoutFragment;

public class Mainsignout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainsignout_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainsignoutFragment.newInstance())
                    .commitNow();
        }
    }
}
