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
//        WorkWithDate.getDate(cal);
        Date today = cal.getTime();  //today

//        HolidayOnTreeMap h11 = new HolidayOnTreeMap(cal, "HolidayOnTreeSet 11");
//        HolidayOnTreeMap h12 = new HolidayOnTreeMap(cal, "HolidayOnTreeSet 12");
//        HolidayOnTreeMap h13 = new HolidayOnTreeMap(cal, "HolidayOnTreeSet 13");
        StoreHolidaysOnTreeMap storeHolidaysOnTreeMap = new StoreHolidaysOnTreeMap();
        storeHolidaysOnTreeMap.addHoliday(today, "Holiday 11");

        cal.add(Calendar.MINUTE, 1);
        today = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(today, "Holiday 12");
        cal.add(Calendar.MINUTE, 1);
        today = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(today, "Holiday 13");


        cal.add(Calendar.DATE, 1); //today + 1
        Date tomorrow = cal.getTime();
//        HolidayOnTreeMap h21 = new HolidayOnTreeMap(cal, "HolidayOnTreeSet 21");
//        HolidayOnTreeMap h22 = new HolidayOnTreeMap(cal, "HolidayOnTreeSet 22");
        storeHolidaysOnTreeMap.addHoliday(tomorrow, "Holiday 21");
        cal.add(Calendar.MINUTE, 1);
        tomorrow = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(tomorrow, "Holiday 22");


        cal.add(Calendar.DATE, 1); //today + 2
        Date afterTomorrow = cal.getTime();
//        HolidayOnTreeMap h31 = new HolidayOnTreeMap(afterTomorrow, "HolidayOnTreeSet 31");
//        HolidayOnTreeMap h32 = new HolidayOnTreeMap(afterTomorrow, "HolidayOnTreeSet 32");
        storeHolidaysOnTreeMap.addHoliday(afterTomorrow, "Holiday 31");
        cal.add(Calendar.MINUTE, 1);
        afterTomorrow = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(afterTomorrow, "Holiday 32");

        cal.add(Calendar.DATE, 1); //today + 3
        Date throughTwoDays = cal.getTime();
//        HolidayOnTreeMap h41 = new HolidayOnTreeMap(throughTwoDays, "HolidayOnTreeSet 41");
//        HolidayOnTreeMap h42 = new HolidayOnTreeMap(throughTwoDays, "HolidayOnTreeSet 42");
        storeHolidaysOnTreeMap.addHoliday(throughTwoDays, "Holiday 41");

        cal.add(Calendar.MINUTE, 1);
        throughTwoDays = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(throughTwoDays, "Holiday 42");

        cal.add(Calendar.DATE, 1); //today + 4

        Date throughThreeDays = cal.getTime();
//        HolidayOnTreeMap h51 = new HolidayOnTreeMap(throughThreeDays, "HolidayOnTreeSet 51");
//        HolidayOnTreeMap h52 = new HolidayOnTreeMap(throughThreeDays, "HolidayOnTreeSet 52");
        storeHolidaysOnTreeMap.addHoliday(throughThreeDays, "Holiday 51");
        cal.add(Calendar.MINUTE, 1);
        throughThreeDays = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(throughThreeDays, "Holiday 52");

        cal.add(Calendar.DATE, 3); //today + 7

        Date throughWeek = cal.getTime();
//        HolidayOnTreeMap h81 = new HolidayOnTreeMap(throughWeek, "HolidayOnTreeSet 81");
//        HolidayOnTreeMap h82 = new HolidayOnTreeMap(throughWeek, "HolidayOnTreeSet 82");
        storeHolidaysOnTreeMap.addHoliday(throughWeek, "Holiday 81");
        cal.add(Calendar.MINUTE, 1);
        throughWeek = cal.getTime();
        storeHolidaysOnTreeMap.addHoliday(throughWeek, "Holiday 82");

        storeHolidaysOnTreeMap.printToday();
        storeHolidaysOnTreeMap.printTomorrow();
        storeHolidaysOnTreeMap.printComingSoon5Days();
    }
}
