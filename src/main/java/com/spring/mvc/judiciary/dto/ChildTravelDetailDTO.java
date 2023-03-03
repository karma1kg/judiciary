package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/12/2020.
 */
public class ChildTravelDetailDTO {

    //private variable region
    private String applicationNo;
    private Date childDob;
    private String childName;
    private String childGender;
    private int relationship;
    private String travelPlace;

    /*Biological Father Details*/
    private String orgFatherCid;
    private String orgFatherName;
    private String orgFatherFathersName;
    private int orgFatherDzongkhagId;
    private int orgFatherVillageId;
    private int orgFatherGewogId;
    private String orgFatherHouseNo;
    private String orgFatherTharmNo;

    /*Biological Mother Details*/
    private String orgMotherCid;
    private String orgMotherName;
    private String orgMotherFathersName;
    private int orgMotherDzongkhagId;
    private int orgMotherVillageId;
    private int orgMotherGewogId;
    private String orgMotherHouseNo;
    private String orgMotherTharmNo;

    //setter and getter region

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Date getChildDob() {
        return childDob;
    }

    public void setChildDob(Date childDob) {
        this.childDob = childDob;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public String getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(String travelPlace) {
        this.travelPlace = travelPlace;
    }

    public String getOrgFatherCid() {
        return orgFatherCid;
    }

    public void setOrgFatherCid(String orgFatherCid) {
        this.orgFatherCid = orgFatherCid;
    }

    public String getOrgFatherName() {
        return orgFatherName;
    }

    public void setOrgFatherName(String orgFatherName) {
        this.orgFatherName = orgFatherName;
    }

    public String getOrgFatherFathersName() {
        return orgFatherFathersName;
    }

    public void setOrgFatherFathersName(String orgFatherFathersName) {
        this.orgFatherFathersName = orgFatherFathersName;
    }

    public int getOrgFatherDzongkhagId() {
        return orgFatherDzongkhagId;
    }

    public void setOrgFatherDzongkhagId(int orgFatherDzongkhagId) {
        this.orgFatherDzongkhagId = orgFatherDzongkhagId;
    }

    public int getOrgFatherVillageId() {
        return orgFatherVillageId;
    }

    public void setOrgFatherVillageId(int orgFatherVillageId) {
        this.orgFatherVillageId = orgFatherVillageId;
    }

    public int getOrgFatherGewogId() {
        return orgFatherGewogId;
    }

    public void setOrgFatherGewogId(int orgFatherGewogId) {
        this.orgFatherGewogId = orgFatherGewogId;
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

    public String getOrgMotherCid() {
        return orgMotherCid;
    }

    public void setOrgMotherCid(String orgMotherCid) {
        this.orgMotherCid = orgMotherCid;
    }

    public String getOrgMotherName() {
        return orgMotherName;
    }

    public void setOrgMotherName(String orgMotherName) {
        this.orgMotherName = orgMotherName;
    }

    public String getOrgMotherFathersName() {
        return orgMotherFathersName;
    }

    public void setOrgMotherFathersName(String orgMotherFathersName) {
        this.orgMotherFathersName = orgMotherFathersName;
    }

    public int getOrgMotherDzongkhagId() {
        return orgMotherDzongkhagId;
    }

    public void setOrgMotherDzongkhagId(int orgMotherDzongkhagId) {
        this.orgMotherDzongkhagId = orgMotherDzongkhagId;
    }

    public int getOrgMotherVillageId() {
        return orgMotherVillageId;
    }

    public void setOrgMotherVillageId(int orgMotherVillageId) {
        this.orgMotherVillageId = orgMotherVillageId;
    }

    public int getOrgMotherGewogId() {
        return orgMotherGewogId;
    }

    public void setOrgMotherGewogId(int orgMotherGewogId) {
        this.orgMotherGewogId = orgMotherGewogId;
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
}
