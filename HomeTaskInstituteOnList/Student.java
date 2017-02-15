package HomeTaskInstituteOnList;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by adminnt on 15.01.17.
 */
public class Student extends Human {

    private UUID id;
    private int numberStudent;
    private static Student[] arrayOfAllStudents;
    private Group groupOfStudent;

    //    private int[][] arrayOfHt;  // all methods regarding 2 dimension array is obsolete and are in the end of this file
    private HomeTask[] arrayOfHt; // array of home task of specific student
    private static int countOfStudents; // number of all students
    private final int Increment_Of_Course = 1;

    public Student(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
        countOfStudents++;
        this.id = UUID.randomUUID();
        this.numberStudent = countOfStudents;
    }

    public UUID getId() {
        return id;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public Group getGroupOfStudent() {
        return groupOfStudent;
    }

    public void setGroupOfStudent(Group groupOfStudent) {
        this.groupOfStudent = groupOfStudent;
    }

    public int getIncrementOfCourse() {
        return Increment_Of_Course;
    }


    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //("yyyy-MM-dd");

        String result = "Student with number: " + getNumberStudent() + "; Last Name = " + getLastName() + "; First Name = " + getFirstName() +
                "; Middle Name = " + getMiddleName();
//                + "; Birthdate = " + formatter.format(getBirthDate()) + "; Document =  "
//                + getDocumentType() + "; Serie = " + getDocumentNumber() + "; Email = " + getEmail() +
//                "; Phone number = " + getPhoneNumber() +  "; ID = " + getId();

        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this instanceof Object)) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;


        Student s = (Student) o;
        if (this.id != s.id) return false;
        if (this.getFirstName() != s.getFirstName()) return false;
        if (this.getLastName() != s.getLastName()) return false;
        if (this.getMiddleName() != s.getMiddleName()) return false;
        if (this.getBirthDate() != s.getBirthDate()) return false;
        if (this.getDocumentType() != s.getDocumentType()) return false;
        if (this.getDocumentNumber() != s.getDocumentNumber()) return false;
//        if (this.getEmail() == null) return s.getEmail() == null;
//        if (this.getEmail() != s.getEmail()) return false;
//        if (this.getPhoneNumber() == null) return s.getPhoneNumber() == null;
//        if (this.getPhoneNumber() != s.getPhoneNumber()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getBirthDate().hashCode();
//        result = 31 * result + getPhoneNumber().hashCode();
//        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + getDocumentType().hashCode();
        result = 31 * result + getDocumentNumber().hashCode();
        return result;
    }

    public static String getStudentFullNameByStudent(Student st) {

        String result = st.getLastName() + " " + st.getFirstName() + " " + st.getMiddleName();

        return result;
    }

    public HomeTask[] getArrayOfHt() {
        return arrayOfHt;
    }

    public void addHomeTaskToStudent(HomeTask ht) {

        //int numberHT = ht.getNumberOfHt();


        if (this.arrayOfHt == null) {
            this.arrayOfHt = new HomeTask[1];
            this.arrayOfHt[(arrayOfHt.length - 1)] = ht;
        } else {
            //   I get  java.lang.ClassCastException: HomeTaskInstituteOldOnArrays.HomeTask cannot be cast to java.lang.Comparable for row is below. Both ar HomeTask type. Why do I get that?
            //if (Arrays.binarySearch(this.arrayOfHt, ht) < 0) {

            this.arrayOfHt = Arrays.copyOf(this.arrayOfHt, this.arrayOfHt.length + 1);
            this.arrayOfHt[(arrayOfHt.length - 1)] = ht;

//                System.out.println("Task" + Arrays.deepToString(this.arrayOfHt));

//            } else {
//                System.out.println(" !!! HomeTask " + ht.toString() + " has already added into to Student " + this.toString() + " !!! ");
        }
    }


    public static void printListOfStudentTasks(Student st) {
        String result = " Student " + getStudentFullNameByStudent(st) + " has next tasks:  {";

        for (int i = 0; i < st.arrayOfHt.length; i++) {
            if (i == st.arrayOfHt.length - 1) {
                result += String.valueOf(st.arrayOfHt[i]);
            } else {
                result += String.valueOf(st.arrayOfHt[i]) + ";";
            }
        }
        result += "}";
        System.out.println(result);
    }


    public static void printListOfStudentTasksWithMarks(Student st) {
        HomeTask tempTask;
        int mark;

        for (int i = 0; i < st.arrayOfHt.length; i++) {
            tempTask = st.arrayOfHt[i]; //each task for the student
            mark = tempTask.getMark();
            System.out.println(st.toString() + " Task with: " + tempTask.toString() + " has the mark " + mark);
        }
    }

    @Override
    public Student[] leaveInstitute() {

        Group gr = this.groupOfStudent; // link to Student's Group
        this.groupOfStudent = null;
        Student[] arrStudentsInTheGroup =  null; //gr.getArrayOfStudentsInTheGroup();  // get  array of all Students of the Group

        Comparator<Student> c = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        };

        int indexInArray = Arrays.binarySearch(arrStudentsInTheGroup, this, c);

        for (int i = indexInArray; i < arrStudentsInTheGroup.length; i++) {
            if (i < arrStudentsInTheGroup.length - 1) {
                arrStudentsInTheGroup[i] = arrStudentsInTheGroup[i + 1];
            } else {
                arrStudentsInTheGroup = Arrays.copyOf(arrStudentsInTheGroup, arrStudentsInTheGroup.length - 1);
                break;
            }
        }
//        gr.setArrayWithStudents(arrStudentsInTheGroup);
        return arrStudentsInTheGroup;
    }
}

