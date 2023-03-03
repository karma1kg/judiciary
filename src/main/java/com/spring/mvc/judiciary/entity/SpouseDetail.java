package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/3/2020.
 */
@Entity
@Table(name = "t_spouse_dtls")
public class SpouseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPOUSE_DTLS_ID")
    private Integer spouseId;

    @Column(name = "SRP_No")
    private String srpNo;

    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "CID")
    private String cid;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "DZONGKHAG_ID")
    private Integer dzongkhagId;

    @Column(name = "FATHERS_NAME")
    private String fatherName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "GEWOG_ID")
    private Integer gewogId;

    @Column(name = "HOUSE_NO")
    private String houseNo;

    @Column(name = "MOTHERS_NAME")
    private String motherName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "Religion")
    private Integer religion;

    @Column(name = "THARM_NO")
    private String tharmNo;

    @Column(name = "VILLAGE_ID")
    private Integer villageId;

    @Column(name="Marital_Status_Id")
    private String marital_Status_Id;

    public Integer getSpouseId() {
        return spouseId;
    }

    public void setSpouseId(Integer spouseId) {
        this.spouseId = spouseId;
    }

    public String getSrpNo() {
        return srpNo;
    }

    public void setSrpNo(String srpNo) {
        this.srpNo = srpNo;
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
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(Integer dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
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

    public Integer getReligion() {
        return religion;
    }

    public void setReligion(Integer religion) {
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

    public String getMarital_Status_Id() {
        return marital_Status_Id;
    }

    public void setMarital_Status_Id(String marital_Status_Id) {
        this.marital_Status_Id = marital_Status_Id;
    }
}
