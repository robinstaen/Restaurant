package com.example.aditya.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuMaker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_maker);
    }

    public void addToMenu(View v){
        EditText name = (EditText) findViewById(R.id.nameOfDish);
        EditText price = (EditText) findViewById(R.id.Price);

        Restaurant.add(name.getText().toString(), Integer.parseInt(price.getText().toString()));

        name.setText("");
        price.setText("");
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();

    }
    public void removeFromMenu(View v){
        EditText name = (EditText) findViewById(R.id.nameOfDish);
        EditText price = (EditText) findViewById(R.id.Price);
        Restaurant.menu.remove(name.getText().toString().trim());
        name.setText("");
        price.setText("");
        Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
