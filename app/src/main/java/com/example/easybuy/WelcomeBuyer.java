package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeBuyer extends AppCompatActivity {
    Button btnBuyerSignIn,btnBuyerSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_buyer);

        btnBuyerSignIn =(Button)findViewById(R.id.btnBuyerSignIn);
        btnBuyerSignUp =(Button)findViewById(R.id.btnBuyerSignUp);

        btnBuyerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnBuyerSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUp = new Intent(WelcomeBuyer.this,SignUp.class);
                startActivity(SignUp);

            }
        });
        btnBuyerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(WelcomeBuyer.this,Signin.class);
                startActivity(signin);
            }
        });
    }
}


