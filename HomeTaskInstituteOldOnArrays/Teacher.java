package HomeTaskInstituteOldOnArrays;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by adminnt on 22.01.17.
 */
public class Teacher extends Human {


    private UUID id;
    private static Teacher[] arrayOfAllTeachers;
    private static int countOfTeachers; // number of teachers

    static {
        arrayOfAllTeachers = new Teacher[0];
    }


    public Teacher(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
        countOfTeachers++;
        arrayOfAllTeachers = Arrays.copyOf(arrayOfAllTeachers, countOfTeachers);

        this.id = UUID.randomUUID();
        arrayOfAllTeachers[countOfTeachers - 1] = this;
    }


    public static Teacher[] getArrayOfAllTeachers() {
        return Arrays.copyOf(arrayOfAllTeachers, arrayOfAllTeachers.length);
//        return arrayOfAllTeachers;
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

//        String result = "Teacher with ID: " + getId() + "; Last Name = " + getLastName() + "; First Name = " + getFirstName() +
//                "; Middle Name = " + getMiddleName();
        String result = "Teacher with  Last Name = " + getLastName();
        return result;
    }


    @Override
    public Teacher[] leaveInstitute() {
        //Teacher[] arrOfTeachers = getArrayOfAllTeachers();
        int position = -1;

        for (int i = 0; i < arrayOfAllTeachers.length; i++) {
            if (arrayOfAllTeachers[i].equals(this)) {
                position = i;
                break;
            }
        }

        for (int j = position; j < arrayOfAllTeachers.length; j++) {
            if (j < arrayOfAllTeachers.length - 1) {
                arrayOfAllTeachers[j] = arrayOfAllTeachers[j + 1];
            } else {
                arrayOfAllTeachers = Arrays.copyOf(arrayOfAllTeachers, arrayOfAllTeachers.length - 1);
                break;
            }
        }
        return arrayOfAllTeachers;
    }
}
