package com.example.wth.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.wth.test.AddMember;


public class CreationGroupActivity extends AppCompatActivity {
    public EditText nom;
    public EditText desctiption;
    public Button ajouterMembre;
    public Button importerAgenda;
    public CheckBox gererLesAlertes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_group);
        // nom = (EditText) findViewById(R.id.groupe_name_label);
        //desctiption = (EditText) findViewById(R.id.groupe_name_label);
        ImageButton ib = (ImageButton) findViewById(R.id.add_member);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreationGroupActivity.this , AddMember.class);
                startActivity(i);
            }
        });
    }


    //valable pour les boutoon retour et confirmer(attribut : onClick)
    //enlever les comentaire;
    public void confirmer(View view){

        //Intent i=new Intent(this,MesGroupes.class);
       // startActivity(i);
    }

    /*
    //pour les autres boutton
    public void AjouterMembre(View view){
        startActivity(i);
    }
    public void AjouterEvenement(View view){
        startActivity(i);
    }
    public void ImporterAgenda(View view){
        startActivity(i);
    } */
}