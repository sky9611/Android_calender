package com.example.wth.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.wth.application.Utils.px;


public class CalendarActivity extends AppCompatActivity {

    @BindView(R.id.calendarDateView)
    CalendarDateView mCalendarDateView;
    @BindView(R.id.list)
    ListView mList;
    @BindView(R.id.title)
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCalendarDateView.setAdapter(new CaledarAdapter() {
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarObject bean) {
                TextView view;
                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_calendar, null);
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(px(48), px(48));
                    convertView.setLayoutParams(params);
                }

                view = (TextView) convertView.findViewById(R.id.text);

                view.setText("" + bean.day);
                if (bean.monthFlag != 0) {
                    view.setTextColor(0xff9299a1);
                } else {
                    view.setTextColor(0xffffffff);
                }

                return convertView;
            }
        });

        mCalendarDateView.setOnItemClickListener(new CalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion, CalendarObject bean) {
                mTitle.setText(bean.day + "/" + getDisPlayNumber(bean.month) + "/" + getDisPlayNumber(bean.year));
            }
        });

        int[] data = CalendarUtil.getYMD(new Date());
        mTitle.setText(data[2] + "/" + data[1] + "/" + data[0]);

        mList.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(CalendarActivity.this).inflate(android.R.layout.simple_list_item_1, null);
                }

                TextView textView = (TextView) convertView;

                textView.setText("event :" +position);

                return convertView;
            }

        });

    }

    private String getDisPlayNumber(int num) {
        return num < 10 ? "0" + num : "" + num;
    }

}
