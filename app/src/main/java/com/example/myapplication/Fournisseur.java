package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputBinding;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Fournisseur extends AppCompatActivity {
    Button fab,fab1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fornisseur);
        fab = findViewById(R.id.credit) ;
        fab1 = findViewById(R.id.product) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCredit(v);

            }});
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenProduit(v);

            }});
    }
    public void OpenProduit(View view) {
        startActivity(new Intent(Fournisseur.this,MainActivity.class));
    }
    public void OpenCredit(View view) {
        startActivity(new Intent(Fournisseur.this,CreditList.class));
    }
}



