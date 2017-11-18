package com.example.wth.application;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


/**
 * Created by lucasono on 10/11/17.
 */

public class EventChangesDialog extends FragmentActivity{
    DialogFragment df;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_event_changes_dialog);
        df = new EventChangesDialogFragment();
        df.show(this.getFragmentManager(),"events");
    }
    public void OnPositiveButton(){
        Intent i = new Intent(EventChangesDialog.this , EventChangesActivity.class);
        startActivity(i);
    }
}
