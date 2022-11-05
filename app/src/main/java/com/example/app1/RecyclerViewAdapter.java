package com.example.app1;


import android.content.Context;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


@RequiresApi(api = Build.VERSION_CODES.R)
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    ArrayList<Integer> flowerImagesForCart=new ArrayList<>();
    int[] flowerImages;
    Context context;
    FirstActivity firstActivity=new FirstActivity();
    CartDataBase cartDb=new CartDataBase();


    RecyclerViewAdapter(){

    }

    public RecyclerViewAdapter(Context context,int[] flowerImages) {
        this.context=context;
        this.flowerImages=flowerImages;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_design_for_recyclerview,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, int position) {
            holder.mg.setImageResource(flowerImages[position]);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.R)
                @Override
                public void onClick(View v) {

                    flowerImagesForCart.add(flowerImages[position]);
                    cartDb.setDataBase(1);
                   Toast.makeText(context,"Item Added to cart",Toast.LENGTH_SHORT).show();

                }

            });


    }


    @Override
    public int getItemCount() {
        return flowerImages.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        ImageView mg;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mg=itemView.findViewById(R.id.image_layout_of_recyclerview);
        }
    }

    public ArrayList<Integer> getFlowerToCartList(){
        return flowerImagesForCart;
    }

}

