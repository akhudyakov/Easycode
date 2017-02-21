package HomeTaskInstituteOnList;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by adminnt on 15.01.17.
 */
public class Student extends Human implements Comparable<Student> {

    private UUID id;
    private int numberStudent;
    private Group groupOfStudent;
    private StudentsStore studentsStore;
    private HashMap<HomeTask, Marks> homeTasksWithMarks = new HashMap<>();
    private static int countOfStudents; // number of all students
    private final int Increment_Of_Course = 1;

    public Student(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        super(lastName, fisrtName, middleName, birthDate, docType, docNumber);
//        countOfStudents++;
        this.id = UUID.randomUUID();
        this.numberStudent = countOfStudents++;
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

    public StudentsStore getStudentsStore() { return studentsStore; }

    public void setStudentsStore(StudentsStore studentsStore) { this.studentsStore = studentsStore; }

    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //("yyyy-MM-dd");

        String result = "Student with number: " + getNumberStudent() + "; Last Name = " + getLastName() + // "; First Name = " + getFirstName() +    "; Middle Name = " + getMiddleName() +
                (getGroupOfStudent() != null ? " is  studying in " + getGroupOfStudent() : " who has not included in a Group yet");
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
    public int compareTo(Student o) {
        return this.getId().compareTo(o.getId());
    }


    @Override
    public void leaveInstitute() {

        /**
         *  Remove everything regarding student's Hometasks(+marks)
         */
        Set<HomeTask> homeTasks = homeTasksWithMarks.keySet(); // get set of the Student's HomeTask from their array HomeTask + Mark


        if (!homeTasks.isEmpty()) {
            for (HomeTask homeTask: homeTasks) {
                HomeTaskStore homeTaskStore = homeTask.getHomeTaskStore(); // get link to Store of  HomeTask Store where are stored  student's HomeTasks
                homeTaskStore.removeTaskFromTaskStore(homeTask);// remove the task from the Store

                homeTasksWithMarks.remove(homeTask); //remove hometask+mark from array of Student's array of <Hometask, Mark>
                homeTask.setHomeTaskStore(null);
            }
        }


        Group group = this.groupOfStudent; // link to Student's Group
        this.groupOfStudent = null; // remove link to Group from property of the Student

        HashSet<Student> arrayWithStudents = group.getArrayWithStudents(); // array of Students in their Group
        arrayWithStudents.remove(this);

        StudentsStore store = this.studentsStore; // store of Students
        store.removeStudentFromStore(this);
    }


    public void printListOfStudentTasksWithMarks() {

        if(!homeTasksWithMarks.isEmpty()) {
            System.out.println("\nThe " + this.toString() + " has next Home Tasks with marks: \n{");
            for (Map.Entry<HomeTask, Marks> eachHomeTasksWithMarks : homeTasksWithMarks.entrySet()) {
                HomeTask homeTask = eachHomeTasksWithMarks.getKey();
                Marks mark = eachHomeTasksWithMarks.getValue();
                System.out.print(" Task : " + homeTask.toString() +  (mark != null ? " with mark : "+ mark.getMark() + "\n" : "has not had a mark yet \n"));
            }
            System.out.print("}");
        } else {
            System.out.println("\nThere are no home tasks for the " + this.toString());
        }
    }

    public void printListOfStudentTasks() {


        if(!homeTasksWithMarks.isEmpty()) {
            System.out.println("\nStudent \"" + getStudentFullNameByStudent(this) + "\" has next tasks:  \n{");
            for (Map.Entry<HomeTask, Marks> eachHomeTasksWithMarks : homeTasksWithMarks.entrySet()) {
                HomeTask homeTask = eachHomeTasksWithMarks.getKey();
                System.out.print(homeTask.toString() + "\n");
            }
            System.out.print("}");
        } else {
            System.out.println("\nThere are no home tasks for the " + this.toString());
        }
    }

}


