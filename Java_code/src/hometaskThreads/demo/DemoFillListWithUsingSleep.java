package hometaskThreads.demo;

import hometaskThreads.SharedList;
import hometaskThreads.threads.ThreadFillListWithUsingSleep;

import static java.lang.Thread.sleep;

/**
 * Created by Andrey on 16.03.2017.
 */
public class DemoFillListWithUsingSleep {

    public static char firstLetter = 'A';
    public static char lastLetter = 'Z';
    public static String last2Letters = "ZZ";

    public static void main(String[] args) {

        SharedList sharedList = new SharedList();

        ThreadFillListWithUsingSleep threadFillListWithUsingSleep1 = new ThreadFillListWithUsingSleep(sharedList, "Thread 1");
        ThreadFillListWithUsingSleep threadFillListWithUsingSleep2 = new ThreadFillListWithUsingSleep(sharedList, "Thread 2");
        ThreadFillListWithUsingSleep threadFillListWithUsingSleep3 = new ThreadFillListWithUsingSleep(sharedList, "Thread 3");
        ThreadFillListWithUsingSleep threadFillListWithUsingSleep4 = new ThreadFillListWithUsingSleep(sharedList, "Thread 4");

        threadFillListWithUsingSleep1.start();
        threadFillListWithUsingSleep2.start();
        threadFillListWithUsingSleep3.start();
        threadFillListWithUsingSleep4.start();

        for (char s = firstLetter; s <= lastLetter; s++) {
            sharedList.addToList(Character.toString(s));
            System.out.println("Main thread add: " + s);
            int sizeList = sharedList.getStringArrayList().size();
            String lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);

            while (!(lastCharacterInList.length() == 2 & lastCharacterInList.endsWith(String.valueOf(lastLetter)))) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sizeList = sharedList.getStringArrayList().size();
                lastCharacterInList = sharedList.getStringArrayList().get(sizeList - 1);
            }
        }
        threadFillListWithUsingSleep1.interrupt();
        threadFillListWithUsingSleep2.interrupt();
        threadFillListWithUsingSleep3.interrupt();
        threadFillListWithUsingSleep4.interrupt();

        System.out.println(sharedList.toString());
    }
}
