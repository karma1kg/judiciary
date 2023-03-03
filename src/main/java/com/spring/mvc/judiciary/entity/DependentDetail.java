package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/13/2020.
 */
@Entity
@Table(name = "t_dependent_table")
public class DependentDetail {

    @Id
    @Column(name = "APPL_ID")
    private String applicationNo;

    @Column(name = "NAME")
    private String donorDepName;

    @Column(name = "CID")
    private String donorDepCid;

    @Column(name = "DOB")
    private Date donorDepDob;

    @Column(name = "GENDER")
    private String donorDepGender;

    @Column(name = "FATHERS_NAME")
    private String donorDepFathersName;

    @Column(name = "DZONGKHAG_ID")
    private Integer donorDepDzongkhagId;

    @Column(name = "GEWOG_ID")
    private Integer donorDepGewogId;

    @Column(name = "VILLAGE_ID")
    private Integer donorDepVillageId;

    @Column(name = "RELATIONSHIP")
    private Integer depRelationship;
    //endregion

    //region setters and getters

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getDonorDepName() {
        return donorDepName;
    }

    public void setDonorDepName(String donorDepName) {
        this.donorDepName = donorDepName;
    }

    public String getDonorDepCid() {
        return donorDepCid;
    }

    public void setDonorDepCid(String donorDepCid) {
        this.donorDepCid = donorDepCid;
    }

    public Date getDonorDepDob() {
        return donorDepDob;
    }

    public void setDonorDepDob(Date donorDepDob) {
        this.donorDepDob = donorDepDob;
    }

    public String getDonorDepGender() {
        return donorDepGender;
    }

    public void setDonorDepGender(String donorDepGender) {
        this.donorDepGender = donorDepGender;
    }

    public String getDonorDepFathersName() {
        return donorDepFathersName;
    }

    public void setDonorDepFathersName(String donorDepFathersName) {
        this.donorDepFathersName = donorDepFathersName;
    }

    public Integer getDonorDepDzongkhagId() {
        return donorDepDzongkhagId;
    }

    public void setDonorDepDzongkhagId(Integer donorDepDzongkhagId) {
        this.donorDepDzongkhagId = donorDepDzongkhagId;
    }

    public Integer getDonorDepGewogId() {
        return donorDepGewogId;
    }

    public void setDonorDepGewogId(Integer donorDepGewogId) {
        this.donorDepGewogId = donorDepGewogId;
    }

    public Integer getDonorDepVillageId() {
        return donorDepVillageId;
    }

    public void setDonorDepVillageId(Integer donorDepVillageId) {
        this.donorDepVillageId = donorDepVillageId;
    }

    public Integer getDepRelationship() {
        return depRelationship;
    }

    public void setDepRelationship(Integer depRelationship) {
        this.depRelationship = depRelationship;
    }
}
