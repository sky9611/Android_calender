package com.example.wth.application;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by lucasono on 10/11/17.
 */

public class EventChangesDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //TODO: dynamically generate messages
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("4 evenements ont ete modifies")
                .setTitle("Changement d'evenement")
                .setPositiveButton("Consulter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Open notification list
                        EventChangesDialog ecd = (EventChangesDialog) getActivity();
                        ecd.OnPositiveButton();

                    }
                });
        return builder.create();
    }
}