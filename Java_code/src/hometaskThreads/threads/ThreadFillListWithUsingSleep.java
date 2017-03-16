package hometaskThreads.threads;

import hometaskThreads.SharedList;
import hometaskThreads.demo.DemoFillListWithUsingSleep;

/**
 * Created by Student on 25.02.2017.
 */
public class ThreadFillListWithUsingSleep extends Thread {

    private SharedList sharedList;
    private String last2Symbols = "";
    private static char firstLetter = (char) (DemoFillListWithUsingSleep.firstLetter - 1);
    private String nameOfThread;
    private volatile String stringToAdd;

    public ThreadFillListWithUsingSleep(SharedList list, String nameOfThread) {
        super(nameOfThread);
        this.sharedList = list;
        this.nameOfThread = nameOfThread;
    }

    public void run() {

        while (!last2Symbols.equals(DemoFillListWithUsingSleep.last2Letters)) {
            int sizeList = sharedList.getStringArrayList().size();

            if (sizeList > 0) {
                String lastStringInList = sharedList.getStringArrayList().get(sizeList - 1);
                last2Symbols = lastStringInList.length() == 1 ? lastStringInList + DemoFillListWithUsingSleep.lastLetter : lastStringInList;
                char temp = firstLetter;
                stringToAdd = lastStringInList;

                while (!(stringToAdd.equals(last2Symbols))) {
                    temp++;
                    stringToAdd = lastStringInList + Character.toString(temp);
                    sharedList.addToList(stringToAdd);
                    System.out.println(Thread.currentThread().getName() + " has just add: " + stringToAdd);
                }

                if (!stringToAdd.equals(DemoFillListWithUsingSleep.last2Letters)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                Thread.yield();
            }
        }
    }
}