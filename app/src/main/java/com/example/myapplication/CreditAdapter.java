package com.example.myapplication ;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.ViewHolder>{

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        TextView p_id , u_id , restepayer ,nbtranche ;

        public ViewHolder(View itemView){
            super(itemView) ;

            p_id = itemView.findViewById(R.id.u_id) ;
            u_id = itemView.findViewById(R.id.p_id) ;
            restepayer = itemView.findViewById(R.id.restepayer) ;
            nbtranche = itemView.findViewById(R.id.nbtranche) ;
        }
    }

    private Context context ;
    private ArrayList<CreditModel> credites ;
    public  CreditAdapter(Context c , ArrayList<CreditModel> creditModels){
        this.context = c ;
        this.credites = creditModels;
    }
    @NonNull
    @Override
    public CreditAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout2, parent , false) ;
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditAdapter.ViewHolder holder, int position) {

        CreditModel c = credites.get(position) ;
        holder.p_id.setText(c.getP_id());
        holder.u_id.setText(c.getU_id());
        holder.nbtranche.setText(c.getNbtranche());
        holder.restepayer.setText(c.restepayer);

    }

    @Override
    public int getItemCount() {
        return credites.size();
    }
}