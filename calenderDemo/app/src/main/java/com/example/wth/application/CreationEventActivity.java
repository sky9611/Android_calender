package com.example.wth.application;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class CreationEventActivity extends AppCompatActivity {
    TextView from_date = null;
    TextView from_time = null;
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final int YEAR = Calendar.getInstance().get(Calendar.YEAR);
    private static final int MONTH_OF_YEAR = Calendar.getInstance().get(Calendar.MONTH);
    private static final int DAY_OF_MONTH = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private static final int HOURE = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private static final int MINUTE = Calendar.getInstance().get(Calendar.MINUTE);
    private Button setFromDateButtom;
    private Button setFromTimeButtom;
    private Button setToDateButtom;
    private Button setToTimeButtom;
    private Button addReminderButton;
    private int fromYear = YEAR;
    private int fromMonth = MONTH_OF_YEAR;
    private int fromDay = DAY_OF_MONTH;
    private int fromHoure = HOURE;
    private int fromMinute = MINUTE;
    private int toYear = YEAR;
    private int toMonth = MONTH_OF_YEAR;
    private int toDay = DAY_OF_MONTH;
    private int toHoure = HOURE;
    private int toMinute = MINUTE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_event);
        initView();
    }

    private void initView() {
        from_date = (TextView) findViewById(R.id.start_date_home_tz);
        from_time = (TextView) findViewById(R.id.start_time_home_tz);
        setFromDateButtom = (Button)findViewById(R.id.start_date);
        setFromDateButtom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getDate(v,FROM);
            }
        });
        setFromTimeButtom = (Button)findViewById(R.id.start_time);
        setFromTimeButtom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getTime(v,FROM);
            }
        });
        setToDateButtom = (Button)findViewById(R.id.end_date);
        setToDateButtom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getDate(v,TO);
            }
        });
        setToTimeButtom = (Button)findViewById(R.id.end_time);
        setToTimeButtom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getTime(v,TO);
            }
        });
        addReminderButton = (Button)findViewById(R.id.reminder_add);
        addReminderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addReminder(v);
            }
        });
        showFromDate();
        showToDate();
        showFromTime();
        showToTime();
    }

    public void addReminder(View v){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("Notice");
        //builder.setMessage("");
        builder.setView(new EditText(this));
        //builder.setView()new SingleChoiceItems(new String[]{"minutes before","hours before","days before"},0,null);
        builder.setNegativeButton("cancel", null);
        builder.setPositiveButton("save", null);
        builder.show();
    }

    public void getDate(View v,int buttonType) {
        if (buttonType == FROM) {
            new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    CreationEventActivity.this.fromYear = year;
                    fromMonth = monthOfYear;
                    fromDay = dayOfMonth;
                    showFromDate();
                }
            }, YEAR, MONTH_OF_YEAR, DAY_OF_MONTH).show();
            //showFromDate();
        } else {
            new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    CreationEventActivity.this.toYear = year;
                    toMonth = monthOfYear;
                    toDay = dayOfMonth;
                    showToDate();
                }
            }, YEAR, MONTH_OF_YEAR, DAY_OF_MONTH).show();
            //showToDate();
        }
    }
    private void showFromDate() {
        setFromDateButtom.setText(fromYear + "." + (fromMonth+1) + "." + fromDay);
    }
    private void showToDate() {
        setToDateButtom.setText(toYear + "." + (toMonth+1) + "." + toDay);
    }

    public void getTime(View v, int buttonType) {
        if (buttonType == FROM) {
            new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    fromHoure = hourOfDay;
                    CreationEventActivity.this.fromMinute = minute;
                    showFromTime();
                }
            }, HOURE, MINUTE, true).show();
            //showFromTime();
        } else {
            new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    toHoure = hourOfDay;
                    CreationEventActivity.this.toMinute = minute;
                    showToTime();
                }
            }, HOURE, MINUTE, true).show();
            //showToTime();
        }
    }
    private void showFromTime() {
        setFromTimeButtom.setText(fromHoure+":"+fromMinute);
    }
    private void showToTime() {
        setToTimeButtom.setText(toHoure+":"+toMinute);
    }
}
