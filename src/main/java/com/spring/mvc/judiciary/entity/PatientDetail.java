package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/13/2020.
 */

@Entity
@Table(name = "t_patient_details")
public class PatientDetail {

        //region private variables
        @Id
        @Column(name = "APPL_ID")
        private String applicationNo;

        @Column(name = "NAME")
        private String patientName;

        @Column(name = "CID")
        private String patientCid;

        @Column(name = "DOB")
        private Date patientDob;

        @Column(name = "GENDER")
        private String patientGender;

        @Column(name = "FATHERS_NAME")
        private String patientFathersName;

        @Column(name = "DZONGKHAG_ID")
        private Integer patientDzongkhagId;

        @Column(name = "GEWOG_ID")
        private Integer patientGewogId;

        @Column(name = "VILLAGE_ID")
        private Integer patientVillageId;

        @Column(name = "PATIENT_DONOR_RELATIONSHIP")
        private Integer patientDonorRelationship;
        //endregion

        //region setters and getters

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public Integer getPatientGewogId() {
        return patientGewogId;
    }

    public void setPatientGewogId(Integer patientGewogId) {
        this.patientGewogId = patientGewogId;
    }

    public Integer getPatientVillageId() {
        return patientVillageId;
    }

    public void setPatientVillageId(Integer patientVillageId) {
        this.patientVillageId = patientVillageId;
    }

    public Integer getPatientDonorRelationship() {
        return patientDonorRelationship;
    }

    public void setPatientDonorRelationship(Integer patientDonorRelationship) {
        this.patientDonorRelationship = patientDonorRelationship;
    }
}
