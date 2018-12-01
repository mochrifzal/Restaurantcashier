package com.example.zalisme.restaurantcashier;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecylerViewAdapter2 extends RecyclerView.Adapter<RecylerViewAdapter2.MyViewHolder2>{
    private Context mContext;
    private List<Menu> mData;

    public RecylerViewAdapter2(Context mContext, List<Menu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.listview_summary,viewGroup,false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder2 myViewHolder2, final int i) {
        myViewHolder2.tv_menu_title.setText(mData.get(i).getTitles());
        myViewHolder2.tv_price.setText("Price: $ "+mData.get(i).getPrice() );
        myViewHolder2.tv_quantity.setText(""+mData.get(i).getQuantity() );
        myViewHolder2.button_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = mData.get(i).getQuantity();
                quantity = quantity - 1;
                mData.get(i).setQuantity(quantity);
                myViewHolder2.tv_quantity.setText(""+mData.get(i).getQuantity() );
            }
        });
        myViewHolder2.button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = mData.get(i).getQuantity();
                quantity++;
                mData.get(i).setQuantity(quantity);
                myViewHolder2.tv_quantity.setText(""+mData.get(i).getQuantity() );


            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

        TextView tv_menu_title;
        TextView tv_price;
        Button button_min;
        TextView tv_quantity;
        Button button_plus;
        LinearLayout linearlayout;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            tv_menu_title = (TextView) itemView.findViewById(R.id.menu_title_id);
            tv_price = (TextView) itemView.findViewById(R.id.price_id);
            button_min = (Button) itemView.findViewById(R.id.button_min);
            tv_quantity = (TextView) itemView.findViewById(R.id.quantity_id);
            button_plus = (Button)itemView.findViewById(R.id.button_plus);
            linearlayout = (LinearLayout) itemView.findViewById(R.id.listview_summary_id);
        }
    }
}
