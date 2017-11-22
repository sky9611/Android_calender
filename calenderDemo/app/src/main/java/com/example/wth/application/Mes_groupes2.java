package com.example.wth.application;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by JossTheBoss on 21/11/2017.
 */

public class Mes_groupes2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_mes_groupes2);

        final Button visible = findViewById(R.id.group3);
        final Button newgroup = findViewById(R.id.newgroup);
        final ImageButton refusegroup = findViewById(R.id.refusegroup);
        final ImageButton addgroup = findViewById(R.id.addgroup);
        final TextView invitation = findViewById(R.id.textboard_invitation2);

        Button activite1 = (Button)findViewById(R.id.group1);
        activite1.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes2.this , Groupe1.class);
                startActivity(i);
            }
        });

        Button activite2 = (Button)findViewById(R.id.group2);
        activite1.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes2.this , Groupe1.class);
                startActivity(i);
            }
        });

        Button addActivity = (Button)findViewById(R.id.addActivity);
        addActivity.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mes_groupes2.this , CreationGroupActivity.class);
                startActivity(i);
            }
        });


        addgroup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                visible.setVisibility(0);
                addgroup.setVisibility(View.GONE);
                newgroup.setVisibility(View.GONE);
                refusegroup.setVisibility(View.GONE);
                invitation.setVisibility(View.GONE);
            }
        });

        refusegroup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                addgroup.setVisibility(View.GONE);
                newgroup.setVisibility(View.GONE);
                refusegroup.setVisibility(View.GONE);
                invitation.setVisibility(View.GONE);
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
        Intent i = new Intent(Mes_groupes2.this , CalendarActivity.class);
        startActivity(i);
        return super.onSupportNavigateUp();
    }

}
