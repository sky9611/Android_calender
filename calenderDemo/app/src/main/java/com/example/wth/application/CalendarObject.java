package com.example.wth.application;


public class CalendarObject {

    public int year;
    public int month;
    public int day;
    public int week;

    public int monthFlag;
    public int eventFlag;


    public CalendarObject(int year, int moth, int day) {
        this.year = year;
        this.month = moth;
        this.day = day;
    }

    public String getDisplayWeek(){
        String s="";
         switch(week){
             case 1:
                 s="dimanche";
          break;
             case 2:
                 s="lundi";
          break;
             case 3:
                 s="mardi";
                 break;
             case 4:
                 s="mercredi";
                 break;
             case 5:
                 s="jeudi";
                 break;
             case 6:
                 s="vendredi";
                 break;
             case 7:
                 s="samedi";
                 break;

         }
        return s ;
    }

    @Override
    public String toString() {
        String s=year+"/"+month+"/"+day;
        return s;
    }
}