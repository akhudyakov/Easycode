package HomeTaskInstituteOnList;

import java.util.TreeSet;

/**
 * Created by Student on 19.02.2017.
 */
public class StudentsStore {

    private TreeSet<Student> storeStudents = new TreeSet<> ();

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
    }


}
