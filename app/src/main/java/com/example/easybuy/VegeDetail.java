package com.example.easybuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.easybuy.Database.Database;
import com.example.easybuy.Model.Order;
import com.example.easybuy.Model.Vegetable;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class VegeDetail extends AppCompatActivity {

    TextView vegetable_name,vegetable_price,vegetable_description;
    ImageView vegetable_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String VegeId="";

    FirebaseDatabase database;
    DatabaseReference vegetables;

    Vegetable currentVegetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vege_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        vegetables = database.getReference("Vegetable");

        //Init view
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).addToCart(new Order(
                       VegeId,
                        currentVegetable.getName(),
                        numberButton.getNumber(),
                        currentVegetable.getPrice(),
                        currentVegetable.getDiscount()

                ));

                Toast.makeText(VegeDetail.this, "Added to Cart", Toast.LENGTH_SHORT).show();

            }
        });


        vegetable_description = (TextView)findViewById(R.id.vegetable_description);
        vegetable_name= (TextView)findViewById(R.id.vegetable_name);
        vegetable_price= (TextView)findViewById(R.id.vegetable_price);
        vegetable_image= (ImageView)findViewById(R.id.img_vegetable);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);

        //Get VegeId from Intent
        if(getIntent() != null)
            VegeId = getIntent().getStringExtra("VegeId");
        if (!VegeId.isEmpty()){
            getDetailVegetable(VegeId);
        }
    }

    private void getDetailVegetable(String vegeId) {
        vegetables.child(VegeId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentVegetable = dataSnapshot.getValue(Vegetable.class);

                //Set Image
                Picasso.get().load(currentVegetable.getImage())
                        .into(vegetable_image);

                collapsingToolbarLayout.setTitle(currentVegetable.getName());

                vegetable_price.setText(currentVegetable.getPrice());

                vegetable_name.setText(currentVegetable.getName());

                vegetable_description.setText(currentVegetable.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
