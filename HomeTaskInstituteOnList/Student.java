package HomeTaskInstituteOnList;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by adminnt on 15.01.17.
 */
public class Student extends Human {

    private UUID id;
    private int numberStudent;
//    private static Student[] arrayOfAllStudents;
    private Group groupOfStudent;
    private HashMap<HomeTask, Marks> homeTasksWithMarks = new HashMap<>();
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
                "; Middle Name = " + getMiddleName() + (getGroupOfStudent()!=null?" is  learning in a group " + getGroupOfStudent():" has not included in a Group yet");
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


    public void addHomeTaskToStudentWithoutMark(HomeTask ht) {
        homeTasksWithMarks.put(ht, null);
        System.out.println(ht.toString() + " has been added to " + this.toString() + " without a mark");
    }

    public void addHomeTaskToStudentWithMark(HomeTask ht, Marks m) {
        homeTasksWithMarks.put(ht, m);
        System.out.println(ht.toString() + " has been added to " + this.toString() + " with the mark " + m.getMark());
    }

    public void setMarkToHomeTask(HomeTask ht, Marks m) {

        if (homeTasksWithMarks.containsKey(ht)) {
            homeTasksWithMarks.put(ht, m);
            System.out.println(ht.toString() + " has been added to " + this.toString() + " with the mark " + m.getMark());
        } else {
            System.out.println("!!! Warning !!! There is no specific " + ht.toString() + " belongs to " + this.toString() + " !!!");
        }
    }


    @Override
    public void leaveInstitute() {

        Group gr = this.groupOfStudent; // link to Student's Group
        this.groupOfStudent = null;

        HashSet<Student> arrayWithStudents = gr.getArrayWithStudents();

        arrayWithStudents.remove(this);



//        Comparator<Student> c = new Comparator<Student>() {
//            public int compare(Student s1, Student s2) {
//                return s1.getId().compareTo(s2.getId());
//            }
//        };


    }


/*
    public static void printListOfStudentTasksWithMarks(Student st) {
        HomeTask tempTask;
        int mark;

        for (int i = 0; i < st.arrayOfHt.length; i++) {
            tempTask = st.arrayOfHt[i]; //each task for the student
            mark = 2; //tempTask.getMark();
            System.out.println(st.toString() + " Task with: " + tempTask.toString() + " has the mark " + mark);
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
    */
}


