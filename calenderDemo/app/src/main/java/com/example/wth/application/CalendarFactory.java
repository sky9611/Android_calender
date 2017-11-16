package com.example.wth.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static com.example.wth.application.CalendarUtil.getDayOfWeek;



public class CalendarFactory {

    private static HashMap<String, List<CalendarObject>> cache = new HashMap<>();

    //获取一月中的集合
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

        //计算出一月第一天是星期几
        int fweek = getDayOfWeek(y, m, 1);
        int total = CalendarUtil.getDayOfMaonth(y, m);

        //根据星期推出前面还有几个显示
        for (int i = fweek - 1; i > 0; i--) {
            CalendarObject bean = geCalendarBean(y, m, 1 - i);
            bean.monthFlag = -1;
            list.add(bean);
        }

        //获取当月的天数
        for (int i = 0; i < total; i++) {
            CalendarObject bean = geCalendarBean(y, m, i + 1);
            list.add(bean);
        }

        //为了塞满42个格子，显示多出当月的天数
        for (int i = 0; i < 42 - (fweek - 1) - total; i++) {
            CalendarObject bean = geCalendarBean(y, m, total + i + 1);
            bean.monthFlag = 1;
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
