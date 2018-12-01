package com.example.zalisme.restaurantcashier;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {
    private Context mContext ;
    private List<Menu> mData ;


    public RecylerViewAdapter(Context mContext, List<Menu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_menu , viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_menu_title.setText(mData.get(i).getTitles());
        myViewHolder.img_menu_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,myViewHolder.tv_menu_title.getText()+ " Has been added",Toast.LENGTH_SHORT).show();
                int quantity = mData.get(i).getQuantity();
                quantity ++;
                mData.get(i).setQuantity(quantity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_menu_title;
        ImageView img_menu_thumbnail;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_menu_title = (TextView) itemView.findViewById(R.id.menu_title_id);
            img_menu_thumbnail = (ImageView) itemView.findViewById(R.id.menu_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
