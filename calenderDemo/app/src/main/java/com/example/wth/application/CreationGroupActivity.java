package com.example.wth.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


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