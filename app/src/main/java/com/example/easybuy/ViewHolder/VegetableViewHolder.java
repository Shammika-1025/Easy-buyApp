package com.example.easybuy.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuy.Interface.ItemClickListener;
import com.example.easybuy.R;

public class VegetableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView vegetable_name;
    public ImageView vegetable_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public VegetableViewHolder(@NonNull View itemView) {
        super(itemView);

        vegetable_name = (TextView)itemView.findViewById(R.id.vegetable_name);
        vegetable_image = (ImageView)itemView.findViewById(R.id.vegetable_image);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
