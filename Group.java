package HomeTask4_classes;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class Group {

    private UUID idGroup;
    private UUID[] arrayWithIdOfStudents;
    private UUID leader;
    private int numberOfFaculty;
    private int numberOfCourse;
    private String groupNumber;
    private String groupName;
    private int countOfGroupMembers;

    private final int maxNumberStudentsInGroup = 30;

    public UUID getIdGroup() {
        return idGroup;
    }

    public int getCountOfGroupMembers(UUID idGr) {
        int count = 0;
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


    public Group(int numberOfCourse, int numberOfFaculty, String groupNumber) {

        this.idGroup = UUID.randomUUID();
        this.groupName = String.valueOf(numberOfFaculty) + String.valueOf(numberOfCourse) +  groupNumber;

        this.arrayWithIdOfStudents = new UUID [0];

    }

    public int addStudentToGroup(UUID idGr, UUID idStudent) {


        if (this.idGroup == idGr) {

        } else if (Arrays.binarySearch(arrayWithIdOfStudents, idStudent) < 0) {

            this.countOfGroupMembers++;
            UUID[] ArrayWithIdOfStudents = Arrays.copyOf(arrayWithIdOfStudents, countOfGroupMembers);
            ArrayWithIdOfStudents[this.countOfGroupMembers] = idStudent;

        }
        return countOfGroupMembers;
    }

    @Override // set  by myself
    public String toString() {

        String result = "Group ID = " + getIdGroup() + "; Group Name = " + getGroupName();

        return result;
    }

}
