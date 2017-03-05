package hometask.collection;

import java.util.Calendar;

/**
 * Created by adminnt on 06.02.17.
 */
public class HolidayOnTreeMap implements Comparable<HolidayOnTreeMap> {
    private Calendar date;
    private String name;

    public HolidayOnTreeMap(Calendar holidayDate, String holidayName) {
        this.date = holidayDate;
        this.name = holidayName;
    }

    @Override
    public String toString() {
        return "HolidayOnTreeMap{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }


    @Override
    public int compareTo(HolidayOnTreeMap h) {
        int compare = this.getDate().compareTo(h.getDate())&this.getName().compareTo(h.getName());
        return compare;
    }

    public String getName() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }


}


