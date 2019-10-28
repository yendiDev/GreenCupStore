package com.example.greencup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderPlacement extends AppCompatActivity {

    private TextView user_name;
    private TextView user_email;
    private TextView user_phone;
    private TextView product_ID;
    private Button BnOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placement);

        user_name=findViewById(R.id.name_edit);
        user_email=findViewById(R.id.email_edit);
        user_phone=findViewById(R.id.phone_edit);
        product_ID=findViewById(R.id.product_ID_edit);
        BnOrder=findViewById(R.id.order_button);


        BnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                user_email.setText("");
                user_name.setText("");
                user_phone.setText("");
                product_ID.setText("");

                Toast.makeText(getApplicationContext(),"Order Placed Successfully",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
