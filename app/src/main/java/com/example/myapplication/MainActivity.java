package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private ProductAdapter productAdapter ;
    private ArrayList<Product_model> productModels ;
    private FloatingActionButton fab  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.RV_products) ;
            productModels= new ArrayList<>() ;
            productAdapter = new ProductAdapter(this,productModels) ;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            fab = findViewById(R.id.fab);
            recyclerView.setAdapter(productAdapter) ;
            fab.setOnClickListener(v -> {
            showDialog();
        });

    }
    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = LayoutInflater.from(this).inflate(R.layout.add_product, null);

        EditText productName = view.findViewById(R.id.product_name);
        EditText productPrice = view.findViewById(R.id.product_price) ;
        EditText productDescription = view.findViewById(R.id.product_description) ;
        Button cancelBtn = view.findViewById(R.id.cancel_btn);
        Button addBtn = view.findViewById(R.id.add_btn);

        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);

        cancelBtn.setOnClickListener(v->{
            alertDialog.dismiss();
        });

        addBtn.setOnClickListener(v->{
            String name = productName.getText().toString();
            String price = productPrice.getText().toString() ;
            String description = productDescription.getText().toString() ;
            if (name.equals("") || price.equals("") || description.equals("")){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }else {
                Product_model productModel = new Product_model(name,price,description) ;
                productModels.add(productModel);
                productAdapter.notifyDataSetChanged();
                alertDialog.dismiss();
                productAdapter.notifyDataSetChanged();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();


    }
}