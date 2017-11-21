package com.example.wth.application;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.widget.LinearLayout;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

import com.example.wth.test.AddMember;

public class Groupe1 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_groupe1);
        Button quittergroupe = findViewById(R.id.quittergroupe);
        quittergroupe.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_mes_groupes);
                Button groupe1 = findViewById(R.id.group1);
                groupe1.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();

                    }
                }, 10000);
            }});
        /* Button addEvent = findViewById(R.id.button_add_event);
        addEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(Groupe1.this ,CreationEventActivity.class);
                startActivity(i);
            }
        }); */

        Button ajoutermembre = findViewById(R.id.ajoutermembre);
        ajoutermembre.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Groupe1.this , AddMember.class);
                startActivity(i);
            }});

        Button ajouterevent = findViewById(R.id.ajouterevent);
        ajoutermembre.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Groupe1.this , CreationEventActivity.class);
                startActivity(i);
            }});


    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
