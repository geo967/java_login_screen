package com.example.app1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    int[] images={R.drawable.garden3,R.drawable.garden2,R.drawable.garden3,R.drawable.garden4,R.drawable.garden5,R.drawable.garden6};
    int[] flowerImages={R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower12,R.drawable.flower13,R.drawable.flower1,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower12,R.drawable.flower13,R.drawable.flower1,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11, R.drawable.flower11,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower12,R.drawable.flower13,R.drawable.flower1,R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11};
    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager2;

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    int[] flowerId=new int[2];

    Button goToCartButton;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        viewPager2=findViewById(R.id.viewpager_layout);
        goToCartButton=findViewById(R.id.go_to_cart_button);
        viewPagerAdapter=new ViewPagerAdapter(images);

        viewPager2.setAdapter(viewPagerAdapter);

        recyclerView=findViewById(R.id.recycler_view_layout);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter=new RecyclerViewAdapter(this,flowerImages);
        recyclerView.setAdapter(recyclerViewAdapter);

        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,MyCart.class);
                startActivity(intent);

            }
        });

    }

}
