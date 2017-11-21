package com.example.wth.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wth.application.R;

/**
 * Created by JossTheBoss on 21/11/2017.
 */

public class Mes_groupes2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_groupes2);

    }
    public void retour(View view){
        Intent i =new Intent (this,CalendarActivity.class);
        startActivity(i);
    }

}
