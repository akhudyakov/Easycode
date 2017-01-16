package HomeTask4_classes;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class Group {

    private UUID idGroup;
    private UUID[] arrayWithIdOfStudents;
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

//        this.arrayWithIdOfStudents = new UUID[0];
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


    public UUID getIdOfStudent(int index) {
        return arrayWithIdOfStudents[index];
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


    @Override // set  by myself
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
        if (this.arrayWithIdOfStudents == null) return gr.arrayWithIdOfStudents==null;
        if (this.arrayWithIdOfStudents != gr.arrayWithIdOfStudents) return false;
        if (this.leader == null) return gr.leader==null;
        if (this.leader != gr.leader) return false;
        if (this.countOfGroupMembers != gr.countOfGroupMembers) return false;

        return true;
    }


    public void listOfStudentsInTheGroup() {
        String result = "{";
        for (int i = 0; i < this.arrayWithIdOfStudents.length; i++) {
            result += this.arrayWithIdOfStudents[i] + ";";
        }
        result += "]";
        System.out.print(result);
    }


    //    public int addStudentToGroup(UUID idGr, UUID idStudent) {
    public int addStudentToGroup(UUID idGr, Student st) {

        UUID idStudent = st.getId();

        if (this.idGroup == idGr) {

            // what is better: creating array in constructor or here ?
            //if it is here I can check: "is array null" for equals
            if (this.arrayWithIdOfStudents == null) {
                this.arrayWithIdOfStudents = new UUID[0];
            }


            if (Arrays.binarySearch(this.arrayWithIdOfStudents, idStudent) < 0 & this.countOfGroupMembers < st.getMaxCourses()) {


                this.countOfGroupMembers++;
                this.arrayWithIdOfStudents = Arrays.copyOf(this.arrayWithIdOfStudents, this.countOfGroupMembers);
                this.arrayWithIdOfStudents[this.countOfGroupMembers - 1] = idStudent;


            } else {
                System.out.println(" !!! Student with Name: " + getStudentFullNameByStudent(st) + " and with ID: " + idStudent + " has already included into Group with Id" + idGr + " !!! ");
            }

        } else {
            System.out.println("!!!  Inputted parameter Id of Group is incorrect  !!!");
        }
        return countOfGroupMembers;
    }


    public String getStudentFullNameByStudent(Student st) {

        String result = st.getLastName() + " " + st.getFisrtName() + " " + st.getMiddleName();
        return result;

    }

}
