package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/13/2020.
 */
@Entity
@Table(name = "t_donor_details")
public class DonorDetail {

    //region private variables
    @Id
    @Column(name = "APPL_ID")
    private String applicationNo;

    @Column(name = "NAME")
    private String donorName;

    @Column(name = "CID")
    private String donorCid;

    @Column(name = "DOB")
    private Date donorDob;

    @Column(name = "GENDER")
    private String donorGender;

    @Column(name = "FATHERS_NAME")
    private String donorFathersName;

    @Column(name = "DZONGKHAG_ID")
    private Integer donorDzongkhagId;

    @Column(name = "GEWOG_ID")
    private Integer donorGewogId;

    @Column(name = "VILLAGE_ID")
    private Integer donorVillageId;

    @Column(name = "RELATIONSHIP")
    private Integer donorPatientRelationship;

    @Column(name = "DONOR_DEP_RELATIONSHIP")
    private Integer donorDepRelationship;
    //endregion

    //region setters and getters

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorCid() {
        return donorCid;
    }

    public void setDonorCid(String donorCid) {
        this.donorCid = donorCid;
    }

    public Date getDonorDob() {
        return donorDob;
    }

    public void setDonorDob(Date donorDob) {
        this.donorDob = donorDob;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(String donorGender) {
        this.donorGender = donorGender;
    }

    public String getDonorFathersName() {
        return donorFathersName;
    }

    public void setDonorFathersName(String donorFathersName) {
        this.donorFathersName = donorFathersName;
    }

    public Integer getDonorDzongkhagId() {
        return donorDzongkhagId;
    }

    public void setDonorDzongkhagId(Integer donorDzongkhagId) {
        this.donorDzongkhagId = donorDzongkhagId;
    }

    public Integer getDonorGewogId() {
        return donorGewogId;
    }

    public void setDonorGewogId(Integer donorGewogId) {
        this.donorGewogId = donorGewogId;
    }

    public Integer getDonorVillageId() {
        return donorVillageId;
    }

    public void setDonorVillageId(Integer donorVillageId) {
        this.donorVillageId = donorVillageId;
    }

    public Integer getDonorPatientRelationship() {
        return donorPatientRelationship;
    }

    public void setDonorPatientRelationship(Integer donorPatientRelationship) {
        this.donorPatientRelationship = donorPatientRelationship;
    }

    public Integer getDonorDepRelationship() {
        return donorDepRelationship;
    }

    public void setDonorDepRelationship(Integer donorDepRelationship) {
        this.donorDepRelationship = donorDepRelationship;
    }
}
