package com.example.colchesterguide;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Restaurants");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ItemList restaurant_list = new ItemList();

        restaurant_list.add(getString(R.string.res1), getString(R.string.res1_info), R.drawable.el_guaca); //El Guaca
        restaurant_list.add(getString(R.string.res2),getString(R.string.res2_info),R.drawable.nandos);  //Nandos
        restaurant_list.add(getString(R.string.res3),getString(R.string.res3_info),R.drawable.pitta_lab);  //Pitta
        restaurant_list.add(getString(R.string.res4),getString(R.string.res4_info),R.drawable.purple_dog);  //Purple Dog
        restaurant_list.add(getString(R.string.res5),getString(R.string.res5_info),R.drawable.kaspas);  //Kaspas
        restaurant_list.add(getString(R.string.res6),getString(R.string.res6_info),R.drawable.church_street_tavern);  //Church Street Tavern

        ItemAdapter restaurantAdapter = new ItemAdapter(this, restaurant_list.get());
        ListView listView = findViewById(R.id.custom_full_list);
        listView.setAdapter(restaurantAdapter);
    }

    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}
