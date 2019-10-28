package com.example.greencup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.MyViewHolder2> {

    private int[] images2;
    private List<String> item_name;
    private List<String> item_price;


    public RecyclerAdapter2(int[] images2, List<String> item_name, List<String> item_price)
    {
        this.images2=images2;
        this.item_name=item_name;
        this.item_price=item_price;
    }


    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list,parent,false);
        MyViewHolder2 myViewHolder2 = new MyViewHolder2(view);

        return myViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position)
    {
        holder.listImage.setImageResource(images2[position]);
        holder.itemName.setText(item_name.get(position));
        holder.itemPrice.setText(item_price.get(position));

    }

    @Override
    public int getItemCount() {
        return images2.length;
    }




    public static class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView listImage;
        private TextView itemName;
        private TextView itemPrice;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            listImage=itemView.findViewById(R.id.list_image);
            itemName=itemView.findViewById(R.id.item_name);
            itemPrice=itemView.findViewById(R.id.item_price);

        }

        @Override
        public void onClick(View view)
        {
           // Toast.makeText(,"Action Not Available",Toast.LENGTH_SHORT).show();

        }
    }

}
