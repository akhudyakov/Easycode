package HomeTaskInstituteOnList;

import com.sun.javafx.tk.Toolkit;

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
        if(!storeHomeTasks.contains(ht)) {
            storeHomeTasks.add(ht);
            ht.setHomeTaskStore(this);
            System.out.println(ht.toString() + " has been added to the Store");
        } else System.out.println("Specific \"" + ht.toString() + "\" already exists in the Store and it cannot be added");
    }

    public String toString() {
        return storeHomeTasks.toString();
    }

    public void printAllHomeTasks () {

        Iterator<HomeTask> homeTaskIterator = storeHomeTasks.iterator();

        System.out.println("[");
        while (homeTaskIterator.hasNext()) {
            System.out.println(homeTaskIterator.next().toString());
        }
        System.out.println("}");
    }

    protected void removeTaskFromTaskStore (HomeTask ht) {storeHomeTasks.remove(ht);}

}
