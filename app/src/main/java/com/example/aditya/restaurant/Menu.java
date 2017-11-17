package com.example.aditya.restaurant;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Menu extends AppCompatActivity {


    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<Integer> quantity = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ArrayList<String> al = new ArrayList<String>();
        al.addAll(Restaurant.menu.keySet());

        final ListView lv = (ListView) findViewById(R.id.TheMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_layout, al);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView) view).getText().toString();
                if(names.indexOf(item) == -1){
                    view.setBackgroundColor(Color.WHITE);
                    names.add(item);
                    quantity.add(1);
                }else{
                    if(quantity.get(names.indexOf(item)) == 1)
                        view.setBackgroundColor(Color.GRAY);
                    else if(quantity.get(names.indexOf(item)) == 2)
                        view.setBackgroundColor(Color.CYAN);
                    quantity.set(names.indexOf(item),quantity.get(names.indexOf(item))+1);
                }
            }
        });
    }

    public void toBill(View v){
        Intent i = new Intent(this,Bill.class);
        i.putExtra("names",names);
        i.putExtra("quantity",quantity);
        startActivity(i);
    }
}
