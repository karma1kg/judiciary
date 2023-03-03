package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by kg on 9/8/2022.
 */
public class HouseholdDetailsDTO {
    private String fullName;
    private String cid;
    private String maritalStatus;
    private String occupation;
    private Date dob;
    private String nationality;
    private String fatherCID;
    private String fatherName;
    private String fatherNationality;
    private String motherCID;
    private String motherName;
    private String motherNationality;
    private String gender;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFatherCID() {
        return fatherCID;
    }

    public void setFatherCID(String fatherCID) {
        this.fatherCID = fatherCID;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherNationality() {
        return fatherNationality;
    }

    public void setFatherNationality(String fatherNationality) {
        this.fatherNationality = fatherNationality;
    }

    public String getMotherCID() {
        return motherCID;
    }

    public void setMotherCID(String motherCID) {
        this.motherCID = motherCID;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherNationality() {
        return motherNationality;
    }

    public void setMotherNationality(String motherNationality) {
        this.motherNationality = motherNationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
