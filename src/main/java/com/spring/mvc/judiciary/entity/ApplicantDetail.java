package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/3/2020.
 */
@Entity
@Table(name = "t_applicant_dtls")
public class ApplicantDetail {
    @Id
    @Column(name = "APPLICANT_DTLS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicantId;
    @Column(name = "APPLICATION_NO")
    private String applicationNo;
    @Column(name="CID")
    private String cid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOB")
    private Date applicantDob;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "MOTHER_NAME")
    private String motherName;
    @Column(name = "THARM_NO")
    private String tharmNo;
    @Column(name = "HOUSE_NO")
    private String houseNo;
    @Column(name = "VILLAGE_ID")
    private Integer villageId;
    @Column(name = "GEWOG_ID")
    private Integer gewogId;
    @Column(name = "DZONGKHAG_ID")
    private Integer dzongkhagId;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "Religion")
    private String religion;
   @Column(name = "applicationYear")
    private String applicationYear;
    @Column(name="Marital_Status")
    private String marital_Status;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getDob() {
        return applicantDob;
    }

    public void setDob(Date dob) {
        this.applicantDob = dob;
    }

    public Integer getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(Integer dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGewogId() {
        return gewogId;
    }

    public void setGewogId(Integer gewogId) {
        this.gewogId = gewogId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTharmNo() {
        return tharmNo;
    }

    public void setTharmNo(String tharmNo) {
        this.tharmNo = tharmNo;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Date getApplicantDob() {
        return applicantDob;
    }

    public void setApplicantDob(Date applicantDob) {
        this.applicantDob = applicantDob;
    }

    public String getApplicationYear() {
        return applicationYear;
    }

    public void setApplicationYear(String applicationYear) {
        this.applicationYear = applicationYear;
    }

    public String getMarital_Status() {
        return marital_Status;
    }

    public void setMarital_Status(String marital_Status) {
        this.marital_Status = marital_Status;
    }
}

