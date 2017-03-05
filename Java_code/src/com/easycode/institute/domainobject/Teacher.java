package com.easycode.institute.domainobject;

import com.easycode.institute.store.TeacherStore;

import java.sql.RowId;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Created by adminnt on 22.01.17.
 */
public class Teacher extends Human {


    private int id;
    private TeacherStore teacherStore;

    public Teacher() {}

    public Teacher(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
//        this.id = UUID.randomUUID();
    }

    @Override
    public void leaveInstitute() {

        if (teacherStore.getTeacherStore().contains(this)) {
            teacherStore.removeTeacherFromStore(this);
            teacherStore = null;
        } else { throw new NoSuchElementException();
        }
    }

    @Override
    public int hashCode() {
        return teacherStore.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this instanceof Object)) return false;
        if (this.getClass() != o.getClass()) return false;

        Teacher t = (Teacher) o;
        if (this.id != t.id) return false;
        if (this.teacherStore == null) return t.teacherStore == null;
        if (this.teacherStore != t.teacherStore) return false;

        return true;
    }

    public String toString() {

        String result = "Teacher with" + " Last Name = " + getLastName() + "; First Name = " + getFirstName() + "; ID= " + getId();
        return result;
    }

    public int getId() { return id;  }

    public void setId(int id) { this.id = id; }

    public TeacherStore getTeacherStore() {
        return teacherStore;
    }

    public void setTeacherStore(TeacherStore teacherStore) {
        this.teacherStore = teacherStore;
    }
}
