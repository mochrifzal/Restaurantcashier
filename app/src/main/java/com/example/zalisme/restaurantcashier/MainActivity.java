package com.example.zalisme.restaurantcashier;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public List<Menu> menusatu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menusatu = new ArrayList<>();
        menusatu.add(new Menu("Burger", R.drawable.burger,10,0));
        menusatu.add(new Menu("Coca-cola",R.drawable.coca_cola,2,0));
        menusatu.add(new Menu("Coffe",R.drawable.coffe,5,0));
        menusatu.add(new Menu("Ice Tea",R.drawable.es_teh,2,0));
        menusatu.add(new Menu("Ice Cream",R.drawable.ice_cream,4,0));
        menusatu.add(new Menu("Sphagetti",R.drawable.mie,6,0));
        menusatu.add(new Menu("Fried Rice",R.drawable.nasi_goreng,7,0));
        menusatu.add(new Menu("Pepsi",R.drawable.pepsi,1,0));
        menusatu.add(new Menu("Vegetable", R.drawable.sayur,3,0));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecylerViewAdapter myAdapter = new RecylerViewAdapter(this,menusatu);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
        Button button = (Button) findViewById(R.id.gosummary_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Summary.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("value", (Serializable) menusatu);
                intent.putExtras(bundle);

                startActivity(intent);

                MainActivity.this.startActivity(intent);

            }
        });



    }
}
