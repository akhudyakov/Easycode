package HomeTaskInstituteOnList;

import java.util.*;

/**
 * Created by Andrey on 16.01.2017.
 */
public class Group implements Iterable<Student> {

    private UUID idGroup;
    private HashSet<Student> arrayWithStudents = new HashSet<>();
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

    public static Group[] getArrayOfAllGroups() {
        return arrayOfAllGroups;
    }

    public static int getCountOfGroup() {
        return countOfGroup;
    }

    public HashSet<Student> getArrayWithStudents() {
        return arrayWithStudents;
    }

    public UUID getLeader() {
        return leader;
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

    @Override
    public Iterator<Student> iterator() {
        return new Itr();
    }


  /*  @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
*/

    public void printListOfStudentsInTheGroup() {
        String result = "\n The " + this.toString() + " contains next Students: \n{";
        //Iterator<Student> studentIterator = arrayWithStudents.iterator();
        Iterator<Student> studentIterator = this.iterator();
        boolean exist;


        while (exist = studentIterator.hasNext()) {
            Student nextObj = studentIterator.next();
            result += nextObj + ";  \n";

        }
        result += "}";
        System.out.println(result);
    }


//    public static Student[] getArrayOfStudentsInTheGroup(Group gr) {
//        return gr.arrayWithStudents;
//    }

//    public Student[] getArrayOfStudentsInTheGroup() {
//        return arrayWithStudents;
//    }


    public void addStudentToGroup(Student st) {

        Comparator<Student> c = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getId().compareTo(s2.getId());
            }
        };

        if (this.countOfGroupMembers < getMaxNumberStudentsInGroup()) {
            this.countOfGroupMembers++;
            this.arrayWithStudents.add(st);


            System.out.println(" !!! Student with Name: " + WorkWithStudent.getStudentFullNameByStudent(st) + " and with Student's Number: " +
                    st.getNumberStudent() + " has already included into Group with Id" + getIdGroup() + " !!! ");
        }
//        return countOfGroupMembers;
    }

    class Itr implements Iterator<Student> {

        private int current;
        private int next;
        private HashSet<Student> studentHashSet = Group.this.getArrayWithStudents();


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
//            return null;
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







