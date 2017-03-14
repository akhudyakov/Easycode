package hometaskThreads;

import static java.lang.Thread.sleep;

/**
 * Created by Student on 25.02.2017.
 */
public class FillOutList {

//    public static volatile String lastCharacterInList;

    public static void main(String[] args) {

        SharedList sharedList = new SharedList();

        ThreadFillList threadFillList1 = new ThreadFillList(sharedList, "Thread 1");
        ThreadFillList threadFillList2 = new ThreadFillList(sharedList, "Thread 2");
//        ThreadFillList threadFillList3 = new ThreadFillList(sharedList);
//        ThreadFillList threadFillList4 = new ThreadFillList(sharedList);



        threadFillList1.start();
        threadFillList2.start();
//        threadFillList3.start();
//        threadFillList4.start();
        System.out.println(Thread.currentThread().getName() + " Before For thread state: " + threadFillList1.getState());


        for (char s = 'A'; s <= 'Z'; s++) {
            System.out.println( Thread.currentThread().getName() + " in FOR state: " + threadFillList1.getState());
            sharedList.addToList(Character.toString(s));
            System.out.println("Main thread add: " + s);
//            Thread.interrupted();
//            Thread.yield();
            int sizeList = sharedList.getStringArrayList().size();
            String lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);

            while (!(lastCharacterInList.length() == 2 & lastCharacterInList.endsWith("Z"))) {
//                Thread.yield();
                try {
                    System.out.println(Thread.currentThread().getName() + " thread Before sleep " + Thread.currentThread().getState());
                    Thread.currentThread().sleep(1000);
                    System.out.println( Thread.currentThread().getName() + " thread After sleep in  WHILE " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sizeList = sharedList.getStringArrayList().size();
                lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);
//                            Thread.interrupted();
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }


        threadFillList1.interrupt();
//        threadFillList2.interrupt();
//        threadFillList3.interrupt();
//        threadFillList4.interrupt();

        System.out.println(sharedList.toString());
/*
        String g = "\u0041";
        g += "\u0042";
        System.out.println(g);
        System.out.println(g.length());
        System.out.println(g + 1);
*/

    }
}
