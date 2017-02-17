package HomeTaskInstituteOnList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Andrey on 15.02.2017.
 */
public class HomeTaskStore {

    private ArrayList<HomeTask> storeHomeTasks = new ArrayList<>();

    public ArrayList<HomeTask> getStoreHomeTasks() {
        return storeHomeTasks;
    }

    public void addHomeTask(HomeTask ht) {
        storeHomeTasks.add(ht);
    }

    public String toString() {
        return storeHomeTasks.toString();
    }

    public void printAllHomeTasks () {

        Iterator<HomeTask> homeTaskIterator = storeHomeTasks.iterator();

        while (homeTaskIterator.hasNext()) {
            System.out.println(homeTaskIterator.next().toString());
        }
    }

}
