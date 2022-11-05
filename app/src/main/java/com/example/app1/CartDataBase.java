package com.example.app1;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class CartDataBase {
    ArrayList<Integer> flowerImages=new ArrayList<Integer>(List.of(R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower12,R.drawable.flower13));

    ArrayList<Integer> flowerImagesForCart=new ArrayList<Integer>();

    public void setDataBase(Integer x){
        flowerImagesForCart.add(x);
    }

    public ArrayList<Integer> getDataBase(){
        return flowerImagesForCart;
    }
}
