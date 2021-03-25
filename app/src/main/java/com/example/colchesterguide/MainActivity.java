package com.example.colchesterguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Colchester City Guide");

        LinearLayout place = findViewById(R.id.places);
        place.setOnClickListener(sendTo(Places.class));

        LinearLayout restaurant = findViewById(R.id.restaurants);
        restaurant.setOnClickListener(sendTo(Restaurants.class));

        LinearLayout history = findViewById(R.id.history);
        history.setOnClickListener(sendTo(History.class));

        LinearLayout GeneralInfo = findViewById(R.id.GeneralInfo);
        GeneralInfo.setOnClickListener(sendTo(InfoActivity.class));

        LinearLayout services = findViewById(R.id.services);
        services.setOnClickListener(sendTo(Services.class));

        LinearLayout activities = findViewById(R.id.activities);
        activities.setOnClickListener(sendTo(Activities.class));

    }

    public View.OnClickListener sendTo(final Class className)
    {
        Intent intent = new Intent(MainActivity.this,className);
        return (v) -> {startActivity(intent);};
    }
}