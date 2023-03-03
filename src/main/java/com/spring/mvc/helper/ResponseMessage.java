package com.spring.mvc.helper;

import java.util.Date;

/**
 * Created by N-Zepa on 17-Jun-18.
 */
public class ResponseMessage {
    //region private variables
    private Integer responseStatus;
    private String responseText;
    private String applicationNumber;
    private String rejectReason;
    private String rejectOthers;
    private String rejectAttest;
    private String serviceName;
    private Integer incorrectType;
    private String courtName;
    private String mobileNo;
    private String emailId;
    private Date appDate;
    private String appoinmentDateApprove;
    private String appoinmentTimeApprove;
    private Object responseDTO;
    private Object applicantDTO;
    private Object spouseDTO;
    private Object witness1DTO;
    private Object witness2DTO;
    private Object childDTO;
    private Object patientDTO;
    private Object donorDTO;
    private Object donorDepDTO;
    private Object motherDTO;
    private Object fatherDTO;
    private Object transferorDTO;
    private Object childTravelDetailDTO;
    private String applicantName;
    private String applicantDobh;
    private String nationality;
    private String cidNo;
    private String censusFormNo;
    private String fatherName;
    private String motherName;
    private String tharmNo;
    private String houseNo;
    private String dzongkhagName;
    private String gewogName;
    private String villageName;
    private String spouseName;
    private String spouseApplicantDobBh;
    private String spouseNationality;
    private String spouseCensusFormNo;
    private String spouseCidNo;
    private String spouseFathersName;
    private String spouseMothersName;
    private String spouseTharmNo;
    private String spouseHouseNo;
    private String spouseDzongkhagNameBh;
    private String spouseGewogNameBh;
    private String spouseVillageNameBh;
    private String gender;
    private String spouseGender;
    private String applicant;
    private String spouseApplicant;
    private String receipt_No;
    private Integer receipt_Amount;
    private Date receiptDate;
    private String houseHold_No;
    //endregion
    public ResponseMessage() {

    }

    //region setters and getters


    public String getAppoinmentDateApprove() {
        return appoinmentDateApprove;
    }

    public void setAppoinmentDateApprove(String appoinmentDateApprove) {
        this.appoinmentDateApprove = appoinmentDateApprove;
    }

    public String getAppoinmentTimeApprove() {
        return appoinmentTimeApprove;
    }

    public void setAppoinmentTimeApprove(String appoinmentTimeApprove) {
        this.appoinmentTimeApprove = appoinmentTimeApprove;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Object getResponseDTO() {
        return responseDTO;
    }

    public void setResponseDTO(Object responseDTO) {
        this.responseDTO = responseDTO;
    }

    public Object getApplicantDTO() {
        return applicantDTO;
    }

    public void setApplicantDTO(Object applicantDTO) {
        this.applicantDTO = applicantDTO;
    }

    public Object getSpouseDTO() {
        return spouseDTO;
    }

    public void setSpouseDTO(Object spouseDTO) {
        this.spouseDTO = spouseDTO;
    }

    public Object getWitness1DTO() {
        return witness1DTO;
    }

    public void setWitness1DTO(Object witness1DTO) {
        this.witness1DTO = witness1DTO;
    }

    public Object getWitness2DTO() {
        return witness2DTO;
    }

    public void setWitness2DTO(Object witness2DTO) {
        this.witness2DTO = witness2DTO;
    }

    public Object getChildDTO() {
        return childDTO;
    }

    public void setChildDTO(Object childDTO) {
        this.childDTO = childDTO;
    }

    public Object getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(Object patientDTO) {
        this.patientDTO = patientDTO;
    }

    public Object getDonorDTO() {
        return donorDTO;
    }

    public void setDonorDTO(Object donorDTO) {
        this.donorDTO = donorDTO;
    }

    public Object getDonorDepDTO() {
        return donorDepDTO;
    }

    public void setDonorDepDTO(Object donorDepDTO) {
        this.donorDepDTO = donorDepDTO;
    }

    public Object getMotherDTO() {
        return motherDTO;
    }

    public void setMotherDTO(Object motherDTO) {
        this.motherDTO = motherDTO;
    }

    public Object getFatherDTO() {
        return fatherDTO;
    }

    public void setFatherDTO(Object fatherDTO) {
        this.fatherDTO = fatherDTO;
    }

    public Object getTransferorDTO() {
        return transferorDTO;
    }

    public void setTransferorDTO(Object transferorDTO) {
        this.transferorDTO = transferorDTO;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getIncorrectType() {
        return incorrectType;
    }

    public void setIncorrectType(Integer incorrectType) {
        this.incorrectType = incorrectType;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Object getChildTravelDetailDTO() {
        return childTravelDetailDTO;
    }

    public void setChildTravelDetailDTO(Object childTravelDetailDTO) {
        this.childTravelDetailDTO = childTravelDetailDTO;
    }

    public String getRejectOthers() {
        return rejectOthers;
    }

    public void setRejectOthers(String rejectOthers) {
        this.rejectOthers = rejectOthers;
    }
//endregion

    public String getRejectAttest() {
        return rejectAttest;
    }

    public void setRejectAttest(String rejectAttest) {
        this.rejectAttest = rejectAttest;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }



    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    public String getCensusFormNo() {
        return censusFormNo;
    }

    public void setCensusFormNo(String censusFormNo) {
        this.censusFormNo = censusFormNo;
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

    public String getDzongkhagName() {
        return dzongkhagName;
    }

    public void setDzongkhagName(String dzongkhagName) {
        this.dzongkhagName = dzongkhagName;
    }

    public String getGewogName() {
        return gewogName;
    }

    public void setGewogName(String gewogName) {
        this.gewogName = gewogName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseApplicantDobBh() {
        return spouseApplicantDobBh;
    }

    public void setSpouseApplicantDobBh(String spouseApplicantDobBh) {
        this.spouseApplicantDobBh = spouseApplicantDobBh;
    }

    public String getSpouseNationality() {
        return spouseNationality;
    }

    public void setSpouseNationality(String spouseNationality) {
        this.spouseNationality = spouseNationality;
    }

    public String getSpouseCensusFormNo() {
        return spouseCensusFormNo;
    }

    public void setSpouseCensusFormNo(String spouseCensusFormNo) {
        this.spouseCensusFormNo = spouseCensusFormNo;
    }

    public String getSpouseCidNo() {
        return spouseCidNo;
    }

    public void setSpouseCidNo(String spouseCidNo) {
        this.spouseCidNo = spouseCidNo;
    }

    public String getSpouseFathersName() {
        return spouseFathersName;
    }

    public void setSpouseFathersName(String spouseFathersName) {
        this.spouseFathersName = spouseFathersName;
    }

    public String getSpouseMothersName() {
        return spouseMothersName;
    }

    public void setSpouseMothersName(String spouseMothersName) {
        this.spouseMothersName = spouseMothersName;
    }

    public String getSpouseTharmNo() {
        return spouseTharmNo;
    }

    public void setSpouseTharmNo(String spouseTharmNo) {
        this.spouseTharmNo = spouseTharmNo;
    }

    public String getSpouseHouseNo() {
        return spouseHouseNo;
    }

    public void setSpouseHouseNo(String spouseHouseNo) {
        this.spouseHouseNo = spouseHouseNo;
    }

    public String getSpouseDzongkhagNameBh() {
        return spouseDzongkhagNameBh;
    }

    public void setSpouseDzongkhagNameBh(String spouseDzongkhagNameBh) {
        this.spouseDzongkhagNameBh = spouseDzongkhagNameBh;
    }

    public String getSpouseGewogNameBh() {
        return spouseGewogNameBh;
    }

    public void setSpouseGewogNameBh(String spouseGewogNameBh) {
        this.spouseGewogNameBh = spouseGewogNameBh;
    }

    public String getSpouseVillageNameBh() {
        return spouseVillageNameBh;
    }

    public void setSpouseVillageNameBh(String spouseVillageNameBh) {
        this.spouseVillageNameBh = spouseVillageNameBh;
    }

    public String getApplicantDobh() {
        return applicantDobh;
    }

    public void setApplicantDobh(String applicantDobh) {
        this.applicantDobh = applicantDobh;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(String spouseGender) {
        this.spouseGender = spouseGender;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getSpouseApplicant() {
        return spouseApplicant;
    }

    public void setSpouseApplicant(String spouseApplicant) {
        this.spouseApplicant = spouseApplicant;
    }

    public String getReceipt_No() {
        return receipt_No;
    }

    public void setReceipt_No(String receipt_No) {
        this.receipt_No = receipt_No;
    }

    public Integer getReceipt_Amount() {
        return receipt_Amount;
    }

    public void setReceipt_Amount(Integer receipt_Amount) {
        this.receipt_Amount = receipt_Amount;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getHouseHold_No() {
        return houseHold_No;
    }

    public void setHouseHold_No(String houseHold_No) {
        this.houseHold_No = houseHold_No;
    }
}

