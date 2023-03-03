package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/24/2021.
 */
public class DonorDepDTO {

    private String applicationNo;
    private String donorDepCid;
    private Date donorDepDob;
    private String donorDepName;
    private String donorDepGender;
    private String donorDepFathersName;
    private Integer donorDepDzongkhagId;
    private Integer donorDepVillageId;
    private Integer donorDepGewogId;
    private String donorDepHouseNo;
    private String donorDepTharmNo;
    private Integer depRelationship;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
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

    public String getDonorDepName() {
        return donorDepName;
    }

    public void setDonorDepName(String donorDepName) {
        this.donorDepName = donorDepName;
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

    public Integer getDonorDepVillageId() {
        return donorDepVillageId;
    }

    public void setDonorDepVillageId(Integer donorDepVillageId) {
        this.donorDepVillageId = donorDepVillageId;
    }

    public Integer getDonorDepGewogId() {
        return donorDepGewogId;
    }

    public void setDonorDepGewogId(Integer donorDepGewogId) {
        this.donorDepGewogId = donorDepGewogId;
    }

    public String getDonorDepHouseNo() {
        return donorDepHouseNo;
    }

    public void setDonorDepHouseNo(String donorDepHouseNo) {
        this.donorDepHouseNo = donorDepHouseNo;
    }

    public String getDonorDepTharmNo() {
        return donorDepTharmNo;
    }

    public void setDonorDepTharmNo(String donorDepTharmNo) {
        this.donorDepTharmNo = donorDepTharmNo;
    }

    public Integer getDepRelationship() {
        return depRelationship;
    }

    public void setDepRelationship(Integer depRelationship) {
        this.depRelationship = depRelationship;
    }
}
