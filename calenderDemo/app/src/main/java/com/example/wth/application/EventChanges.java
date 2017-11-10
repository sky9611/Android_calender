package com.example.wth.application;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


/**
 * Created by lucasono on 10/11/17.
 */

public class EventChanges extends FragmentActivity {
    DialogFragment df;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        df = new EventChangesDialogFragment();
        df.show(this.getFragmentManager(),"events");
    }


}
