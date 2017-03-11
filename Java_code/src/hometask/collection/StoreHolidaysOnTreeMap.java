package hometask.collection;

import lesson10.Author;

import java.text.ParseException;
import java.util.*;


/**
 * Created by adminnt on 06.02.17.
 */
public class StoreHolidaysOnTreeMap {

    private TreeMap<Date, String> holidaysOnMap = new TreeMap<>();

    @Author(authorName = "Ivanov", dateOfModification = "2017/01/25")
    public void addHoliday(Calendar calendar, String holidayName) {
        Date date = getNotExistingDateInStore(calendar);
        holidaysOnMap.put(date, holidayName);
    }

    public Date getNotExistingDateInStore(Calendar calendar) {
        Date inputDate = calendar.getTime();

        while (holidaysOnMap.containsKey(inputDate)) {
            calendar.add(Calendar.SECOND, 1);
            inputDate = calendar.getTime();
        }
        return inputDate;
    }

    public void printToday() {

        Calendar cal = Calendar.getInstance();
        DateUtils.trim(cal);
        Date trimToday = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();

        SortedMap<Date, String> todaySortedMap = holidaysOnMap.subMap(trimToday, tomorrow);

        System.out.println("Today: ");
        for (String holiday : todaySortedMap.values()) {
            System.out.println(holiday);
        }
    }


    public void printTomorrow() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        DateUtils.trim(cal);
        Date trimTomorrow = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date afterTomorrow = cal.getTime();

        SortedMap<Date, String> todaySortedMap = holidaysOnMap.subMap(trimTomorrow, afterTomorrow);

        System.out.println("\nTomorrow: ");
        for (String holiday : todaySortedMap.values()) {
            System.out.println(holiday);
        }

    }

    public void printComingSoon5Days() throws ParseException {


        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 2);
        DateUtils.trim(cal);
        Date twoDaysLater = cal.getTime();

        cal.add(Calendar.DATE, 3);
        Date fiveDaysLater = cal.getTime();

        SortedMap<Date, String> todaySortedMap = holidaysOnMap.subMap(twoDaysLater, fiveDaysLater);

        boolean printedFirstNodeForTheDate = false;


        Date previousHoliday = todaySortedMap.firstKey();

        System.out.println("\nComing soon: ");

        for (Map.Entry e : todaySortedMap.entrySet()) {
            Date currentHoliday = (Date) e.getKey();


            if (DateUtils.trim(previousHoliday).before(DateUtils.trim(currentHoliday))) {
                printedFirstNodeForTheDate = false;
            }
            // for each date print date only first time
            if (!printedFirstNodeForTheDate) {

                System.out.printf("%1$ta" + "," + "%1$te %1$tB", currentHoliday);
                System.out.print(" - " + e.getValue() + "\n");
                printedFirstNodeForTheDate = true;
            } else {
                System.out.print("              " + e.getValue() + "\n");
            }
            previousHoliday = currentHoliday;
        }
    }

    @Override
    public String toString() {
        return holidaysOnMap.toString();
    }

    @Author(authorName = "Petrov", dateOfModification = "2017/01/24")
    public TreeMap<Date, String> getHolidaysOnMap() {
        return holidaysOnMap;
    }
}


