package hometask.collection;

import java.util.AbstractList;
import java.util.List;

/**
 * Created by Andrey on 17.02.2017.
 */
public class UnionModifiableAndUnModifiableLists<E> extends AbstractList<E> {

    private List<E> list1;
    private List<E> list2;


    public UnionModifiableAndUnModifiableLists(List<E> list1, List<E> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public E get(int index) {

        E objTemp;

        if (index < list1.size()) {
            objTemp = list1.get(index);
        } else {
            objTemp = list2.get(index - list2.size());
        }
        return objTemp;
    }

    @Override
    public int size() {
        return list1.size() + list2.size();
    }

    @Override
    public boolean add(E e) {
        int lastPosition = list1.size() + list2.size() + 1;
        super.add(lastPosition, e);
        return true;
    }
}

