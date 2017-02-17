package hometask.collection;


import lesson10.Author;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * Created by adminnt on 06.02.17.
 */
public class StoreHolidaysOnTreeSet {

    private TreeSet<HolidayOnTreeSet> holidayTreeSet = new TreeSet<>();


    @Author(authorName = "Ivanov", dateOfModification = "2017/01/25")
    public void addHoliday(HolidayOnTreeSet h) {
        holidayTreeSet.add(h);
    }

    @Override
    public String toString() {
        return holidayTreeSet.toString();
    }

    @Author(authorName = "Petrov", dateOfModification = "2017/01/24")
    public TreeSet<HolidayOnTreeSet> getHolidayTreeSet() {
        return holidayTreeSet;
    }



    public void printToday() {

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        String todayString = WorkWithDate.getOnlyStringDateFromDate(today);

        boolean existFirstNodeForTheDate = false;


        Iterator<HolidayOnTreeSet> holidayIterator = holidayTreeSet.iterator();
        while (holidayIterator.hasNext()) {
            HolidayOnTreeSet currentHoliday = holidayIterator.next();
            String iterDateString = WorkWithDate.getOnlyStringDateFromDate(currentHoliday.getDate());

            if (iterDateString.equals(todayString)) {
                if (!existFirstNodeForTheDate) {
                    System.out.println("Today: ");
                    existFirstNodeForTheDate = true;
                }
                System.out.println(currentHoliday.getName());
            }

        }
    }

    public void printTomorrow() {

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();
        String tomorrowString = WorkWithDate.getOnlyStringDateFromDate(tomorrow);

        boolean existFirstNodeForTheDate = false;


        Iterator<HolidayOnTreeSet> holidayIterator = holidayTreeSet.iterator();
        while (holidayIterator.hasNext()) {
            HolidayOnTreeSet currentHoliday = holidayIterator.next();
            String iterDateString = WorkWithDate.getOnlyStringDateFromDate(currentHoliday.getDate());

            if (iterDateString.equals(tomorrowString)) {

                if (!existFirstNodeForTheDate) {
                    System.out.println("\nTomorrow: ");
                    existFirstNodeForTheDate = true;
                }
                System.out.println(currentHoliday.getName());
            }
        }
    }

    public void printComingSoon5Days() {


        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();


        cal.add(Calendar.DATE, 4);
        Date fourDaysLater = cal.getTime();


        boolean printedFirstNodeForTheDate = false;


        Iterator<HolidayOnTreeSet> holidayIterator = holidayTreeSet.iterator();
        HolidayOnTreeSet previousHoliday = holidayTreeSet.first();

        System.out.println("\nComing soon: ");

        while (holidayIterator.hasNext()) {
            HolidayOnTreeSet currentHoliday = holidayIterator.next();

            if (previousHoliday.getDate().before(currentHoliday.getDate())) {printedFirstNodeForTheDate = false;}

            if (currentHoliday.getDate().after(tomorrow) & currentHoliday.getDate().before(fourDaysLater)) {

                // for each date print date only first time
                if (!printedFirstNodeForTheDate) {

                    System.out.printf("%1$ta" + "," + "%1$te %1$tB", currentHoliday.getDate());
                    System.out.print(" - " + currentHoliday.getName() + "\n");
                    printedFirstNodeForTheDate = true;
                } else {
                    System.out.print("                " + currentHoliday.getName() + "\n");
                }


                previousHoliday = currentHoliday;

            }

        }
    }

}


