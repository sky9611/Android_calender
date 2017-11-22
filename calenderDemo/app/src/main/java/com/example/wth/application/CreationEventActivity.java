package com.example.wth.application;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class CreationEventActivity extends AppCompatActivity implements ReminderAdapter.MainRecycleViewClickListener{
    TextView from_date = null;
    TextView from_time = null;
    private String reminderType;
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
    private Button saveButton;
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
    private ReminderAdapter adapter;
    private List<ReminderListItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_creation_event);
        ButterKnife.bind(this);
        initView();

        saveButton = (Button)findViewById(R.id.button_save_event);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
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
        //builder.setView(new EditText(this));
//        LayoutInflater inflater = getLayoutInflater();
//        View dialog = inflater.inflate(R.layout.dialog_add_reminder,(ViewGroup) findViewById(R.id.dialog));
//        builder.setView(dialog);
//        String names[] ={"minutes before","hours before","days before","weeks before"};
//        ListView lv = (ListView) dialog.findViewById(R.id.reminder_type_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
//        lv.setAdapter(adapter);
        //builder.setView()new SingleChoiceItems(new String[]{"minutes before","hours before","days before"},0,null);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_reminder,null);
        //View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_reminder, null);
        builder.setView(dialogView);
        Dialog dialog = builder.create();
        final TextView tv = dialogView.findViewById(R.id.reminder_time);
        RecyclerView rv = (RecyclerView) dialogView.findViewById(R.id.reminder_type_list);
        initListData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(dialog.getContext());

        adapter = new ReminderAdapter(this);
        adapter.setList(list);
        adapter.setOnMainRecycleOnClickListener(this);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

        builder.setNegativeButton("cancel", null);
        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addReminderButton.setText(tv.getText()+" "+reminderType);
            }
        });
        builder.show();
    }

    @Override
    public void onItemClick(int pos){
        for(int i=0;i<list.size();i++){

            if(i==pos && pos!=6){
                if(list.get(pos).getIsCheck()==1){
                    list.get(pos).setIsCheck(0);
                }
                else {
                    list.get(pos).setIsCheck(1);
                    reminderType = list.get(pos).getTime();
                }
            } else{
                list.get(i).setIsCheck(0);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void initListData() {
        list.clear();
        list.add(new ReminderListItem("minutes before", 0));
        list.add(new ReminderListItem("hours before",0));
        list.add(new ReminderListItem("days before", 0));
        list.add(new ReminderListItem("weeks before", 0));
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

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
