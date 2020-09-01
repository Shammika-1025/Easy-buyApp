package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBuyer,btnSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSeller =(Button)findViewById(R.id.btnSeller);
        btnBuyer =(Button)findViewById(R.id.btnBuyer);

        btnBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome_buyer = new Intent(MainActivity.this,WelcomeBuyer.class);
                startActivity(welcome_buyer);

            }
        });
        btnSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome_seller = new Intent(MainActivity.this,WelcomeSeller.class);
                startActivity(welcome_seller);
            }
        });
    }
}
