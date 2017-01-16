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

    private int maxCourses = 6; // max number of courses
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

    @Override // set  by myself
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

    public String getStudentFullNameByStudentId(UUID id) {

        String result = "\0";

        if (this.id == id) {
            result = this.lastName + " " + this.fisrtName + " " + this.middleName;
        }
        return result;
    }


    public void addHomeTaskToStudent(HomeTask ht) {

        int numberHT = ht.getNumberOfHt();


        if (this.arrayOfHt == null) {
            this.arrayOfHt = new int[1][0];
        }


        if (Arrays.binarySearch(this.arrayOfHt, numberHT) < 0) {


            this.arrayOfHt = copyArr(this.arrayOfHt);
            this.arrayOfHt[(arrayOfHt.length - 1)][0] = numberHT;
//            int[][] arrayOfHt2 = Arrays.copyOf(this.arrayOfHt, this.arrayOfHt.length + 1);
//            arrayOfHt2[0][0] = numberHT;

        } else {
            System.out.println(" !!! HomeTask with number: " + numberHT + " has already added into to Student with Id" + this.getId() + " !!! ");
        }
    }




    public static int[][] copyArr(final int[][] array) {
        if (array != null) {
            final int[][] copy = new int[array.length + 1 ][];

            for (int i = 0; i < array.length; i++) {
                final int[] row = array[i];

                copy[i] = new int[row.length];
                System.arraycopy(row, 0, copy[i], 0, row.length);
            }

            return copy;
        }

        return null;
    }
}