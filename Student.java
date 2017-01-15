package HomeTask4_classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by adminnt on 15.01.17.
 */
public class Student {

    UUID id;
    private String lastName;
    private String fisrtName;
    private String middleName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String documentType;
    private String documentNumber;
    private int numberOfFaculty;
    private int numberOfCource;
    private String groupNumber;

    public int maxCource;
    private final int incrementOfCource = 1;

    public Student(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {
        UUID uuid = UUID.randomUUID();

        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.documentType = docType;
        this.documentNumber = docNumber;
        this.id = uuid;
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

    public int getNumberOfFaculty() {
        return numberOfFaculty;
    }

    public int getNumberOfCource() {
        return numberOfCource;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public int getMaxCource() {
        return maxCource;
    }

    public int getIncrementOfCource() {
        return incrementOfCource;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberOfFaculty(int numberOfFaculty) {
        this.numberOfFaculty = numberOfFaculty;
    }

    public void setNumberOfCource(int numberOfCource) {
        this.numberOfCource = numberOfCource;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void transferToNextCourse() {

        if (numberOfCource + incrementOfCource <= maxCource) {
            numberOfCource += incrementOfCource;
        }

    }

    @Override // set  by myself
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //("yyyy-MM-dd");

        String result = "student ID = " + getId() + "; Last Name = " + getLastName() + "; First Name = " + getFisrtName() +
                "; Middle Name = " + getMiddleName() + "; Birthdate = " + formatter.format(getBirthDate()) + "; Document =  "
                + getDocumentType() + "; Serie = " + getDocumentNumber() + "; Email = " + getEmail() +
                "; Phone number = " + getPhoneNumber() + "; Faculty = " + getNumberOfFaculty();

        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this instanceof Object) return true;
        if (this.getClass() != o.getClass()) return false;


        Student s = (Student) o;
        if (this.id != s.id) return false;
        if (this.fisrtName != s.fisrtName) return false;
        if (this.lastName != s.lastName) return false;
        if (this. middleName != s.middleName) return false;
        if (this.birthDate != s.birthDate) return false;
        if (this.documentType != s.documentType) return false;
        if (this.documentNumber != s.documentNumber) return false;
        if (this.email == null) return s.email == null;
        if (this.email != s.email) return false;
        if (this.phoneNumber == null) return s.phoneNumber == null;
        if (this.phoneNumber != s.phoneNumber) return false;
        if (this.numberOfFaculty != s.numberOfFaculty) return false;
        if (this.numberOfCource != s.numberOfCource) return false;
        if (this.groupNumber == null) return s.groupNumber==null;
        if (this.groupNumber != s.groupNumber) return false;

        return true;
    }



}
