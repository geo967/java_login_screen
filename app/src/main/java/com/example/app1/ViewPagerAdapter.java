package com.example.app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.MyHolder> {
    int[] images;
    public ViewPagerAdapter(int[] images) {
        this.images=images;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design_for_viewpager,parent,false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.MyHolder holder, int position) {
        holder.mg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        ImageView mg;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mg=itemView.findViewById(R.id.image_View_for_viewPager);
        }
    }
}
