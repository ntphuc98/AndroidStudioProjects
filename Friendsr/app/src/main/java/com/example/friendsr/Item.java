package com.example.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Item extends BaseAdapter {

    ArrayList<Product> brands;
    Context context;
    LayoutInflater inflater;
    private  String TAG = "ItemActivity";
    public Item(ArrayList<Product> brands, Context context) {
        this.brands = brands;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return  brands.size();
    }

    @Override
    public Object getItem(int i) {
        return  brands. get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder{
        TextView nameTV;
        TextView descTV;
        ImageView brandIMV;
        RatingBar ratingBar;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){
            view = inflater.inflate(R.layout.activity_item,null);
            viewHolder=new ViewHolder();
            viewHolder.nameTV=view.findViewById(R.id.name);
            viewHolder.brandIMV=view.findViewById(R.id.hinhanh);
            viewHolder.ratingBar = view.findViewById(R.id.ratingBar2);
            view.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.nameTV.setText(brands.get(i).getName());
        viewHolder.brandIMV.setImageDrawable(
                context.getResources().getDrawable(brands.get(i).getImage()));
        viewHolder.ratingBar.setRating(brands.get(i).getRating());
        return view;
    }
}
