package hometaskThreads;

/**
 * Created by Student on 25.02.2017.
 */
public class ThreadFillList extends Thread {

    private SharedList sharedList;
    private String last2Letters = "";
    private char firstLetter = 'A';
    private String nameOfThread;

    ThreadFillList(SharedList sl, String nameOfThread) {
        super(nameOfThread);
        this.sharedList = sl;
        this.nameOfThread = nameOfThread;
    }

    public void run() {

        while (!last2Letters.equals("ZZ")) {

            int sizeList = sharedList.getStringArrayList().size();

            if (sizeList > 0) {

                String lastStringInList = sharedList.getStringArrayList().get(sizeList - 1);
//                char lastCharInList = lastStringInList.charAt(0);
                last2Letters = lastStringInList + "Z";


                char temp = firstLetter;
                String stringToAdd = lastStringInList;

                while (!(stringToAdd.equals(last2Letters)) ) {

                    stringToAdd = lastStringInList + Character.toString(temp);
                    if ( stringToAdd.length() < 3){
                        sharedList.addToList(stringToAdd);
                        System.out.println(Thread.currentThread().getName() +  " has just add: " + stringToAdd);

                    }
                    ++temp;

                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                Thread.yield();
            } else {
                Thread.yield();
            }
        }
        interrupt();
    }
}


    /*public void run() {
        for (char s = 'A'; s <= 'Z'; s++) {
            sharedList.addToList(Character.toString(s));
            for (char z = 'A'; z <= 'Z'; z++) {
                String temp = Character.toString(s) + Character.toString(z);
                sharedList.addToList(temp);
            }
        }
    }
    }*/
