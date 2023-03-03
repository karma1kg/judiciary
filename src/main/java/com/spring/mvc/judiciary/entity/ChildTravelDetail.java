package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 9/5/2019.
 */
@Entity
@Table(name = "t_child_details")
public class ChildTravelDetail {
    //region private variables
    @Id
    @Column(name = "Application_No")
    private String applicationNo;

    @Column(name = "Name")
    private String childName;

    @Column(name = "DoB")
    private Date childDob;

    @Column(name = "Gender")
    private String childGender;

    @Column(name = "Travel_Place")
    private String travelPlace;

    @Column(name = "Father_Name")
    private String orgFatherName;

    @Column(name = "Father_Cid")
    private String orgFatherCid;

    @Column(name = "F_House_No")
    private String orgFatherHouseNo;

    @Column(name = "F_Tharm_No")
    private String orgFatherTharmNo;

    @Column(name = "F_Village_Id")
    private Integer orgFatherVillageId;

    @Column(name = "F_Gewog_Id")
    private Integer orgFatherGewogId;

    @Column(name = "F_Dzongkhag_Id")
    private Integer orgFatherDzongkhagId;

    @Column(name = "Mother_Name")
    private String orgMotherName;

    @Column(name = "Mother_Cid")
    private String orgMotherCid;

    @Column(name = "M_House_No")
    private String orgMotherHouseNo;

    @Column(name = "M_Tharm_No")
    private String orgMotherTharmNo;

    @Column(name = "M_Village_Id")
    private Integer orgMotherVillageId;

    @Column(name = "M_Gewog_Id")
    private Integer orgMotherGewogId;

    @Column(name = "M_Dzongkhag_Id")
    private Integer orgMotherDzongkhagId;

    @Column(name = "A_Relationship")
    private Integer relationship;
    //endregion

    //region setters and getters

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Date getChildDob() {
        return childDob;
    }

    public void setChildDob(Date childDob) {
        this.childDob = childDob;
    }

    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    public String getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(String travelPlace) {
        this.travelPlace = travelPlace;
    }

    public String getOrgFatherName() {
        return orgFatherName;
    }

    public void setOrgFatherName(String orgFatherName) {
        this.orgFatherName = orgFatherName;
    }

    public String getOrgFatherCid() {
        return orgFatherCid;
    }

    public void setOrgFatherCid(String orgFatherCid) {
        this.orgFatherCid = orgFatherCid;
    }

    public String getOrgFatherHouseNo() {
        return orgFatherHouseNo;
    }

    public void setOrgFatherHouseNo(String orgFatherHouseNo) {
        this.orgFatherHouseNo = orgFatherHouseNo;
    }

    public String getOrgFatherTharmNo() {
        return orgFatherTharmNo;
    }

    public void setOrgFatherTharmNo(String orgFatherTharmNo) {
        this.orgFatherTharmNo = orgFatherTharmNo;
    }

    public Integer getOrgFatherVillageId() {
        return orgFatherVillageId;
    }

    public void setOrgFatherVillageId(Integer orgFatherVillageId) {
        this.orgFatherVillageId = orgFatherVillageId;
    }

    public Integer getOrgFatherGewogId() {
        return orgFatherGewogId;
    }

    public void setOrgFatherGewogId(Integer orgFatherGewogId) {
        this.orgFatherGewogId = orgFatherGewogId;
    }

    public Integer getOrgFatherDzongkhagId() {
        return orgFatherDzongkhagId;
    }

    public void setOrgFatherDzongkhagId(Integer orgFatherDzongkhagId) {
        this.orgFatherDzongkhagId = orgFatherDzongkhagId;
    }

    public String getOrgMotherName() {
        return orgMotherName;
    }

    public void setOrgMotherName(String orgMotherName) {
        this.orgMotherName = orgMotherName;
    }

    public String getOrgMotherCid() {
        return orgMotherCid;
    }

    public void setOrgMotherCid(String orgMotherCid) {
        this.orgMotherCid = orgMotherCid;
    }

    public String getOrgMotherHouseNo() {
        return orgMotherHouseNo;
    }

    public void setOrgMotherHouseNo(String orgMotherHouseNo) {
        this.orgMotherHouseNo = orgMotherHouseNo;
    }

    public String getOrgMotherTharmNo() {
        return orgMotherTharmNo;
    }

    public void setOrgMotherTharmNo(String orgMotherTharmNo) {
        this.orgMotherTharmNo = orgMotherTharmNo;
    }

    public Integer getOrgMotherVillageId() {
        return orgMotherVillageId;
    }

    public void setOrgMotherVillageId(Integer orgMotherVillageId) {
        this.orgMotherVillageId = orgMotherVillageId;
    }

    public Integer getOrgMotherGewogId() {
        return orgMotherGewogId;
    }

    public void setOrgMotherGewogId(Integer orgMotherGewogId) {
        this.orgMotherGewogId = orgMotherGewogId;
    }

    public Integer getOrgMotherDzongkhagId() {
        return orgMotherDzongkhagId;
    }

    public void setOrgMotherDzongkhagId(Integer orgMotherDzongkhagId) {
        this.orgMotherDzongkhagId = orgMotherDzongkhagId;
    }

    public Integer getRelationship() {
        return relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    //endregion
}
