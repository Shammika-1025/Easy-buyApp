package com.example.easybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.easybuy.Interface.ItemClickListener;
import com.example.easybuy.Model.Vegetable;
import com.example.easybuy.ViewHolder.VegetableViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class VegetableList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference vegetableList;

    String categoryId="";

    FirebaseRecyclerAdapter<Vegetable,VegetableViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_list);

        //firebase
        database = FirebaseDatabase.getInstance();
        vegetableList = database.getReference("Vegetable");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_vegetable);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent here
        if (getIntent() !=null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty() && categoryId !=null){

            loadListVegetable(categoryId);
        }


    }

    private void loadListVegetable(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Vegetable, VegetableViewHolder>(Vegetable.class,
                R.layout.vegetable_item,
                VegetableViewHolder.class,
                vegetableList.orderByChild("MenuId").equalTo(categoryId)
                ) {
            @Override
            protected void populateViewHolder(VegetableViewHolder viewHolder, Vegetable model, int position) {
                viewHolder.vegetable_name.setText(model.getName());
               // Picasso.get().load(model.getImage())
                       // .into(viewHolder.vegetable_image);
                Picasso.get()
                        .load("Vegetable")
                        .into(viewHolder.vegetable_image);

                final Vegetable local =model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Start new Activity
                        Intent vegeDetail = new Intent(VegetableList.this,VegeDetail.class);
                        vegeDetail.putExtra("VegeId",adapter.getRef(position).getKey());//send Vegetable Id to new activity
                        startActivity(vegeDetail);



                    }
                });

            }
        };
        //Set Adapter
        recyclerView.setAdapter(adapter);
    }
}
