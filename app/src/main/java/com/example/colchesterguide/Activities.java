package com.example.colchesterguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.FrameLayout;

import java.net.URI;
import java.util.Objects;

public class Activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        setTitle("Activities");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        FrameLayout shop = findViewById(R.id.shopping);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activities.this,CustomPlace.class);
                i.putExtra("shop","shopping");
                startActivity(i);

            }
        });

        FrameLayout water = findViewById(R.id.water_world);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.colchestercanoeclub.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        FrameLayout adv = findViewById(R.id.adventure_world);
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.tenpin.co.uk/our-locations/colchester/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}

            }
        });

        FrameLayout trail = findViewById(R.id.wivenhoe);
        trail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.visitcolchester.com/things-to-do/the-wivenhoe-trail-p1250381"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        FrameLayout musuem = findViewById(R.id.museum);
        musuem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://colchester.cimuseums.org.uk/visit/natural-history-museum/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        FrameLayout park = findViewById(R.id.NaturePark);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.nga.gov/collection/art-object-page.1147.html"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });
    }
    public boolean onSupportNavigateUp()
    {
        finish();
        return true;
    }

    public boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else
            return false;
    }

    public void DialogueActive()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Activities.this);
        builder.setMessage("You are not connected to the internet. Check your network connectivity & try again");
        builder.setTitle("Alert !");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setNegativeButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}