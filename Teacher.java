package HomeTaskInstitute;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by adminnt on 22.01.17.
 */
public class Teacher extends Human {


    private UUID id;
    private static Teacher[] arrayOfTeacher;
    private static int countOfTeachers; // number of teachers

    static {
        arrayOfTeacher = new Teacher[0];
    }


    public Teacher(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
        countOfTeachers++;
        arrayOfTeacher = Arrays.copyOf(arrayOfTeacher, countOfTeachers);

        this.id = UUID.randomUUID();
        arrayOfTeacher[countOfTeachers - 1] = this;
    }


    public static Teacher[] getArrayOfTeacher() {
        return Arrays.copyOf(arrayOfTeacher, arrayOfTeacher.length);
//        return arrayOfTeacher;
    }

    public UUID getId() {
        return id;
    }

    public static int getCountOfTeachers() {
        return countOfTeachers;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this instanceof Object)) return false;
        if (this.getClass() != o.getClass()) return false;

        Teacher t = (Teacher) o;
        if (this.id != t.id) return false;

        return true;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //("yyyy-MM-dd");

//        String result = "Student with ID: " + getId() + "; Last Name = " + getLastName() + "; First Name = " + getFisrtName() +
//                "; Middle Name = " + getMiddleName();
        String result = "Student with  Last Name = " + getLastName();
        return result;
    }


    @Override
    public Teacher[] leaveInstitute() {
        //Teacher[] arrOfTeachers = getArrayOfTeacher();
        int position = -1;

        for (int i = 0; i < arrayOfTeacher.length; i++) {
            if (arrayOfTeacher[i].equals(this)) {
                position = i;
                break;
            }
        }

        for (int j = position; j < arrayOfTeacher.length; j++) {
            if (j < arrayOfTeacher.length - 1) {
                arrayOfTeacher[j] = arrayOfTeacher[j + 1];
            } else {
                arrayOfTeacher = Arrays.copyOf(arrayOfTeacher, arrayOfTeacher.length - 1);
                break;
            }
        }
        return arrayOfTeacher;
    }
}
