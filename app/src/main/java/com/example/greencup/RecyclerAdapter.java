package com.example.greencup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private int[] images;
    private Context context;
    private List<String> title;
    private List<String> ownerName;


    public RecyclerAdapter(List<String> title, List<String> ownerName,int[] images, Context context)
    {
        this.images=images;
        this.context=context;
        this.title=title;
        this.ownerName=ownerName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_display,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context,images);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.image_holder.setImageResource(images[position]);
        holder.shopView.setText(title.get(position));
        holder.ownerView.setText("Owner: "+ownerName.get(position));
        holder.getTextName(title.get(position),ownerName.get(position));


    }

    @Override
    public int getItemCount()
    {
        return images.length;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView shopView;
        private TextView ownerView;
        private ImageView image_holder;
        private Context context;
        private int[] images;
        private String clickName;
        private String clickOwner;


        public MyViewHolder(@NonNull View itemView, Context context, int[] images)
        {
            super(itemView);

            shopView=itemView.findViewById(R.id.store_shop_view);
            image_holder=itemView.findViewById(R.id.store_image_view);
            ownerView=itemView.findViewById(R.id.store_owner_view);

            this.context=context;
            this.images=images;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(context,DisplayActivity.class);

            Bundle extras= new Bundle();

            extras.putString("image_name",clickName);
            extras.putString("image_owner",clickOwner);
            extras.putInt("image_id",images[getAdapterPosition()]);

            intent.putExtras(extras);

            context.startActivity(intent);

        }

        public void getTextName(String shop_name, String shop_owner)
        {
            clickName=shop_name;
            clickOwner=shop_owner;
        }

    }


}
