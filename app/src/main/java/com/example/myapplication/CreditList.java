package com.example.myapplication ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CreditList extends AppCompatActivity{
    private RecyclerView recyclerView ;
    private CreditAdapter creditAdpater ;
    private ArrayList<CreditModel>  creditModels ;
    private FloatingActionButton fab  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_list);

        recyclerView = (RecyclerView) findViewById(R.id.RV_Credits) ;
        creditModels = new ArrayList<>() ;

        creditAdpater = new CreditAdapter(this,creditModels) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(creditAdpater);
        fab = findViewById(R.id.fab);
        recyclerView.setAdapter(creditAdpater) ;
        fab.setOnClickListener(v -> {
            showDialog();
        });

    }
    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = LayoutInflater.from(this).inflate(R.layout.add_credit, null);

        EditText p_id = view.findViewById(R.id.p_id);
        EditText u_id = view.findViewById(R.id.u_id) ;
        EditText restepayer= view.findViewById(R.id.restepayer) ;
        EditText nbtranche = view.findViewById(R.id.nbtranche) ;
        Button cancelBtn = view.findViewById(R.id.cancel_btn);
        Button addBtn = view.findViewById(R.id.add_btn);

        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);

        cancelBtn.setOnClickListener(v->{
            alertDialog.dismiss();
        });

        addBtn.setOnClickListener(v->{
            String pid = p_id.getText().toString();
            String uid = u_id.getText().toString() ;
            String reste_payer = restepayer.getText().toString() ;
            String nb_tranche = nbtranche.getText().toString() ;
            if (pid.equals("") || uid.equals("") || reste_payer.equals("")|| nb_tranche.equals("")){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }else {
                CreditModel creditModel = new CreditModel(pid,uid,reste_payer,nb_tranche) ;
                creditModels.add(creditModel);
                creditAdpater.notifyDataSetChanged();
                alertDialog.dismiss();
                creditAdpater.notifyDataSetChanged();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();


    }
    }