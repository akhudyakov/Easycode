package com.easycode.institute.store;

import com.easycode.institute.domainobject.Group;

import java.util.LinkedList;

/**
 * Created by Andrey on 21.02.2017.
 */
public class GroupStore {

    private LinkedList<Group> storeOfGroups = new LinkedList<>();

    public void addGroupToStore(Group g) {
        if (!storeOfGroups.contains(g)) {
            storeOfGroups.add(g);
            g.setGroupStore(this);
        } else {
            System.out.println("Specific \"" + g.toString() + "\" already exists in the Store and it cannot be added");
        }
    }

    protected void removeGroupFromStore(Group g) {
        if (!storeOfGroups.contains(g)) {
            storeOfGroups.remove(g);
        } else {
            System.out.println("Specific \"" + g.toString() + "\" does not exist in the Store and it cannot be removed");
        }
    }

    @Override
    public String toString() {
        return "GroupStore{" +
                "Groups=" + storeOfGroups +
                '}';
    }
}