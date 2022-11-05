package com.example.app1;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.R)
public class MyCart extends AppCompatActivity {
    ArrayList<Integer> flowerImages=new ArrayList<Integer>(List.of(R.drawable.flower1,R.drawable.flower2,R.drawable.flower3,R.drawable.flower4,R.drawable.flower5,R.drawable.flower6,R.drawable.flower7,R.drawable.flower8,R.drawable.flower9,R.drawable.flower10,
            R.drawable.flower11,R.drawable.flower12,R.drawable.flower13));



    ArrayList<Integer> nos=new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,7));

    ArrayList<Integer> flowerId=new ArrayList<>();
    ListView listView;

    RecyclerViewAdapter recy=new RecyclerViewAdapter();

    CartDataBase cartDb=new CartDataBase();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cart_design);
        listView=findViewById(R.id.list_view);


        flowerId=cartDb.getDataBase();





        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,flowerId);
        listView.setAdapter(adapter);




    }
}
