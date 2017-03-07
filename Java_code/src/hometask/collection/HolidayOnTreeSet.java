package hometask.collection;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by adminnt on 06.02.17.
 */
public class HolidayOnTreeSet implements Comparable<HolidayOnTreeSet> {
    private Date date;
    private String name;

    HolidayOnTreeSet(Date date, String holidayName) {
        this.date = date;
        this.name = holidayName;
    }

    @Override
    public int compareTo(HolidayOnTreeSet h) {
        int time = getDate().compareTo(h.getDate());

        if (time != 0) {
            return time;
        } else {
            return getName().compareTo(h.getName());
        }
    }

    @Override
    public String toString() {
        return "HolidayOnTreeSet{" +
                "date=" + date +
                ", name='" + name + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

}