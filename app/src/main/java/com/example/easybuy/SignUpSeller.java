package com.example.easybuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.easybuy.Model.Shops;
import com.example.easybuy.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUpSeller extends AppCompatActivity {

    MaterialEditText edtShopName,edtShopAddress,edtShopPhn,edtPassword,edtLocation;
    Button btnSellerSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller);

        edtShopName = (MaterialEditText)findViewById(R.id.edtShopName);
        edtShopAddress = (MaterialEditText)findViewById(R.id.edtShopAddress);
        edtShopPhn = (MaterialEditText)findViewById(R.id.edtShopPhn);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtLocation = (MaterialEditText)findViewById(R.id.edtLocation);

        btnSellerSignUp = (Button)findViewById(R.id.btnSellerSignUp);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Shops");

        btnSellerSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignUpSeller.this);
                mDialog.setMessage("Please Waiting....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Check if already user phone
                        if (dataSnapshot.child(edtShopPhn.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(SignUpSeller.this, "Phone Number already register", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            Shops shops = new Shops(edtShopName.getText().toString(),edtShopAddress.getText().toString(),edtShopPhn.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtShopPhn.getText().toString()).setValue(shops);
                            Toast.makeText(SignUpSeller.this, "Sign up  successfully!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
