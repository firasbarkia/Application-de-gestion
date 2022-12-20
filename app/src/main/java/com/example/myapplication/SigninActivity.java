package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SigninActivity extends AppCompatActivity {
    private String email , password ;
    private EditText U_email , U_password ;
    private FloatingActionButton fab ;
    DHelper dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        dbHelper = new DHelper(this);
        setContentView(R.layout.signin);
        U_email = findViewById(R.id.email) ;
        U_password= findViewById(R.id.password) ;
        fab = findViewById(R.id.sign) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser(v);

            }});
    }
    private void checkUser(View view){
        email = U_email.getText().toString() ;
        password = U_password.getText().toString() ;
        if(email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "messing email or password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(dbHelper.checkemail(email)==false){
                Toast.makeText(this, "email does not exit", Toast.LENGTH_SHORT).show();
            }
            else{
                if(dbHelper.checkemailpassword(email,password)==false){
                    Toast.makeText(this,"wrong password",Toast.LENGTH_SHORT).show() ;
                }
                else{
                    startActivity(new Intent(SigninActivity.this,Fournisseur.class));
                }
            }
        }
    }

    public void OpenSignupPage(View view) {
        startActivity(new Intent(SigninActivity.this,SignupActivity.class));
    }
}
