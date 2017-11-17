package com.example.aditya.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.String;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class authentication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    public void authenticate(View v){
        EditText pass = (EditText) findViewById(R.id.adminPassword);
        String given = pass.getText().toString();
        if(given.equals("java102")){
            Intent i = new Intent(this, MenuMaker.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,Home.class);
            startActivity(i);
        }

    }
}
