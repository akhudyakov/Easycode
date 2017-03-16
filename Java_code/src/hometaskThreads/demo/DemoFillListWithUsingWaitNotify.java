package hometaskThreads.demo;

import hometaskThreads.SharedList;
import hometaskThreads.threads.ThreadFillListWithUsingWaitNotify;

/**
 * Created by Andrey on 25.02.2017.
 */
public class DemoFillListWithUsingWaitNotify {

    public static char firstLetter = 'A';
    public static String last2Letters = "ZZ";
    public static boolean mainThreadAdd1Letter = false;
    public static volatile boolean finish = false;

    public static void main(String[] args) {

        SharedList sharedList = new SharedList();

        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify1 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 1");
        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify2 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 2");
        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify3 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 3");
//        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify4 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 4");


        threadFillListWithUsingWaitNotify1.start();
        threadFillListWithUsingWaitNotify2.start();
        threadFillListWithUsingWaitNotify3.start();


        synchronized (sharedList) {
            while (firstLetter != 'Z' & !finish) {
//                System.out.println(Thread.currentThread().getName() + " in FOR state: " + Thread.currentThread().getState());
//                System.out.println(threadFillListWithUsingWaitNotify1.getName() + " in FOR state: " + threadFillListWithUsingWaitNotify1.getState());
                while (!mainThreadAdd1Letter) {
                    sharedList.addToList(Character.toString(firstLetter));
                    System.out.println("Main thread add: " + firstLetter);
                    firstLetter++;
                    mainThreadAdd1Letter = true;
                    sharedList.notify();
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
        threadFillListWithUsingWaitNotify3.interrupt();

        System.out.println(sharedList.toString());
    }
}
