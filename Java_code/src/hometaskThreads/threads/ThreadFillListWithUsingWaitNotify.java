package hometaskThreads.threads;

import hometaskThreads.SharedList;
import hometaskThreads.demo.DemoFillListWithUsingWaitNotify;

/**
 * Created by Andrey on 17.03.2017.
 */
public class ThreadFillListWithUsingWaitNotify extends Thread {

    private SharedList sharedList;
    private String last2Symbols = "";
    private static char firstLetter = (char) (DemoFillListWithUsingWaitNotify.firstLetter - 1);
    private String nameOfThread;
    private volatile String stringToAdd;

    public ThreadFillListWithUsingWaitNotify(SharedList list, String nameOfThread) {
        super(nameOfThread);
        this.sharedList = list;
        this.nameOfThread = nameOfThread;
    }

    public void run() {
        synchronized (sharedList) {

            while (!last2Symbols.equals(DemoFillListWithUsingWaitNotify.last2Letters)) {

                if (DemoFillListWithUsingWaitNotify.mainThreadAdd1Letter) {
                    int sizeList = sharedList.getStringArrayList().size();
                    String lastStringInList = sharedList.getStringArrayList().get(sizeList - 1);
                    last2Symbols = lastStringInList.length() == 1 ? lastStringInList + DemoFillListWithUsingWaitNotify.lastLetter : lastStringInList;
                    char temp = firstLetter;
                    stringToAdd = lastStringInList;

                    while (!(stringToAdd.equals(last2Symbols))) {
                        temp++;
                        stringToAdd = lastStringInList + Character.toString(temp);
                        sharedList.addToList(stringToAdd);
                        System.out.println(Thread.currentThread().getName() + " has just add: " + stringToAdd);
                    }

                    if (!stringToAdd.equals(DemoFillListWithUsingWaitNotify.last2Letters)) {
                        DemoFillListWithUsingWaitNotify.mainThreadAdd1Letter = false;
                        sharedList.notifyAll();
                        try {
                            sharedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        DemoFillListWithUsingWaitNotify.finish = true;
                    }
                } else {
                    sharedList.notifyAll();
                    try {
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            sharedList.notifyAll();
        }
    }
}