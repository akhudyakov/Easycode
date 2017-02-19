package hometask.collection;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Andrey on 17.02.2017.
 */
public class UnionModifiableAndUnModifiableLists<E> extends AbstractList<E> {

    private List<E> unModifList;
    private List<E> modifList;


    public UnionModifiableAndUnModifiableLists(List<E> unModifList, List<E> modifList) {
        this.unModifList = unModifList;
        this.modifList = modifList;
    }

    @Override
    public E get(int index) {

        E objTemp;

        if (index < unModifList.size()) {
            objTemp = unModifList.get(index);
        } else {
            objTemp = modifList.get(index - unModifList.size());
        }
        return objTemp;
    }

    @Override
    public int size() {
        return unModifList.size() + modifList.size();
    }

    @Override
    public boolean add(E e) {
        int lastPosition = unModifList.size() + modifList.size() + 1;
        try {
//            super.add(lastPosition, e);
//            super.add(e);
            modifList.add(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        int currentPosition;
        int nextPosition;


        @Override
        public boolean hasNext() {
            return nextPosition < UnionModifiableAndUnModifiableLists.this.size();
        }

        @Override
        public E next() {
            if (hasNext()) {
                currentPosition = nextPosition;
                nextPosition++;
                return UnionModifiableAndUnModifiableLists.this.get(currentPosition);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (UnionModifiableAndUnModifiableLists.this.size() > 0) {
                modifList.removeAll(modifList);
            } else {
                System.out.println("There is no items in Array");
                throw new NoSuchElementException();
            }
        }
    }
}
