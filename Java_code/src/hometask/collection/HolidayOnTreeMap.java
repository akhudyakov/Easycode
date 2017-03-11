package hometask.collection;

import java.util.Calendar;

/**
 * Created by adminnt on 06.02.17.
 */
public class HolidayOnTreeMap implements Comparable<HolidayOnTreeMap> {
    private Calendar date;
    private String name;

    public HolidayOnTreeMap(Calendar calendar, String holidayName) {
        this.date = calendar;
        this.name = holidayName;
    }

    @Override
    public int compareTo(HolidayOnTreeMap h) {
        return getDate().compareTo(h.getDate());
    }

    @Override
    public String toString() {
        return "HolidayOnTreeMap{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }
}


