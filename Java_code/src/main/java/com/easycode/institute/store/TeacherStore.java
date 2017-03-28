package com.easycode.institute.store;

import com.easycode.institute.domainobject.Teacher;

import java.util.LinkedList;

/**
 * Created by Andrey on 27.02.2017.
 */
public class TeacherStore {

    private LinkedList<Teacher> teacherStore  = new LinkedList<> ();


    public void addTeacherToStore (Teacher t) {
        if (!teacherStore.contains(t)) {
            teacherStore.add(t);
            t.setTeacherStore(this);
        } else {
            System.out.println("Specific \"" + t.toString() + "\" already exists in the Store and it cannot be added");
        }
    }

    public void removeTeacherFromStore(Teacher t) {
        if (teacherStore.contains(t)) {
            teacherStore.remove(t);
        } else {
            System.out.println("Specific \"" + t.toString() + "\" does not exist in the Store and it cannot be removed");
        }
    }

    @Override
    public String toString() {
        return "TeacherStore{" +
                "teacherStore=" + teacherStore +
                '}';
    }

    public LinkedList<Teacher> getTeacherStore() { return teacherStore;  }
}
