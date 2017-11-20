package com.example.wth.application.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<EventChange> ITEMS = new ArrayList<EventChange>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, EventChange> ITEM_MAP = new HashMap<String, EventChange>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(EventChange item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static EventChange createDummyItem(int position) {
        switch (position){
            case 1:
                return new EventChange(String.valueOf(position), "Projet Prolog" ,"23/10/2017" ,"24/10/2017" ,"14h00/14h/30", "16h00/18h00" );
            case 2:
                return new EventChange(String.valueOf(position), "C++ ","18/10/2017" ,"10h00/12h00",false);
            case 3:
                return new EventChange(String.valueOf(position), "Noël Canadien " ,"20/12/2017","20/12/2017" ,"17h30/18h30" ,"18h00/19h00" );
            case 4:
                return new EventChange(String.valueOf(position), "Présentation Double Diplôme " ,"27/10/2017" ,"12h00/13h00" ,true );
            default:
                return new EventChange(String.valueOf(position), "Aquaponey " , "21/11/2017","12h00/14h00" ,true );
        }
    }
    /**
     * A dummy item representing a piece of content.
     */
    public static class EventChange {
        public final String id;
        public final String name;
        public final String content;
        public final String previousDate;
        public final String newDate;
        public final String previousTime;
        public final String newTime;

        public EventChange(String id,String name, String date, String time, boolean newEvent){
            this.id = id;
            this.name = name;
            if(newEvent){
                this.previousDate ="";
                this.newDate = date;
                this.previousTime = "";
                this.newTime = time;
            }else {
                this.previousDate = date;
                this.newDate = "";
                this.previousTime = time;
                this.newTime = "";
            }
            if(newDate.equals("")){
                this.content= name+" "+this.previousDate+" "+previousTime+"\n-> Supprimé";
            }else if(previousDate.equals("")){
                this.content = "Nouvel Evenement -> "+name+"\n"+newDate+" "+newTime;
            }else {
                this.content = name + " " + this.previousDate + " " + previousTime + "\n-> " + this.newDate + " " + this.newTime;
            }
        }

        public EventChange(String id, String name, String previousDate, String newDate, String previousTime, String newTime) {
            this.id = id;
            this.name = name;
            this.previousDate =previousDate;
            this.newDate =newDate;
            this.previousTime =previousTime;
            this.newTime=newTime;
            if(newDate.equals("")){
                this.content= name+" "+this.previousDate+" "+previousTime+"\nSupprimé";
            }else if(previousDate.equals("")){
                this.content = "Nouvel Evenement -> "+name+"\n"+newDate+" "+newTime;
            }else {
                this.content = name + " " + this.previousDate + " " + previousTime + "\n-> " + this.newDate + " " + this.newTime;
            }
        }

        @Override
        public String toString() {
            if(newDate.equals("")){
                return content+" "+this.previousDate+" "+previousTime+"\nSupprimé";
            }
            if(previousDate.equals("")){
                return "Nouvel Evenement -> "+content+"\n"+newDate+" "+newTime;
            }
            return content+" "+this.previousDate+" "+previousTime+"\n-> "+this.newDate+" "+this.newTime;
        }
    }
}
