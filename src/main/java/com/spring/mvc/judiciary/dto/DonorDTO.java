package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/24/2021.
 */
public class DonorDTO {

    private String applicationNo;
    private String donorCid;
    private Date donorDob;
    private String donorName;
    private String donorGender;
    private String donorFathersName;
    private Integer donorDzongkhagId;
    private Integer donorVillageId;
    private Integer donorGewogId;
    private String donorHouseNo;
    private String donorTharmNo;
    private Integer donorDepRelationship;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
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

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
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

    public Integer getDonorVillageId() {
        return donorVillageId;
    }

    public void setDonorVillageId(Integer donorVillageId) {
        this.donorVillageId = donorVillageId;
    }

    public Integer getDonorGewogId() {
        return donorGewogId;
    }

    public void setDonorGewogId(Integer donorGewogId) {
        this.donorGewogId = donorGewogId;
    }

    public String getDonorHouseNo() {
        return donorHouseNo;
    }

    public void setDonorHouseNo(String donorHouseNo) {
        this.donorHouseNo = donorHouseNo;
    }

    public String getDonorTharmNo() {
        return donorTharmNo;
    }

    public void setDonorTharmNo(String donorTharmNo) {
        this.donorTharmNo = donorTharmNo;
    }

    public Integer getDonorDepRelationship() {
        return donorDepRelationship;
    }

    public void setDonorDepRelationship(Integer donorDepRelationship) {
        this.donorDepRelationship = donorDepRelationship;
    }
}
