package HomeTaskInstituteOnList.store;

import HomeTaskInstituteOnList.entity.Student;

import java.util.TreeSet;

/**
 * Created by Student on 19.02.2017.
 */
public class StudentsStore {

    private TreeSet<Student> storeStudents = new TreeSet<>();


    public TreeSet<Student> getStoreStudents() {
        return storeStudents;
    }

    @Override
    public String toString() {
        return "StudentsStore{" +
                "storeStudents=" + storeStudents +
                '}';
    }

    public void addStudentToStore(Student s) {
        storeStudents.add(s);
        s.setStudentsStore(this);
    }

    public void removeStudentFromStore(Student s) {storeStudents.remove(s);}
}
