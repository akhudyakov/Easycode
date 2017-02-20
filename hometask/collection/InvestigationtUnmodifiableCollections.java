package hometask.collection;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrey on 17.02.2017.
 *
 *    IT IS NOT HOME TASK
 *
 */
public class InvestigationtUnmodifiableCollections {

    public static void main(String[] args) {
       List<String> modifiableList = new ArrayList<String>();
        modifiableList.add("a");



        System.out.println("modifiableList:"+modifiableList);
        System.out.println("--");


        //unModifiableList

        System.out.println(modifiableList.size());

        List<String> unModifiableList= Collections.unmodifiableList(
                modifiableList);

        modifiableList.add("b");

        boolean exceptionThrown=false;
        try {
            unModifiableList.add("b");

        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("unModifiableList.add() not supported");
        }


        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);


        System.out.println("--");

        List<String> immutableList=Collections.unmodifiableList(
                new ArrayList<String>(modifiableList));

        modifiableList.add("c");

        exceptionThrown=false;
        try {
            immutableList.add("c");

        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("immutableList.add() not supported");
        }



        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);
        System.out.println("immutableList:"+immutableList);
        System.out.println("--");



    }
}
