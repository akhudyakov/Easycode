package hometask.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Andrey on 14.02.2017.
 *
 *    IT IS NOT HOME TASK
 *
 */
public class InvestigateIteratorHashSet {
    public static void main(String[] args) {
        HashSet<HolidayOnTreeSet> holidayOnTreeSets = new HashSet<>();

        HolidayOnTreeSet h11 = new HolidayOnTreeSet(new java.util.Date(), "HolidayOnTreeSet 11");
        HolidayOnTreeSet h12 = new HolidayOnTreeSet(new java.util.Date(), "HolidayOnTreeSet 12");
        HolidayOnTreeSet h13 = new HolidayOnTreeSet(new java.util.Date(), "HolidayOnTreeSet 13");

        holidayOnTreeSets.add(h11);
        holidayOnTreeSets.add(h12);
        holidayOnTreeSets.add(h13);

        Iterator<HolidayOnTreeSet> holidayOnTreeSetIterator = holidayOnTreeSets.iterator();

        System.out.println(holidayOnTreeSetIterator.next());
        System.out.println(holidayOnTreeSetIterator.next());

        holidayOnTreeSets.remove(h12);
        System.out.println(holidayOnTreeSetIterator.next()); // ConcurrentModificationException after removing an item in HashSet
    }
}
