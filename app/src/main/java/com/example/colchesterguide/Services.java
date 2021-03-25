package com.example.colchesterguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Services extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        setTitle("Extras");

        String urlString;
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        LinearLayout bus1 = findViewById(R.id.first_bus);
        bus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomPlace cp = new CustomPlace();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.firstbus.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout bus2 = findViewById(R.id.arriva);
        bus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.arrivabus.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout bus3 = findViewById(R.id.hedingham);
        bus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.hedingham.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout bus4 = findViewById(R.id.national_express);
        bus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.nationalexpress.com/en"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout hospital1 = findViewById(R.id.general_hospital);
        hospital1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.esneft.nhs.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout hospital2 = findViewById(R.id.Oaks_hospital);
        hospital2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.oakshospital.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout cab1 = findViewById(R.id.panther_cabs);
        cab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://panther-group.co.uk/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout cab2 = findViewById(R.id.five);
        cab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.fiveeightscolchester.com/"));
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout train_station1 = findViewById(R.id.cns);
        TextView tv = findViewById(R.id.station1);
        urlString = tv.getText().toString();

        train_station1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", 51.90084038815873, 0.892618571940472,urlString);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.setPackage("com.google.android.apps.maps");
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout train_station2 = findViewById(R.id.cts);
        train_station2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", 51.886582913557746, 0.9044312833726897,"Colchester Town Station, CO2 7EF");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.setPackage("com.google.android.apps.maps");
                if(isConnected()){startActivity(i);}
                else {DialogueActive();}
            }
        });

        LinearLayout train_station3 = findViewById(R.id.hythe);
        train_station3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", 51.88585784494856, 0.9276374274499095,"Hythe Station, CO2 8JZ");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.setPackage("com.google.android.apps.maps");
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Services.this);
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