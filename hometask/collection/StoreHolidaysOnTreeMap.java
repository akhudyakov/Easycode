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
    public void addHoliday(Date d, String s) {
        holidaysOnMap.put(d, s);
    }

    @Override
    public String toString() {
        return holidaysOnMap.toString();
    }

    @Author(authorName = "Petrov", dateOfModification = "2017/01/24")
    public TreeMap<Date, String> getHolidaysOnMap() {
        return holidaysOnMap;
    }


    public void printToday() {

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        String todayString = WorkWithDate.getOnlyStringDateFromDate(today);

        boolean existFirstNodeForTheDate = false;


        for (Map.Entry e : holidaysOnMap.entrySet()) {
            Date currentHoliday = (Date) e.getKey();

            String iterDateString = WorkWithDate.getOnlyStringDateFromDate(currentHoliday);

            if (iterDateString.equals(todayString)) {
                if (!existFirstNodeForTheDate) {
                    System.out.println("Today: ");
                    existFirstNodeForTheDate = true;
                }
                System.out.println(e.getValue());
            }

        }
    }


    public void printTomorrow() {

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();
        String tomorrowString = WorkWithDate.getOnlyStringDateFromDate(tomorrow);

        boolean existFirstNodeForTheDate = false;


        for (Map.Entry e : holidaysOnMap.entrySet()) {
            Date currentHoliday = (Date) e.getKey();

            String iterDateString = WorkWithDate.getOnlyStringDateFromDate(currentHoliday);

            if (iterDateString.equals(tomorrowString)) {

                if (!existFirstNodeForTheDate) {
                    System.out.println("\nTomorrow: ");
                    existFirstNodeForTheDate = true;
                }
                System.out.println(e.getValue());
            }
        }
    }

    public void printComingSoon5Days() throws ParseException {


        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 1);
        Date tomorrow = cal.getTime();
//        String twoDaysLaterString = WorkWithDate.getOnlyStringDateFromDate(twoDaysLater);

        cal.add(Calendar.DATE, 4);
        Date fourDaysLater = cal.getTime();


        boolean printedFirstNodeForTheDate = false;


        Date previousHoliday = holidaysOnMap.firstKey();

        System.out.println("\nComing soon: ");

        for (Map.Entry e : holidaysOnMap.entrySet()) {
            Date currentHoliday = (Date) e.getKey();
//            String iterDateString = WorkWithDate.getOnlyStringDateFromDate(currentHoliday);


            if (WorkWithDate.getOnlyDate(previousHoliday).before(WorkWithDate.getOnlyDate(currentHoliday))) {
                printedFirstNodeForTheDate = false;
            }

            if (WorkWithDate.getOnlyDate(currentHoliday).after(WorkWithDate.getOnlyDate(tomorrow)) & WorkWithDate.getOnlyDate(currentHoliday).before(WorkWithDate.getOnlyDate(fourDaysLater))) {

                // for each date print date only first time
                if (!printedFirstNodeForTheDate) {

                    System.out.printf("%1$ta" + "," + "%1$te %1$tB", currentHoliday);
                    System.out.print(" - " + e.getValue() + "\n");
                    printedFirstNodeForTheDate = true;
                } else {
                    System.out.print("                " + e.getValue() + "\n");
                }


                previousHoliday = currentHoliday;

            }

        }
    }

}


