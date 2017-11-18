package com.example.wth.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wth.application.dummy.DummyContent;

public class EventChangesActivity extends AppCompatActivity
        implements EventChangesListFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_changes);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        //Go to event change
    }
}
