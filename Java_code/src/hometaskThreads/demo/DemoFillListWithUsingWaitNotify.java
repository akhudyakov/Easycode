package hometaskThreads.demo;

import hometaskThreads.SharedList;
import hometaskThreads.threads.ThreadFillListWithUsingWaitNotify;

/**
 * Created by Andrey on 17.03.2017.
 */
public class DemoFillListWithUsingWaitNotify {

    public static char firstLetter = 'A';
    public static char lastLetter = 'Z';
    public static String last2Letters = "ZZ";
    public static boolean mainThreadAdd1Letter = false;
    public static volatile boolean finish = false;

    public static void main(String[] args) {

        SharedList sharedList = new SharedList();

        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify1 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 1");
        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify2 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 2");
//        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify3 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 3");

        threadFillListWithUsingWaitNotify1.start();
        threadFillListWithUsingWaitNotify2.start();
//        threadFillListWithUsingWaitNotify3.start();  it does not work with 3 threads

        synchronized (sharedList) {
            while (firstLetter != lastLetter & !finish) {
                while (!mainThreadAdd1Letter) {
                    sharedList.addToList(Character.toString(firstLetter));
                    System.out.println("Main thread add: " + firstLetter);
                    firstLetter++;
                    mainThreadAdd1Letter = true;
                    sharedList.notifyAll();
                    try {
                        System.out.println(Thread.currentThread().getName() + " tries to WAIT in Main " + Thread.currentThread().getState());
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        threadFillListWithUsingWaitNotify1.interrupt();
        threadFillListWithUsingWaitNotify2.interrupt();
//        threadFillListWithUsingWaitNotify3.interrupt();

        System.out.println(sharedList.toString());
    }
}
