package hometask.collection;

import java.util.Calendar;

/**
 * Created by adminnt on 06.02.17.
 */
public class HolidayOnTreeMap implements Comparable<HolidayOnTreeMap> {
    private Calendar date;
    private String name;

    public String getName() {
        return name;
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public int compareTo(HolidayOnTreeMap h) {
            int s = this.getDate().compareTo(h.getDate());
            return s;
        }

    HolidayOnTreeMap(Calendar c, String s) {
        this.date = c;
        this.name = s;

    }

    @Override
    public String toString() {
        return "HolidayOnTreeMap{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}


