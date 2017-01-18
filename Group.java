package HomeTask4_classes;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class Group {

    private UUID idGroup;
    //    private UUID[] arrayWithStudents;
    private Student[] arrayWithStudents;
    private UUID leader;
    private int numberOfFaculty; // number of current faculty
    private int numberOfCourse; // number of current course
    private String groupNumber; // // number of current group in stream
    private String groupName; // common name which made of 3 components
    private int countOfGroupMembers; // number of students in the group

    private final int maxNumberStudentsInGroup = 30;


    public Group(int numberOfCourse, int numberOfFaculty, String groupNumber) {

        this.idGroup = UUID.randomUUID();
        this.groupName = String.valueOf(numberOfFaculty) + String.valueOf(numberOfCourse) + groupNumber;
    }

    public UUID getIdGroup() {
        return idGroup;
    }

    public int getCountOfGroupMembers(UUID idGr) {
        int count = -1;
        if (this.idGroup == idGr) {
            count = countOfGroupMembers;
        }
        return count;
    }

    public int getCountOfGroupMembers() {
        return countOfGroupMembers;
    }

    public int getNumberOfFaculty() {
        return numberOfFaculty;
    }

    public void setNumberOfFaculty(int numberOfFaculty) {
        this.numberOfFaculty = numberOfFaculty;
    }

    public int getNumberOfCourse() {
        return numberOfCourse;
    }


    public void setNumberOfCourse(int numberOfCourse) {
        this.numberOfCourse = numberOfCourse;
    }



    public Student getStudentNumber(int index) {
        return arrayWithStudents[index];
    }


    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber() {
        this.groupNumber = groupNumber;
    }

    public UUID getIdOfLeader() {
        return leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    public String getGroupName() {
        return groupName;
    }


    @Override
    public String toString() {

        String result = "Group ID = " + getIdGroup() + "; Group Name = " + getGroupName();

        return result;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this instanceof Object) return true;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;

        Group gr = (Group) o;
        if (this.idGroup != gr.idGroup) return false;
        if (this.groupName == null) return gr.groupName == null;
        if (this.arrayWithStudents == null) return gr.arrayWithStudents == null;
        if (this.arrayWithStudents != gr.arrayWithStudents) return false;
        if (this.leader == null) return gr.leader == null;
        if (this.leader != gr.leader) return false;
        if (this.countOfGroupMembers != gr.countOfGroupMembers) return false;

        return true;
    }


    public void printListOfStudentsInTheGroup() {
        String result = "{";
        for (int i = 0; i < this.arrayWithStudents.length; i++) {
            if (i == this.arrayWithStudents.length - 1) {
                result += this.arrayWithStudents[i];
            } else {
                result += this.arrayWithStudents[i] + ";";
            }
        }
        result += "}";
        System.out.print(result);
    }



    public static Student[] getArrayOfStudentsNumbersInTheGroup(Group g) {
        return g.arrayWithStudents;
    }


    //    public int addStudentToGroup(UUID idGr, UUID idStudent) {
    public int addStudentToGroup(Student st) {



        // what is better: creating array in constructor or here ?
        //if it is here I can check: "is array null" for equals
        if (this.arrayWithStudents == null) {
            this.arrayWithStudents = new Student[0];
        }


//        if (Arrays.binarySearch(this.arrayWithStudents, st) < 0 & this.countOfGroupMembers < st.getMaxCourses()) {
//        I commented out row which is above because of: java.lang.ClassCastException: HomeTask4_classes.Student cannot be cast to java.lang.Comparable   Why? they have the same type Student
//        and I cannot create array with only unique Students
        if (this.countOfGroupMembers < st.getMaxCourses()) {


            this.countOfGroupMembers++;
            this.arrayWithStudents = Arrays.copyOf(this.arrayWithStudents, this.countOfGroupMembers);
            this.arrayWithStudents[this.countOfGroupMembers - 1] = st;


        } else {
            System.out.println(" !!! Student with Name: " + getStudentFullNameByStudent(st) + " and with Student's Number: " + st.getNumberStudent() + " has already included into Group with Id" + getIdGroup() + " !!! ");
        }

//        } else {
//            System.out.println("!!!  Inputted parameter Id of Group is incorrect  !!!");
//        }
        return countOfGroupMembers;
    }


    public String getStudentFullNameByStudent(Student st) {

        String result = st.getLastName() + " " + st.getFisrtName() + " " + st.getMiddleName();
        return result;

    }

}
