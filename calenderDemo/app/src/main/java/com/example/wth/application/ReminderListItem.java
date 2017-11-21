package com.example.wth.application;

/**
 * Created by wth on 2017/11/9.
 */

public class ReminderListItem {
    private String time;
    private int isCheck;

    public ReminderListItem(String time, int isCheck) {
        this.time = time;
        this.isCheck = isCheck;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

}
