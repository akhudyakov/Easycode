package HomeTaskInstitute;

import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class Group {

    private UUID idGroup;
    private Student[] arrayWithStudents;
    private UUID leader;
    private int numberOfFaculty; // number of current faculty
    private int numberOfCourse; // number of current course
    private String groupNumber; // // number of current group in stream
    private String groupName; // common name which made of 3 components
    private int countOfGroupMembers; // number of students in the group

    private final int maxNumberStudentsInGroup = 30;
    private static Group[] arrayOfAllGroups;
    private static int countOfGroup;

    static {
        arrayOfAllGroups = new Group[0];
    }


    public Group(int numberOfCourse, int numberOfFaculty, String groupNumber) {
        countOfGroup++;
        arrayOfAllGroups = Arrays.copyOf(arrayOfAllGroups, countOfGroup);

        this.numberOfCourse = numberOfCourse;
        this.numberOfFaculty = numberOfFaculty;
        this.groupNumber = groupNumber;
        this.idGroup = UUID.randomUUID();
        this.groupName = String.valueOf(numberOfFaculty) + String.valueOf(numberOfCourse) + groupNumber;
        arrayOfAllGroups[countOfGroup - 1] = this;
    }

    public UUID getIdGroup() {
        return idGroup;
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

    public int getMaxNumberStudentsInGroup() {
        return maxNumberStudentsInGroup;
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

    public static Group[] getArrayOfAllGroups() {
        return arrayOfAllGroups;
    }

    public void setArrayWithStudents(Student[] arrayWithStudents) {
        this.arrayWithStudents = arrayWithStudents;
    }

    public static int getCountOfGroup() {
        return countOfGroup;
    }

    @Override
    public String toString() {

        String result = "Group ID = " + getIdGroup() + "; Group Name = " + getGroupName();

        return result;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this instanceof Object)) return false;
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
        String result = "\n The " + this.toString() + " contains next Students: \n{";
        for (int i = 0; i < this.arrayWithStudents.length; i++) {
            if (i == this.arrayWithStudents.length - 1) {
                result += this.arrayWithStudents[i];
            } else {
                result += this.arrayWithStudents[i] + ";  \n";
            }
        }
        result += "}";
        System.out.print(result);
    }


    public static Student[] getArrayOfStudentsInTheGroup(Group gr) {
        return gr.arrayWithStudents;
    }

    public Student[] getArrayOfStudentsInTheGroup() {
        return arrayWithStudents;
    }


    public int addStudentToGroup(Student st) {

        // what is better: creating array in constructor or here ?
        //if it is here I can check: "is array null" for equals
        if (this.arrayWithStudents == null) {
            this.arrayWithStudents = new Student[0];
        }

        Comparator<Student> c = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        };

        if (Arrays.binarySearch(this.arrayWithStudents, st, c) < 0 & this.countOfGroupMembers < getMaxNumberStudentsInGroup()) {
            this.countOfGroupMembers++;
            this.arrayWithStudents = Arrays.copyOf(this.arrayWithStudents, this.countOfGroupMembers);
            this.arrayWithStudents[this.countOfGroupMembers - 1] = st; // adding Student to array the Group's students
            st.setGroupOfStudent(this); // set Group to Student who has just been added
        } else {
            System.out.println(" !!! Student with Name: " + WorkWithStudent.getStudentFullNameByStudent(st) + " and with Student's Number: " +
                    st.getNumberStudent() + " has already included into Group with Id" + getIdGroup() + " !!! ");
        }
        return countOfGroupMembers;
    }
}
