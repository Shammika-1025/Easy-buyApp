package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.easybuy.ui.mainmenu.MainmenuFragment;

public class Mainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainmenuFragment.newInstance())
                    .commitNow();
        }
    }
}
