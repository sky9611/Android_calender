package com.example.wth.application;

import android.view.View;
import android.view.ViewGroup;


public interface CaledarAdapter {
     View getView(View convertView, ViewGroup parentView, CalendarObject bean);
}
