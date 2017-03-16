package hometaskThreads.demo;

import hometaskThreads.SharedList;
import hometaskThreads.threads.ThreadFillListWithUsingSleep;
import hometaskThreads.threads.ThreadFillListWithUsingWaitNotify;

/**
 * Created by Andrey on 25.02.2017.
 */
public class DemoFillListWithUsingWaitNotify {

    public static char firstLetter = 'A';
    public static String last2Letters = "ZZ";
    public static boolean mainAdd1Letter = false;

    public static void main(String[] args) {

        SharedList sharedList = new SharedList();

        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify1 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 1");
//        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify2 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 2");
//        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify3 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 3");
//        ThreadFillListWithUsingWaitNotify threadFillListWithUsingWaitNotify4 = new ThreadFillListWithUsingWaitNotify(sharedList, "Thread 4");


        threadFillListWithUsingWaitNotify1.start();
//        threadFillListWithUsingWaitNotify2.start();


        synchronized (sharedList) {
//            for (char s = firstLetter; s <= 'Z'; s++) {
            while (firstLetter != 'Z') {
//                System.out.println(Thread.currentThread().getName() + " in FOR state: " + Thread.currentThread().getState());
//                System.out.println(threadFillListWithUsingWaitNotify1.getName() + " in FOR state: " + threadFillListWithUsingWaitNotify1.getState());
                while (!mainAdd1Letter) {
//                    sharedList.addToList(Character.toString(s));
                    sharedList.addToList(Character.toString(firstLetter));
//                    System.out.println("Main thread add: " + s);
                    System.out.println("Main thread add: " + firstLetter);
                    firstLetter++;
                    int sizeList = sharedList.getStringArrayList().size();
//            String lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);

//            while (!(lastCharacterInList.length() == 2 & lastCharacterInList.endsWith("Z"))) {

                    mainAdd1Letter = true;
                    System.out.println(Thread.currentThread().getName() + " tries to NOTIFY in Main " + Thread.currentThread().getState());
                    sharedList.notify();
                    try {
                        System.out.println(Thread.currentThread().getName() + " tries to WAIT in Main " + Thread.currentThread().getState());
                        sharedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " after NOTIFY: " + Thread.currentThread().getState());
                    System.out.println(threadFillListWithUsingWaitNotify1.getName() + " After Notify: " + threadFillListWithUsingWaitNotify1.getState());


//                sizeList = sharedList.getStringArrayList().size();
//                lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);
                }
            }
        }
        System.out.println("We finish");

        threadFillListWithUsingWaitNotify1.interrupt();
//        threadFillListWithUsingWaitNotify2.interrupt();

        System.out.println(sharedList.toString());
    }
}
