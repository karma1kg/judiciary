package com.spring.mvc.judiciary.entity;

import javax.persistence.*;

/**
 * Created by Sonam Tobgay on 2/28/2021.
 */
@Entity
@Table(name = "t_mc_husbands_details")
public class HusbandMCDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_ID")
    private int hId;

    @Column(name = "MC_ID")
    private Integer mcNo;

    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "H_CID")
    private String cidNo;

    @Column(name = "H_NAME")
    private String name;

    @Column(name = "H_DOB")
    private String dob;

    @Column(name = "H_GENDER")
    private String gender;

    @Column(name = "H_FATHERS_NAME")
    private String fatherName;

    @Column(name = "H_MOTHERS_NAME")
    private String motherName;

    @Column(name = "H_THARM_NO")
    private String tharmNo;

    @Column(name = "H_HOUSE_NO")
    private String houseNo;

    @Column(name = "H_FORM")
    private String formId;

    @Column(name = "H_DZONGKHAG_ID")
    private Integer dzongkhagId;

    @Column(name = "H_DZONGKHAG_NAME")
    private String dzongkhagNameBh;

    @Column(name = "H_GEWOG_ID")
    private Integer gewogId;

    @Column(name = "H_GEWOG_NAME")
    private String gewogNameBh;

    @Column(name = "H_VILLAGE_ID")
    private Integer villageId;

    @Column(name = "H_VILLAGE_NAME")
    private String villageNameBh;

    @Column(name = "H_NATIONALITY")
    private String nationality;

    @Column(name = "H_COUNTRY")
    private String country;

    @Column(name = "H_ADDRESS")
    private String address;

    @Column(name = "CENSUS_NO")
    private String censusNo;

    @Column(name = "APPLICATION_NO_DZO")
    private String applicationNoDzo;

    @Column(name = "JUDGEMENT_NO_DZO")
    private String judgementNoDzo;

    @Column(name = "JUDGEMENT_DATE_DZO")
    private String judgementDateDzo;

    @Column(name = "LUNAR_DATE")
    private String lunarDate;

    @Column(name = "LAWYER")
    private String lawyerNameDzo;

    //setter and getter region


    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public Integer getMcNo() {
        return mcNo;
    }

    public void setMcNo(Integer mcNo) {
        this.mcNo = mcNo;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getTharmNo() {
        return tharmNo;
    }

    public void setTharmNo(String tharmNo) {
        this.tharmNo = tharmNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Integer getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(Integer dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public String getDzongkhagNameBh() {
        return dzongkhagNameBh;
    }

    public void setDzongkhagNameBh(String dzongkhagNameBh) {
        this.dzongkhagNameBh = dzongkhagNameBh;
    }

    public Integer getGewogId() {
        return gewogId;
    }

    public void setGewogId(Integer gewogId) {
        this.gewogId = gewogId;
    }

    public String getGewogNameBh() {
        return gewogNameBh;
    }

    public void setGewogNameBh(String gewogNameBh) {
        this.gewogNameBh = gewogNameBh;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageNameBh() {
        return villageNameBh;
    }

    public void setVillageNameBh(String villageNameBh) {
        this.villageNameBh = villageNameBh;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCensusNo() {
        return censusNo;
    }

    public void setCensusNo(String censusNo) {
        this.censusNo = censusNo;
    }

    public String getApplicationNoDzo() {
        return applicationNoDzo;
    }

    public void setApplicationNoDzo(String applicationNoDzo) {
        this.applicationNoDzo = applicationNoDzo;
    }

    public String getJudgementNoDzo() {
        return judgementNoDzo;
    }

    public void setJudgementNoDzo(String judgementNoDzo) {
        this.judgementNoDzo = judgementNoDzo;
    }

    public String getJudgementDateDzo() {
        return judgementDateDzo;
    }

    public void setJudgementDateDzo(String judgementDateDzo) {
        this.judgementDateDzo = judgementDateDzo;
    }

    public String getLunarDate() {
        return lunarDate;
    }

    public void setLunarDate(String lunarDate) {
        this.lunarDate = lunarDate;
    }

    public String getLawyerNameDzo() {
        return lawyerNameDzo;
    }

    public void setLawyerNameDzo(String lawyerNameDzo) {
        this.lawyerNameDzo = lawyerNameDzo;
    }
}
