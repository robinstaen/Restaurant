package com.example.aditya.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        Intent in = getIntent();
        ArrayList<String> names = in.getStringArrayListExtra("names");
        ArrayList<Integer> quantity = in.getIntegerArrayListExtra("quantity");
        int total = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0 ; i < names.size();++i){
            total += Restaurant.menu.get(names.get(i))*quantity.get(i);
            String name = names.get(i);
            int price = Restaurant.menu.get(name);
            int qua = quantity.get(i);
            result.add(name + " Quantity = "+ qua + " Price = "+ price + " Total = "+ (price*qua));
        }

        ListView lv = (ListView) findViewById(R.id.bill);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_layout, result);
        lv.setAdapter(adapter);

        TextView ammount = (TextView) findViewById(R.id.amount);
        ammount.setText("The bill is "+total);


    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
