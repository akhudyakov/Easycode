package HomeTaskInstitute;

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
        int i = 1;
    }


    public Teacher(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
        countOfTeachers++;
        arrayOfTeacher = Arrays.copyOf(arrayOfTeacher, countOfTeachers);

        this.id = UUID.randomUUID();
        arrayOfTeacher[countOfTeachers - 1] = this;


    }

    public static Teacher[] getArrayOfTeacher() {
        return arrayOfTeacher;
    }

}
