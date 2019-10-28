package com.example.greencup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameView;
    private TextView ownerView;
    private Button BnBuy;
    private Context context;

    private List<String> item_name;
    private List<String> item_price;


    private RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerAdapter2 adapter2;

    private int[] images2={

            R.drawable.pic1,R.drawable.pic2,
            R.drawable.pic3,R.drawable.pic4,
            R.drawable.pic5,R.drawable.pic6,
            R.drawable.pic7,R.drawable.pic8,
            R.drawable.pic9,R.drawable.pic10,

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView=findViewById(R.id.gallery_image);
        nameView=findViewById(R.id.display_shop_name);
        ownerView=findViewById(R.id.display_shop_owner);

        context=this;

        item_name= Arrays.asList(getResources().getStringArray(R.array.item_name));
        item_price=Arrays.asList(getResources().getStringArray(R.array.item_price));


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int imageID = bundle.getInt("image_id");
        String name = bundle.getString("image_name");
        String owner = bundle.getString("image_owner");

        imageView.setImageResource(imageID);
        nameView.setText(name);
        ownerView.setText(owner);


        recyclerView2=findViewById(R.id.recyclerView2);
        layoutManager2 = new GridLayoutManager(this,1);
        recyclerView2.setLayoutManager(layoutManager2);

        adapter2= new RecyclerAdapter2(images2,item_name,item_price);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(adapter2);

    }
}
