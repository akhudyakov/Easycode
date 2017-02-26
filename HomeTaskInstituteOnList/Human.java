package HomeTaskInstituteOnList;

import java.util.Date;

/**
 * Created by adminnt on 22.01.17.
 */
public abstract class Human implements LeaveTheInstitute {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private String documentType;
    private String documentNumber;


    public Human (String lastName, String firstName, String middleName, Date birthDate, String docType, String docNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.documentType = docType;
        this.documentNumber = docNumber;
    }

    public String getFirstName() {
        return firstName;
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


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


