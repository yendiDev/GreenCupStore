package com.example.greencup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private List<String> title;
    private List<String> ownerName;

    private RecyclerAdapter adapter;

    private Context context;



   private int[] images={R.drawable.farm,R.drawable.day,R.drawable.burger,R.drawable.chef,R.drawable.chicken};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        title= Arrays.asList(getResources().getStringArray(R.array.shop_names));
        ownerName=Arrays.asList(getResources().getStringArray(R.array.shop_owners));



        adapter = new RecyclerAdapter(title,ownerName,images,this);
        recyclerView.setAdapter(adapter);




    }
}
