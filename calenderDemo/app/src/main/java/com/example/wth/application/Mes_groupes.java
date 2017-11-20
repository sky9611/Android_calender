package com.example.wth.application;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
//import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

public class Mes_groupes extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_mes_groupes);

        final Button visible = findViewById(R.id.group3);
        final Button newgroup = findViewById(R.id.newgroup);
        final ImageButton refusegroup = findViewById(R.id.refusegroup);
        final ImageButton addgroup = findViewById(R.id.addgroup);

        Button activite1 = (Button)findViewById(R.id.group1);
        activite1.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes.this , Groupe1.class);
                startActivity(i);
            }
        });

        Button activite2 = (Button)findViewById(R.id.group2);
        activite1.setOnClickListener(new OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes.this , Groupe1.class);
                startActivity(i);
            }
        });

        Button addActivity = (Button)findViewById(R.id.addActivity);
        addActivity.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes.this , CreationGroupActivity.class);
                startActivity(i);
            }
        });


        addgroup.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                visible.setVisibility(0);
                addgroup.setVisibility(View.GONE);
                newgroup.setVisibility(View.GONE);
                refusegroup.setVisibility(View.GONE);

            }
        });

        refusegroup.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                addgroup.setVisibility(View.GONE);
                newgroup.setVisibility(View.GONE);
                refusegroup.setVisibility(View.GONE);

            }
        });


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
