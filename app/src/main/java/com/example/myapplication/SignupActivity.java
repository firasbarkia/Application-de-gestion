package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputBinding;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SignupActivity extends AppCompatActivity {
    Client client;
    DHelper dbHelper;
    EditText nameId, emailId, passwordId;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.signup);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new Client();
        nameId = findViewById(R.id.name);
        emailId = findViewById(R.id.Email);
        passwordId = findViewById(R.id.password);
        fab = findViewById(R.id.fab);
        dbHelper = new DHelper(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.saveData(nameId,emailId,passwordId);

            }
        });
    }


    private class Client implements Runnable {
        private String message;
        private String name, email, password;
        Socket socket;
        DataOutputStream dos ;
        private volatile String msg = "";

        @Override
        public void run() {
            try {
                socket = new Socket("192.168.13.210", 1234);
                dos = new DataOutputStream(socket.getOutputStream()) ;
                dos.writeUTF(msg);
                dos.close();
                dos.flush();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        private void saveData(EditText nameId,EditText emailID,EditText passwordId) {
            name = nameId.getText().toString();
            email = emailId.getText().toString();
            password = passwordId.getText().toString();
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Nothing to save....", Toast.LENGTH_SHORT).show();
            } else {
                long id = dbHelper.insertUser(
                        "" + name,
                        "" + email,
                        "" + password
                );
                msg =name+" "+email+" "+password;
                run();
                Toast.makeText(getApplicationContext(), "Inserted Successfully.... " + id, Toast.LENGTH_SHORT).show();

            }
        }


    }public void OpenSigninPage(View view) {
        startActivity(new Intent(SignupActivity.this, SigninActivity.class));
    }
}



