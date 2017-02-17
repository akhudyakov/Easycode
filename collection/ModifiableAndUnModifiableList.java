package hometask.collection;

import lesson8.Holiday;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrey on 17.02.2017.
 */
public class ModifiableAndUnModifiableList {
    public static void main(String[] args) {

        List<String> modifiedList = new ArrayList<>();

        modifiedList.add("a");
        modifiedList.add("b");
        modifiedList.add("c");

        List<String> immutableList=Collections.unmodifiableList(
                new ArrayList<String>());

        System.out.println(modifiedList);
        System.out.println(immutableList);

    }
}
