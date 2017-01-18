package HomeTask4_classes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by adminnt on 15.01.17.
 */
public class Student {

    private UUID id;
    private String lastName;
    private String fisrtName;
    private String middleName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String documentType;
    private String documentNumber;
    private int[][] arrayOfHt;
 /*   private int numberOfFaculty;
    private int numberOfCource;
    private String groupNumber; */

    private final int maxCourses = 6; // max number of courses
    private final int incrementOfCourse = 1;

    public Student(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        this.id = UUID.randomUUID();

        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.documentType = docType;
        this.documentNumber = docNumber;

    }


    public UUID getId() {
        return id;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }



    /*public int getNumberOfFaculty() {
        return numberOfFaculty;
    }

    public int getNumberOfCource() {
        return numberOfCource;
    }

    public String getGroupNumber() {
        return groupNumber;
    }*/

    public int getMaxCourses() {
        return maxCourses;
    }

    public int getIncrementOfCource() {
        return incrementOfCourse;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public void setNumberOfFaculty(int numberOfFaculty) {
        this.numberOfFaculty = numberOfFaculty;
    }

    public void setNumberOfCource(int numberOfCource) {
        this.numberOfCource = numberOfCource;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }


    // transfer a student to next cource
    public void transferToNextCourse() {

        if (numberOfCource + incrementOfCourse <= maxCource) {
            numberOfCource += incrementOfCourse;
        }

    } */

    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //("yyyy-MM-dd");

        String result = "student ID = " + getId() + "; Last Name = " + getLastName() + "; First Name = " + getFisrtName() +
                "; Middle Name = " + getMiddleName() + "; Birthdate = " + formatter.format(getBirthDate()) + "; Document =  "
                + getDocumentType() + "; Serie = " + getDocumentNumber() + "; Email = " + getEmail() +
                "; Phone number = " + getPhoneNumber();// + "; Faculty = " + getNumberOfFaculty();

        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this instanceof Object) return true;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;


        Student s = (Student) o;
        if (this.id != s.id) return false;
        if (this.fisrtName != s.fisrtName) return false;
        if (this.lastName != s.lastName) return false;
        if (this.middleName != s.middleName) return false;
        if (this.birthDate != s.birthDate) return false;
        if (this.documentType != s.documentType) return false;
        if (this.documentNumber != s.documentNumber) return false;
        if (this.email == null) return s.email == null;
        if (this.email != s.email) return false;
        if (this.phoneNumber == null) return s.phoneNumber == null;
        if (this.phoneNumber != s.phoneNumber) return false;
        /*if (this.numberOfFaculty != s.numberOfFaculty) return false;
        if (this.numberOfCource != s.numberOfCource) return false;
        if (this.groupNumber == null) return s.groupNumber==null;
        if (this.groupNumber != s.groupNumber) return false; */

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + fisrtName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + documentType.hashCode();
        result = 31 * result + documentNumber.hashCode();
        /*result = 31 * result + numberOfFaculty;
        result = 31 * result + numberOfCource;
        result = 31 * result + (groupNumber != null ? groupNumber.hashCode() : 0); */
        return result;
    }

    public static String getStudentFullNameByStudent(Student st) {

//        UUID id = st.getId();

        String result = "\0";

//        if (this.id == id) {
//            result = this.lastName + " " + this.fisrtName + " " + this.middleName;
        result = st.getLastName() + " " + st.getFisrtName() + " " + st.getMiddleName();
//        }
        return result;
    }


    public void addHomeTaskToStudent(HomeTask ht) {

        int numberHT = ht.getNumberOfHt();


        if (this.arrayOfHt == null) {
//            this.arrayOfHt = new int[0][1];
            this.arrayOfHt = new int[1][2];
            this.arrayOfHt[(arrayOfHt.length - 1)][0] = numberHT;
        } else {


            if (mySearchInArray(this.arrayOfHt, numberHT) < 0) {

                this.arrayOfHt = copyTwoDimArrayWithAddingLenght(this.arrayOfHt);
                this.arrayOfHt[(arrayOfHt.length - 1)][0] = numberHT;
//            this.arrayOfHt[(arrayOfHt.length - 1)][0] = numberHT;
                System.out.println("Task" + Arrays.deepToString(this.arrayOfHt));

            } else {
                System.out.println(" !!! HomeTask with number: " + numberHT + " has already added into to Student with Id" + this.getId() + " !!! ");
            }
        }
    }

    public static void listOfStudentTasks(Student st) {
        String result = " Student " + getStudentFullNameByStudent(st) + " has next tasks:  {";

        for (int i = 0; i < st.arrayOfHt.length; i++) {
            if (i == st.arrayOfHt.length - 1) {
                result += String.valueOf(st.arrayOfHt[i][0]);
            } else {
                result += String.valueOf(st.arrayOfHt[i][0]) + ";";
            }
        }
        result += "}";
        System.out.println(result);
    }


    public static void printListOfStudentTasksWithMarks(Student st) {
        String result = " Student " + getStudentFullNameByStudent(st) + " has next tasks with marks (if mark = 0 - it means that mark is not set) : ";

        System.out.println(result);

        for (int i = 0; i < st.arrayOfHt.length; i++) {

            result = "{ Number of task: " + st.arrayOfHt[i][0] + "; Mark of the task: " + st.arrayOfHt[i][1] + " }";


            System.out.println(result);
        }
    }


    public static int[][] getListOfStudentTasksWithMarks(Student st) {

        int[][] result = st.arrayOfHt;
        return result;
    }

    public static void setTaskMarkToStudentByNumberTask(Student st, int numberTask, int mark) {
        int position = -1;

        if (mark >= HomeTask.getMinMark() & mark <= HomeTask.getMaxMark()) {

            for (int i = 0; i < st.arrayOfHt.length; i++) {
                if (st.arrayOfHt[i][0] == numberTask) {
                    position = i;
                    break;
                }
            }

            if (position > -1) {
                st.arrayOfHt[position][1] = mark;
                System.out.println("Indicated task: \"" + numberTask + "\" has been added to student " + getStudentFullNameByStudent(st));
            } else {
                System.out.println("Student " + getStudentFullNameByStudent(st) + " does not have indicated task: " + numberTask);
                return;
            }
        } else {
            System.out.println("You inputted incorrect mark: " + mark);
        }

    }

    public static int[][] copyTwoDimArrayWithAddingLenght(final int[][] array) { //copy previous state of 2 dimension array with increasing of array's lenght (row and column) on 1
        if (array != null) {
            final int[][] copy = new int[array.length + 1][2]; // increasing of array's length for row on 1

            for (int i = 0; i < array.length; i++) {
                final int[] row = array[i];

                copy[i] = new int[row.length];
                System.arraycopy(row, 0, copy[i], 0, row.length);
            }

            return copy;
        }

        return null;
    }

    public static int mySearchInArray(int[][] array, int searchKey) { // search only by rows

        int position = -1;

        for (int i = 0; i < array.length; i++) {

            if (array[i][0] == searchKey) {
                position = i;
                break;
            }

        }
        return position;
    }
}