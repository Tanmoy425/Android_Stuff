package com.example.colchesterguide;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Locale;
import java.util.Objects;

public class CustomPlace extends AppCompatActivity {

    ViewFlipper viewFlipper;
    String newString,string2,urlString;
    float lat,longitude=0.0f;
    boolean connected = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_place);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        int[] images1 = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        newString = bundle.getString("park");
        string2 = bundle.getString("shop");

        TextView textView = findViewById(R.id.title);
        TextView text = findViewById(R.id.body);
        ImageView imageView = findViewById(R.id.img1);
        ImageView imageView2 = findViewById(R.id.img2);
        ImageView imageView3 = findViewById(R.id.img3);





        if(newString !=null)
        {
            if(newString.equals("cpark"))
            {

                System.out.println("castle park");
                textView.setText(R.string.castle_park);
                text.setText(R.string.castle_info);

                imageView.setBackgroundResource(R.drawable.castle_park3);

                imageView2.setBackgroundResource(R.drawable.castle_park2);

                imageView3.setBackgroundResource(R.drawable.castle_park4);

                lat = 51.892946486764096f;
                longitude = 0.9035042851227706f;
                urlString = "Castle Park, Colchester";

            }

            else if(newString.equals("czoo"))
            {
                textView.setText(R.string.zoo);
                text.setText(R.string.zoo_info);

                imageView.setBackgroundResource(R.drawable.zoo1);

                imageView2.setBackgroundResource(R.drawable.zoo2);

                imageView3.setBackgroundResource(R.drawable.zoo3);

                lat = 51.86280991131496f;
                longitude = 0.8344610165355363f;
                urlString = "Colchester zoo, Colchester CO3 0SL";
            }

            else if(newString.equals("cpriory"))
            {
                textView.setText(R.string.ruins);
                text.setText(R.string.ruins_info);

                imageView.setBackgroundResource(R.drawable.priory1);

                imageView2.setBackgroundResource(R.drawable.priory3);

                imageView3.setBackgroundResource(R.drawable.priory2);
                lat = 51.887386688750006f; longitude = 0.9042726465739719f;
                urlString = "St Botolph's Church Walk, Colchester CO2 7EE";
            }

            else if(newString.equals("ctrail"))
            {
                textView.setText(R.string.park);
                text.setText(R.string.park_info);

                imageView.setBackgroundResource(R.drawable.wivenhoe1);

                imageView2.setBackgroundResource(R.drawable.wivenhoe2);

                imageView3.setBackgroundResource(R.drawable.wivenhoe3);
                lat = 51.871436119780306f; longitude = 0.9408441697768176f;
                urlString = "Wivenhoe trail, Colchester CO1 1UD";
            }

            else if(newString.equals("cpark2"))
            {
                textView.setText(R.string.park2);
                text.setText(R.string.park2_info);

                imageView.setBackgroundResource(R.drawable.countrypark1);

                imageView2.setBackgroundResource(R.drawable.countypark2);

                imageView3.setBackgroundResource(R.drawable.countrypark3);

                lat = 51.906760918807834f; longitude = 0.9048864851231958f;
                urlString = "Highwoods Country Park, Colchester, CO4 5JR";
            }

            else if(newString.equals("cart"))
            {
                textView.setText(R.string.art);
                text.setText(R.string.art_info);

                imageView.setBackgroundResource(R.drawable.firstsite1);

                imageView2.setBackgroundResource(R.drawable.firstsite2);

                imageView3.setBackgroundResource(R.drawable.firstsite3);

                lat = 51.88902112429112f; longitude = 0.905360803443947f;
                urlString = "Firstsite, Colchester CO1 1JH";
            }
        }

        if(string2!=null)
        {
            if(string2.equals("shopping"))
            {
                textView.setText(R.string.shopping_title);
                text.setText(R.string.shopping);
                imageView.setBackgroundResource(R.drawable.lions_walk1);

                imageView2.setBackgroundResource(R.drawable.lions_walk2);

                imageView3.setBackgroundResource(R.drawable.lions_walk3);

                lat = 51.888374702837716f; longitude = 0.9005262354591015f;
                urlString = "19 Culver Walk, Lion Walk Shopping Centre, Colchester CO1 1DF";

            }
        }
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", lat, longitude,urlString);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.setPackage("com.google.android.apps.maps");
                if(isConnected()){startActivity(i);}
                else{
                    DialogueActive();
                }
            }
        });
    }

    public void DialogueActive()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomPlace.this);
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
}