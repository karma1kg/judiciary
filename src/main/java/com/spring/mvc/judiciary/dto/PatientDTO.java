package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/24/2021.
 */
public class PatientDTO {

    private String applicationNo;
    private String patientCid;
    private Date patientDob;
    private String patientName;
    private String patientGender;
    private String patientFathersName;
    private Integer patientDzongkhagId;
    private Integer patientVillageId;
    private Integer patientGewogId;
    private String patientHouseNo;
    private String patientTharmNo;
    private Integer patientDonorRelationship;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getPatientCid() {
        return patientCid;
    }

    public void setPatientCid(String patientCid) {
        this.patientCid = patientCid;
    }

    public Date getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(Date patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientFathersName() {
        return patientFathersName;
    }

    public void setPatientFathersName(String patientFathersName) {
        this.patientFathersName = patientFathersName;
    }

    public Integer getPatientDzongkhagId() {
        return patientDzongkhagId;
    }

    public void setPatientDzongkhagId(Integer patientDzongkhagId) {
        this.patientDzongkhagId = patientDzongkhagId;
    }

    public Integer getPatientVillageId() {
        return patientVillageId;
    }

    public void setPatientVillageId(Integer patientVillageId) {
        this.patientVillageId = patientVillageId;
    }

    public Integer getPatientGewogId() {
        return patientGewogId;
    }

    public void setPatientGewogId(Integer patientGewogId) {
        this.patientGewogId = patientGewogId;
    }

    public String getPatientHouseNo() {
        return patientHouseNo;
    }

    public void setPatientHouseNo(String patientHouseNo) {
        this.patientHouseNo = patientHouseNo;
    }

    public String getPatientTharmNo() {
        return patientTharmNo;
    }

    public void setPatientTharmNo(String patientTharmNo) {
        this.patientTharmNo = patientTharmNo;
    }

    public Integer getPatientDonorRelationship() {
        return patientDonorRelationship;
    }

    public void setPatientDonorRelationship(Integer patientDonorRelationship) {
        this.patientDonorRelationship = patientDonorRelationship;
    }
}
