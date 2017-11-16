package com.example.wth.application;



public interface CalendarTopView {

    int[] getCurrentSelectPositon();

    int getItemHeight();

    void setCaledarTopViewChangeListener(CaledarTopViewChangeListener listener);

}
