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
        try {
            modifList.add(e);
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if ((index > unModifList.size() - 1) & index < (unModifList.size() + modifList.size() )) {
            try {
                modifList.add(index, element);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            throw new UnsupportedOperationException("It is impossible to add element " + element +  " into " + index + " position in the List");
        }
    }

    @Override
    public E set(int index, E element) {
        if ((index > unModifList.size() - 1) & index < (unModifList.size() + modifList.size() )) {
            try {
                E previousElement = modifList.set(index, element);
                return previousElement;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            throw new UnsupportedOperationException("It is impossible to set element " + element +  " into " + index + " position in the List");
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        Iter oIterator = new Iter();
        while (oIterator.hasNext()) {
            Object n = oIterator.next();
            if (n.equals(o) & oIterator.currentPosition > unModifList.size() - 1) {
                return modifList.remove(o);
            }
        }
        return false;
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
                throw new NoSuchElementException("There is no next item in the list");
            }
        }

        @Override
        public void remove() {
            if (UnionModifiableAndUnModifiableLists.this.size() > 0) {
                modifList.removeAll(modifList);
            } else {
                throw new NoSuchElementException("There is no items in the list");
            }
        }
    }
}
