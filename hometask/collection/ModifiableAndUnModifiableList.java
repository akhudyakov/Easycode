package hometask.collection;

import hometask.collection.UnionModifiableAndUnModifiableLists;
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

        List<String> immutableList = Collections.unmodifiableList(
                new ArrayList<String>(modifiedList));
//                new ArrayList<String>());

        UnionModifiableAndUnModifiableLists unionModifiableAndUnModifiableList = new UnionModifiableAndUnModifiableLists(immutableList, modifiedList);

        unionModifiableAndUnModifiableList.add("d");
        System.out.println(unionModifiableAndUnModifiableList);
        unionModifiableAndUnModifiableList.remove("d");

        System.out.println(unionModifiableAndUnModifiableList);
//        for (int i = 0; i < unionModifiableAndUnModifiableList.size() ; i++) {
//            System.out.println(unionModifiableAndUnModifiableList.get(i));
//        }
    }
}
