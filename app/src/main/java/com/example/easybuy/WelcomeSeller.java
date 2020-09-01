package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeSeller extends AppCompatActivity {
    Button btnSellerSignIn,btnSellerSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_seller);

        btnSellerSignIn =(Button)findViewById(R.id.btnSellerSignIn);
        btnSellerSignUp =(Button)findViewById(R.id.btnBuyerSignUp);

        btnSellerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
