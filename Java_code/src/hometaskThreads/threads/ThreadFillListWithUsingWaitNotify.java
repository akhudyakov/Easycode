package hometaskThreads.threads;

import hometaskThreads.SharedList;
import hometaskThreads.demo.DemoFillListWithUsingSleep;
import hometaskThreads.demo.DemoFillListWithUsingWaitNotify;

/**
 * Created by Student on 25.02.2017.
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

                if (DemoFillListWithUsingWaitNotify.mainAdd1Letter) {
                    int sizeList = sharedList.getStringArrayList().size();
                    String lastStringInList = sharedList.getStringArrayList().get(sizeList - 1);
                    last2Symbols = lastStringInList.length() == 1 ? lastStringInList + "Z" : lastStringInList;
                    char temp = firstLetter;
                    stringToAdd = lastStringInList;

                    while (!(stringToAdd.equals(last2Symbols))) {
                        temp++;
                        stringToAdd = lastStringInList + Character.toString(temp);

                        if (stringToAdd.length() < 3) {
                            sharedList.addToList(stringToAdd);
                            System.out.println(Thread.currentThread().getName() + " has just add: " + stringToAdd);
                        }
                    }

                    if (!stringToAdd.equals(DemoFillListWithUsingSleep.last2Letters)) {
                        DemoFillListWithUsingWaitNotify.mainAdd1Letter = false;
                        System.out.println(Thread.currentThread().getName() + " goes to wait");
                        sharedList.notify();
                        try {

                            sharedList.wait();

                        System.out.println(Thread.currentThread().getName() + " in Main app is State in " + Thread.currentThread().getState());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    sharedList.notify();
                }
            }
        }
    }
}