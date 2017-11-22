package com.example.wth.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static com.example.wth.application.CalendarUtil.getDayOfWeek;



public class CalendarFactory {

    private static HashMap<String, List<CalendarObject>> cache = new HashMap<>();

    public static List<CalendarObject> getMonthOfDayList(int y, int m) {

        String key=y+""+m;
        if(cache.containsKey(key)){
            List<CalendarObject> list=cache.get(key);
            if(list==null){
                cache.remove(key);
            }else{
                return list;
            }
        }

        List<CalendarObject> list = new ArrayList<CalendarObject>();
        cache.put(key,list);

        int fweek = getDayOfWeek(y, m, 1);
        int total = CalendarUtil.getDayOfMaonth(y, m);

        for (int i = fweek - 1; i > 0; i--) {
            CalendarObject bean = geCalendarBean(y, m, 1 - i);
            bean.monthFlag = -1;
            bean.eventFlag = -1;
            list.add(bean);
        }

        for (int i = 0; i < 15; i++) {
            CalendarObject bean = geCalendarBean(y, m, i + 1);
            bean.eventFlag = -1;
            list.add(bean);
        }
        for (int i = 15; i < 17; i++) {
            CalendarObject bean = geCalendarBean(y, m, i + 1);
            list.add(bean);
        }
        for (int i = 17; i < total; i++) {
            CalendarObject bean = geCalendarBean(y, m, i + 1);
            bean.eventFlag = -1;
            list.add(bean);
        }

        for (int i = 0; i < 42 - (fweek - 1) - total; i++) {
            CalendarObject bean = geCalendarBean(y, m, total + i + 1);
            bean.monthFlag = 1;
            bean.eventFlag = -1;
            list.add(bean);
        }
        return list;
    }


    public static CalendarObject geCalendarBean(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DATE);

        CalendarObject bean = new CalendarObject(year, month, day);
        bean.week = getDayOfWeek(year, month, day);


        return bean;
    }

    public static void main(String[] args) {

    }


}
