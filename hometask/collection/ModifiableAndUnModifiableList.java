package hometask.collection;

import java.util.ArrayList;
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

        System.out.println("Before adding: " + unionModifiableAndUnModifiableList);
        unionModifiableAndUnModifiableList.add("d");
        System.out.println("After adding: " + unionModifiableAndUnModifiableList);

        unionModifiableAndUnModifiableList.remove("a");
        System.out.println("After deleting: " + unionModifiableAndUnModifiableList);

//        for (int i = 0; i < unionModifiableAndUnModifiableList.size() ; i++) {
//            System.out.println(unionModifiableAndUnModifiableList.get(i));
//        }
    }
}
