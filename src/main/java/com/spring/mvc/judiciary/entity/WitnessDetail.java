package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/12/2020.
 */
@Entity
@Table(name = "t_witness_details")
public class WitnessDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WITNESS_ID")
    private Integer witnessId;

    @Column(name = "APPL_ID")
    private String applicationNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CID")
    private String cid;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "FATHERS_NAME")
    private String fatherName;

    @Column(name = "DZONGKHAG_ID")
    private Integer dzongkhagId;

    @Column(name = "GEWOG_ID")
    private Integer gewogId;

    @Column(name = "VILLAGE_ID")
    private Integer villageId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "WITHESS_TYPE_ID")
    private Integer witnessTypeId;

    //setter and getter region


    public Integer getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(Integer witnessId) {
        this.witnessId = witnessId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(Integer dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public Integer getGewogId() {
        return gewogId;
    }

    public void setGewogId(Integer gewogId) {
        this.gewogId = gewogId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getWitnessTypeId() {
        return witnessTypeId;
    }

    public void setWitnessTypeId(Integer witnessTypeId) {
        this.witnessTypeId = witnessTypeId;
    }
}
