package com.example.zalisme.restaurantcashier;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Summary extends AppCompatActivity  {
    List<Menu> menusatu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        menusatu = new ArrayList<>();

        Intent intent = getIntent();

        menusatu = (List<Menu>) intent.getSerializableExtra("value");


        RecyclerView myrv =  (RecyclerView) findViewById(R.id.recyclerview2_id);
        RecylerViewAdapter2 myAdapter = new RecylerViewAdapter2(this,menusatu);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);

        final TextView totalbuy = (TextView) findViewById(R.id.total_buy_id);
        Button submit = (Button) findViewById(R.id.submit_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int buytotal = menusatu.get(0).getQuantity()*menusatu.get(0).getPrice()
                        + menusatu.get(1).getQuantity()*menusatu.get(1).getPrice()
                        + menusatu.get(2).getQuantity()*menusatu.get(2).getPrice()
                        + menusatu.get(3).getQuantity()*menusatu.get(3).getPrice()
                        + menusatu.get(4).getQuantity()*menusatu.get(4).getPrice()
                        + menusatu.get(5).getQuantity()*menusatu.get(5).getPrice()
                        + menusatu.get(6).getQuantity()*menusatu.get(6).getPrice()
                        + menusatu.get(7).getQuantity()*menusatu.get(7).getPrice()
                        + menusatu.get(8).getQuantity()*menusatu.get(8).getPrice();
                totalbuy.setText("Total = $" + buytotal );
                Toast.makeText(getApplicationContext()," Done !  ",Toast.LENGTH_SHORT).show();



            }
        });
        totalbuy.setText("Total = $0" );


    }
}
