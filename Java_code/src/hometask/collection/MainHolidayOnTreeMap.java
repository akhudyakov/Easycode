package hometask.collection;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Andrey on 10.02.2017.
 */
public class MainHolidayOnTreeMap {

    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();

        StoreHolidaysOnTreeMap storeHolidaysOnTreeMap = new StoreHolidaysOnTreeMap();

        //today
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 11");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 12");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 13");

        cal.add(Calendar.DATE, 1); //today + 1
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 21");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 22");


        cal.add(Calendar.DATE, 1); //today + 2
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 31");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 32");

        cal.add(Calendar.DATE, 1); //today + 3
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 41");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 42");

        cal.add(Calendar.DATE, 1); //today + 4
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 51");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 52");

        cal.add(Calendar.DATE, 3); //today + 7

        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 81");
        storeHolidaysOnTreeMap.addHoliday(cal, "Holiday 82");

        storeHolidaysOnTreeMap.printToday();
        storeHolidaysOnTreeMap.printTomorrow();
        storeHolidaysOnTreeMap.printComingSoon5Days();
    }
}
