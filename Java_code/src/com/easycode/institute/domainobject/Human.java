package com.easycode.institute.domainobject;

import com.easycode.institute.interfaces.LeaveTheInstitute;

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

    public Human() {
    }

    public Human(String lastName, String fisrtName, String middleName, Date birthDate, String docType, String docNumber) {

        this.firstName = fisrtName;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


