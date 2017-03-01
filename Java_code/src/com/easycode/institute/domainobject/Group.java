package com.easycode.institute.domainobject;

import com.easycode.institute.additionalFunctional.WorkWithStudent;
import com.easycode.institute.store.GroupStore;

import java.util.*;

/**
 * numberOfFaculty - number of current faculty
 * numberOfCourse - number of current course
 * groupNumber - number of current group in stream
 * groupName  -  common name which made of 3 components
 */
public class Group implements Iterable<Student> {

    private UUID idGroup;
    private HashSet<Student> arrayWithStudents = new HashSet<>();
    private UUID leader;
    private int numberOfFaculty;
    private int numberOfCourse;
    private String groupNumber;
    private String groupName;
    private GroupStore groupStore;
    private final int Max_Number_Students_In_Group = 30;


    public Group(int numberOfCourse, int numberOfFaculty, String groupNumber) {
        this.numberOfCourse = numberOfCourse;
        this.numberOfFaculty = numberOfFaculty;
        this.groupNumber = groupNumber;
        this.idGroup = UUID.randomUUID();
        this.groupName = String.valueOf(numberOfFaculty) + String.valueOf(numberOfCourse) + groupNumber;
    }

    public UUID getIdGroup() {
        return idGroup;
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

    public int getMax_Number_Students_In_Group() {
        return Max_Number_Students_In_Group;
    }

    public boolean existStudentInGroup() {
        return arrayWithStudents.contains(this);
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

    public GroupStore getGroupStore() { return groupStore; }

    public void setGroupStore(GroupStore groupStore) { this.groupStore = groupStore; }

    public HashSet<Student> getArrayWithStudents() { return arrayWithStudents;   }

    public UUID getLeader() {
        return leader;
    }

    @Override
    public String toString() {
        String result = "Group " + getGroupName();
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

        return true;
    }

    @Override
    public Iterator<Student> iterator() {
        return new Itr();
    }

    public void printListOfStudentsInTheGroup() {
        String result = "\n The " + toString() + " contains next Students: \n{";
        //Iterator<Student> studentIterator = arrayWithStudents.iterator();
        Iterator<Student> studentIterator = iterator();
        boolean exist;

        while (exist = studentIterator.hasNext()) {
            Student nextObj = studentIterator.next();
            result += nextObj + ";  \n";
        }
        result += "}";
        System.out.println(result);
    }

    public void addStudentToGroup(Student st) {

        if (!arrayWithStudents.contains(st)) {
          if (arrayWithStudents.size() < getMax_Number_Students_In_Group()) {
//              this.countOfGroupMembers++;
              arrayWithStudents.add(st);
              st.setGroupOfStudent(this);
              System.out.println("Successfull!!! Student with Name: " + WorkWithStudent.getStudentFullNameByStudent(st) + " and with Number: " +
                      st.getNumberStudent() + " has been included into Group " + getGroupName());
          } else {
              System.out.println("Error!!! " + toString() + " is full. We cannot add the " + st.toString() +
                      " to the Group because Maximum number of students: " + getMax_Number_Students_In_Group() + "  in a group is already reached" );
          }
        } else {
            System.out.println("Error !!! Student with Name: " + WorkWithStudent.getStudentFullNameByStudent(st) + " and with Number: " +
                    st.getNumberStudent() + " has already included into the Group " + getGroupName() + " !!! ");
        }
    }

    class Itr implements Iterator<Student> {

        private int current;
        private int next;
        private HashSet<Student> studentHashSet = getArrayWithStudents();

        int expectedSize = studentHashSet.size();

        Object[] studentArray = studentHashSet.toArray();

        @Override
        public boolean hasNext() {
            int currentSize = studentHashSet.size();
            if (expectedSize != currentSize) {
                throw new ConcurrentModificationException();
            }
            return next < studentHashSet.size();
        }

        @Override
        public Student next() {
            if (hasNext()) {
                current = next;
                next++;
            } else {
                throw new NoSuchElementException();
            }
            return (Student) studentArray[current];
        }

        @Override
        public void remove() {
            if (studentHashSet.size() > 0) {
                studentHashSet.iterator().remove();
            } else {
                System.out.println("There is no items in Array");
                throw new NoSuchElementException();
            }
        }
    }
}