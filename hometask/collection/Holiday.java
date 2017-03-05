package hometask.collection;

import java.util.Date;

/**
 * Created by adminnt on 06.02.17.
 */
public class Holiday implements Comparable<Holiday> {

    private Date date;
    private String name;

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Holiday h) {


        int time = this.getDate().compareTo(h.getDate());


        if (time != 0) {
            return time;
        } else {
            int s = this.getName().compareTo(h.getName());
            return s;
        }
    }

    Holiday(Date d, String s) {
        this.date = d;
        this.name = s;

    }

    @Override
    public String toString() {
        return "Holiday{" +
                "date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}


