package hometask.collection;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Andrey on 10.02.2017.
 */
public class MainHolidayOnTreeSet {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();  //today

        HolidayOnTreeSet h11 = new HolidayOnTreeSet(today, "HolidayOnTreeSet 11");
        HolidayOnTreeSet h12 = new HolidayOnTreeSet(today, "HolidayOnTreeSet 12");
        HolidayOnTreeSet h13 = new HolidayOnTreeSet(today, "HolidayOnTreeSet 13");
        StoreHolidaysOnTreeSet storeHolidaysOnTreeSet = new StoreHolidaysOnTreeSet();
        storeHolidaysOnTreeSet.addHoliday(h11);
        storeHolidaysOnTreeSet.addHoliday(h12);
        storeHolidaysOnTreeSet.addHoliday(h13);






        cal.add(Calendar.DATE, 1); //today + 1
        Date tomorrow = cal.getTime();
        HolidayOnTreeSet h21 = new HolidayOnTreeSet(tomorrow, "HolidayOnTreeSet 21");
        HolidayOnTreeSet h22 = new HolidayOnTreeSet(tomorrow, "HolidayOnTreeSet 22");
        storeHolidaysOnTreeSet.addHoliday(h21);
        storeHolidaysOnTreeSet.addHoliday(h22);


        cal.add(Calendar.DATE, 1); //today + 2
        Date afterTomorrow = cal.getTime();
        HolidayOnTreeSet h31 = new HolidayOnTreeSet((Date) afterTomorrow, "HolidayOnTreeSet 31");
        HolidayOnTreeSet h32 = new HolidayOnTreeSet(afterTomorrow, "HolidayOnTreeSet 32");
        storeHolidaysOnTreeSet.addHoliday(h31);
        storeHolidaysOnTreeSet.addHoliday(h32);

        cal.add(Calendar.DATE, 1); //today + 3
        Date throughTwoDays = cal.getTime();
        HolidayOnTreeSet h41 = new HolidayOnTreeSet(throughTwoDays, "HolidayOnTreeSet 41");
        HolidayOnTreeSet h42 = new HolidayOnTreeSet(throughTwoDays, "HolidayOnTreeSet 42");
        storeHolidaysOnTreeSet.addHoliday(h41);
        storeHolidaysOnTreeSet.addHoliday(h42);

        cal.add(Calendar.DATE, 1); //today + 4

        Date throughThreeDays = cal.getTime();
        HolidayOnTreeSet h51 = new HolidayOnTreeSet(throughThreeDays, "HolidayOnTreeSet 51");
        HolidayOnTreeSet h52 = new HolidayOnTreeSet(throughThreeDays, "HolidayOnTreeSet 52");
        storeHolidaysOnTreeSet.addHoliday(h51);
        storeHolidaysOnTreeSet.addHoliday(h52);

        cal.add(Calendar.DATE, 3); //today + 7

        Date throughWeek = cal.getTime();
        HolidayOnTreeSet h81 = new HolidayOnTreeSet(throughWeek, "HolidayOnTreeSet 81");
        HolidayOnTreeSet h82 = new HolidayOnTreeSet(throughWeek, "HolidayOnTreeSet 82");
        storeHolidaysOnTreeSet.addHoliday(h81);
        storeHolidaysOnTreeSet.addHoliday(h82);

        storeHolidaysOnTreeSet.printToday();
        storeHolidaysOnTreeSet.printTomorrow();
        storeHolidaysOnTreeSet.printComingSoon5Days();
    }
}
