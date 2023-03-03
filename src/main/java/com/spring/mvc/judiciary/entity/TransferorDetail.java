package com.spring.mvc.judiciary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/16/2020.
 */
@Entity
@Table(name = "t_transferor_details")
public class TransferorDetail {

    @Id
    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "NAME")
    private String transferorApplicantName;

    @Column(name = "CID")
    private String transferorApplicantCid;

    @Column(name = "DOB")
    private Date transferorApplicantDob;

    @Column(name = "GENDER")
    private String transferorGender;

    @Column(name = "FATHERS_NAME")
    private String transferorFathersName;

    @Column(name = "DZONGKHAG_ID")
    private Integer transferorDzongkhagId;

    @Column(name = "GEWOG_ID")
    private Integer transferorGewogId;

    @Column(name = "VILLAGE_ID")
    private Integer transferorVillageId;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "ACCOUNT_NO")
    private String accNo;

    @Column(name = "THARM_NO")
    private String transferorTharmNo;

    @Column(name = "HOUSE_NO")
    private String transferorHouseNo;
    //endregion

    //setter and getter region

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getTransferorApplicantName() {
        return transferorApplicantName;
    }

    public void setTransferorApplicantName(String transferorApplicantName) {
        this.transferorApplicantName = transferorApplicantName;
    }

    public String getTransferorApplicantCid() {
        return transferorApplicantCid;
    }

    public void setTransferorApplicantCid(String transferorApplicantCid) {
        this.transferorApplicantCid = transferorApplicantCid;
    }

    public Date getTransferorApplicantDob() {
        return transferorApplicantDob;
    }

    public void setTransferorApplicantDob(Date transferorApplicantDob) {
        this.transferorApplicantDob = transferorApplicantDob;
    }

    public String getTransferorGender() {
        return transferorGender;
    }

    public void setTransferorGender(String transferorGender) {
        this.transferorGender = transferorGender;
    }

    public String getTransferorFathersName() {
        return transferorFathersName;
    }

    public void setTransferorFathersName(String transferorFathersName) {
        this.transferorFathersName = transferorFathersName;
    }

    public Integer getTransferorDzongkhagId() {
        return transferorDzongkhagId;
    }

    public void setTransferorDzongkhagId(Integer transferorDzongkhagId) {
        this.transferorDzongkhagId = transferorDzongkhagId;
    }

    public Integer getTransferorGewogId() {
        return transferorGewogId;
    }

    public void setTransferorGewogId(Integer transferorGewogId) {
        this.transferorGewogId = transferorGewogId;
    }

    public Integer getTransferorVillageId() {
        return transferorVillageId;
    }

    public void setTransferorVillageId(Integer transferorVillageId) {
        this.transferorVillageId = transferorVillageId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getTransferorTharmNo() {
        return transferorTharmNo;
    }

    public void setTransferorTharmNo(String transferorTharmNo) {
        this.transferorTharmNo = transferorTharmNo;
    }

    public String getTransferorHouseNo() {
        return transferorHouseNo;
    }

    public void setTransferorHouseNo(String transferorHouseNo) {
        this.transferorHouseNo = transferorHouseNo;
    }
}
