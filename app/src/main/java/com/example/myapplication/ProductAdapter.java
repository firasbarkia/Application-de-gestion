package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name , price , description ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name) ;
            price = itemView.findViewById(R.id.price) ;
            description = itemView.findViewById(R.id.description) ;
        }
    }
    private Context context ;
    private ArrayList<Product_model> products ;
    public ProductAdapter(Context context , ArrayList<Product_model > products){
        this.context = context ;
        this.products = products ;
    }
    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false) ;
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product_model p = products.get(position) ;

        holder.name.setText(p.getName()) ;
        holder.price.setText(p.getPrice());
        holder.description.setText(p.getDescription());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
