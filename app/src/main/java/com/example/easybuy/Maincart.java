package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.easybuy.ui.maincart.MaincartFragment;

public class Maincart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincart_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MaincartFragment.newInstance())
                    .commitNow();
        }
    }
}
