package com.example.colchesterguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import java.util.List;
import java.util.Objects;

public class Places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        setTitle("Places TO Visit");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        FrameLayout park = findViewById(R.id.castle_park);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","cpark");
                startActivity(i);

            }
        });

        FrameLayout zoo = findViewById(R.id.zoo);
        zoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","czoo");
                startActivity(i);

            }
        });

        FrameLayout priory = findViewById(R.id.ruins);
        priory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","cpriory");
                startActivity(i);

            }
        });
        FrameLayout trail = findViewById(R.id.park);
        trail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","ctrail");
                startActivity(i);
            }
        });

        FrameLayout park2 = findViewById(R.id.park2);
        park2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","cpark2");
                startActivity(i);

            }
        });

        FrameLayout art = findViewById(R.id.art);
        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Places.this,CustomPlace.class);
                i.putExtra("park","cart");
                startActivity(i);

            }
        });

    }
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }
}