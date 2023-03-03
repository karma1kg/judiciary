package com.spring.mvc.judiciary.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by N-Zepa on 27-Jul-19.
 */
public class ApplicationDetailDTO {
    //region private variables
    private String applicationNo;
    private String srpNo;
    private String applicationYear;
    private Integer serviceSlNo;
    private String remarks;
    private String statusId;
    private String serviceId;
    private List<AppliedDocumentDTO> appliedDocumentDTOs;
    private List<FileAttachmentDTO> fileAttachmentDTOs;
    private List<ApplicantDetailDTO> applicantDetailDTOs;
    private List<SpouseDetailsDTO> spouseDetailsDTOs;
    private List<WitnessDetailDTO> witnessDetailDTOs1;
    private List<ChildMCDTO> childMCDTOs;
    private String serviceName;
    private String statusName;
    private String fullName;
    private String rejectRemarks;
    private Integer paymentDetailId;
    private String documentName;
    private Integer documentId;
    private String indexNo;
    private String examYear;
    private String letterNo;
    private Date letterDate;
    private String incorrectName;
    private Date incorrectDate;
    private Integer incorrectType;
    private Integer incorrectDzongkhagName;
    private Integer incorrectGewogName;
    private Integer incorrectVillageName;
    private String incorrectCidNo;
    private String incorrectOthers;
    private String mcNo;
    private String cmcNo;
    private String hospitalName;
    private String relationship;
    private String docName;
    private Integer lostDocType;
    private Integer courtId;
    private String courtName;
    private Date appoinmentDate;
    private String appoinmentTime;
    private String reason;
    private String createdBy;
    private Date createdDate;
    private String caseNo;
    private String judgementNo;
    private Date judgementDate;
    private String clerk;
    private String lawyer;
    private String receiptNo;
    private String receiptDateOnline;
    private Date receiptDate;
    private Integer receiptAmount;
    private String updatedBy;
    private String printStatus;
    private String paymentCleared;
    private Date updateDate;
    private Date kuenselDate;
    private Integer classType;
    private Integer travelReason;
    private String travelPlace;
    private String childPassportNo;
    private String appPassportNo;
    private String regNo;
    private Date regDate;

    //Report Detail
    private Date fromDate;
    private Date toDate;
    private String total;
 private BigInteger totals;

    //for Applicant Details
    private String applicantDobBh;

    // for Spouse Details
    private String spouseApplicantDobBh;

    //for Applicant Details
    private String address;
    private String cidNo;
    private Date applicantDob;
    private Integer dzongkhagId;
    private String email;
    private String fatherName;
    private String gender;
    private Integer gewogId;
    private String houseNo;
    private String mobileNo;
    private String motherName;
    private String applicantName;
    private String nationality;
    private String religion;
    private String tharmNo;
    private Integer villageId;

    // for Spouse Details
    private String spouseCidNo;
    private Date spouseApplicantDob;
    private String spouseName;
    private String spouseGender;
    private String spouseFathersName;
    private String spouseMothersName;
    private Integer spouseVillageId;
    private Integer spouseDzongkhagId;
    private Integer spouseGewogId;
    private String spouseHouseNo;
    private String spouseTharmNo;
    private String spouseNationality;
    private Integer spouseReligion;

    // Child Details
    private String confirmChild;
    private Date childDob;
    private String childName;
    private String childGender;

    // MALE WITNESS DETAILS
    private String witness1CidNo;
    private String witness1Name;
    private Date w1Dob;
    private String w1Gender;
    private String w1fathersName;
    private String w1mothersName;
    private Integer w1villageId;
    private Integer w1dzongkhagId;
    private Integer w1gewogId;
    private String w1houseNo;
    private String w1tharmNo;

    // FEMALE WITNESS DETAILS
    private String witness2CidNo;
    private String witness2Name;
    private Date w2Dob;
    private String w2gender;
    private String w2fathersName;
    private String w2mothersName;
    private Integer w2villageId;
    private Integer w2GewogId;
    private Integer w2dzongkhagId;

    // WITNESS DETAILS
    /*private String witnessCidNo;
    private String witnessName;
    private Date witnessDob;
    private String witnessGender;
    private String witnessFatherName;
    private String witnessMotherName;
    private Integer witnessVillageId;
    private Integer witnessGewogId;
    private Integer witnessDzongkhagId;*/
    private String witnessTypeId;

    ///ORIGINAL PARENTS RELATED
    /*Biological Father Details*/
    private String orgFatherCid;
    private Date orgFatherDob;
    private String orgFatherName;
    private String orgFatherGender;
    private String orgFatherFathersName;
    private Integer orgFatherDzongkhagId;
    private Integer orgFatherVillageId;
    private Integer orgFatherGewogId;
    private String orgFatherHouseNo;
    private String orgFatherTharmNo;

    /*Biological Mother Details*/
    private String orgMotherCid;
    private Date orgMotherDob;
    private String orgMotherName;
    private String orgMotherGender;
    private String orgMotherFathersName;
    private Integer orgMotherDzongkhagId;
    private Integer orgMotherVillageId;
    private Integer orgMotherGewogId;
    private String orgMotherHouseNo;
    private String orgMotherTharmNo;

    ///FOR KIDNEY TRANSPLANT
//patient
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

    //donor
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

    //donor Dependent Details
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

    //Transferor Details
    private String transferorApplicantCid;
    private Date transferorApplicantDob;
    private String transferorApplicantName;
    private String transferorGender;
    private String transferorFathersName;
    private String transferorMothersName;
    private Integer transferorDzongkhagId;
    private Integer transferorVillageId;
    private Integer transferorGewogId;
    private String transferorHouseNo;
    private String transferorTharmNo;
    private String bankName;
    private String accNo;

    private String lunarDateDzo;
    private String lawyerDzo;
    private String applicationIdDzo;
    private String judgementNoDzo;
    private String dateDzo;
    private String censusFormNo;
    private String spouseCensusFormNo;
    private String gewogName;
    private String dzongkhagName;
    private String villageName;
    private String spouseGewogName;
    private String spouseDzongkhagName;
    private String spouseVillageName;
    private String orgFatherGewogName;
    private String orgFatherDzongkhagName;
    private String orgFatherVillageName;
    private String orgMotherGewogName;
    private String orgMotherDzongkhagName;
    private String orgMotherVillageName;
    private String patientDzongkhagName;
    private String patientVillageName;
    private String patientGewogName;
    private String patientWitnessVillageName;
    private String patientWitness2VillageName;
    private String patientWitnessGewogName;
    private String patientWitness2GewogName;
    private String patientWitnessDzongkhagName;
    private String patientWitness2DzongkhagName;
    private String donorDepDzongkhagName;
    private String donorDepVillageName;
    private String donorDepGewogName;
    private String donorDepWitnessVillageName;
    private String donorDepWitness2VillageName;
    private String donorDepWitnessGewogName;
    private String donorDepWitness2GewogName;
    private String donorDepWitnessDzongkhagName;
    private String donorDepWitness2DzongkhagName;
    private String donorWitnessVillageName;
    private String donorWitness2VillageName;
    private String donorWitnessGewogName;
    private String donorWitness2GewogName;
    private String donorWitnessDzongkhagName;
    private String donorWitness2DzongkhagName;
    private String donorDzongkhagName;
    private String donorVillageName;
    private String donorGewogName;
    private String patientWitnessName;
    private String patientWitness2Name;

    private String applicationFees;
    private String accountHeadCode;
    private String agencyCode;
    private String phoneNo;

    private Integer groupTaskCount;
    private Integer groupTaskCountApprove;
    private Integer myTaskCount;
    private Integer myTaskCountApprove;
    private String w2gewogId;
    private String w2houseNo;
    private String w2tharmNo;
    private String Reject_Reason;

    private List<ReasonDTO> reasonDTOs;
    private Integer rejectReasonId;
    private String marital_status;

    private String receiptDatebh;


    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public Integer getRejectReasonId() {
        return rejectReasonId;
    }

    public void setRejectReasonId(Integer rejectReasonId) {
        this.rejectReasonId = rejectReasonId;
    }

    public Integer getGroupTaskCount() {
        return groupTaskCount;
    }

    public void setGroupTaskCount(Integer groupTaskCount) {
        this.groupTaskCount = groupTaskCount;
    }

    public Integer getGroupTaskCountApprove() {
        return groupTaskCountApprove;
    }

    public void setGroupTaskCountApprove(Integer groupTaskCountApprove) {
        this.groupTaskCountApprove = groupTaskCountApprove;
    }

    public Integer getMyTaskCount() {
        return myTaskCount;
    }

    public void setMyTaskCount(Integer myTaskCount) {
        this.myTaskCount = myTaskCount;
    }

    public Integer getMyTaskCountApprove() {
        return myTaskCountApprove;
    }

    public void setMyTaskCountApprove(Integer myTaskCountApprove) {
        this.myTaskCountApprove = myTaskCountApprove;
    }

    public String getApplicationFees() {
        return applicationFees;
    }

    public void setApplicationFees(String applicationFees) {
        this.applicationFees = applicationFees;
    }

    public String getAccountHeadCode() {
        return accountHeadCode;
    }

    public void setAccountHeadCode(String accountHeadCode) {
        this.accountHeadCode = accountHeadCode;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getLetterNo() {
        return letterNo;
    }

    public void setLetterNo(String letterNo) {
        this.letterNo = letterNo;
    }

    public Date getLetterDate() {
        return letterDate;
    }

    public void setLetterDate(Date letterDate) {
        this.letterDate = letterDate;
    }

    public String getIncorrectName() {
        return incorrectName;
    }

    public void setIncorrectName(String incorrectName) {
        this.incorrectName = incorrectName;
    }

    public Date getIncorrectDate() {
        return incorrectDate;
    }

    public void setIncorrectDate(Date incorrectDate) {
        this.incorrectDate = incorrectDate;
    }

    public Integer getIncorrectType() {
        return incorrectType;
    }

    public void setIncorrectType(Integer incorrectType) {
        this.incorrectType = incorrectType;
    }

    public Integer getIncorrectDzongkhagName() {
        return incorrectDzongkhagName;
    }

    public void setIncorrectDzongkhagName(Integer incorrectDzongkhagName) {
        this.incorrectDzongkhagName = incorrectDzongkhagName;
    }

    public Integer getIncorrectGewogName() {
        return incorrectGewogName;
    }

    public void setIncorrectGewogName(Integer incorrectGewogName) {
        this.incorrectGewogName = incorrectGewogName;
    }

    public Integer getIncorrectVillageName() {
        return incorrectVillageName;
    }

    public void setIncorrectVillageName(Integer incorrectVillageName) {
        this.incorrectVillageName = incorrectVillageName;
    }

    public String getIncorrectCidNo() {
        return incorrectCidNo;
    }

    public void setIncorrectCidNo(String incorrectCidNo) {
        this.incorrectCidNo = incorrectCidNo;
    }

    public String getIncorrectOthers() {
        return incorrectOthers;
    }

    public void setIncorrectOthers(String incorrectOthers) {
        this.incorrectOthers = incorrectOthers;
    }

    public String getMcNo() {
        return mcNo;
    }

    public void setMcNo(String mcNo) {
        this.mcNo = mcNo;
    }

    public String getCmcNo() {
        return cmcNo;
    }

    public void setCmcNo(String cmcNo) {
        this.cmcNo = cmcNo;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Integer getLostDocType() {
        return lostDocType;
    }

    public void setLostDocType(Integer lostDocType) {
        this.lostDocType = lostDocType;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public Date getAppoinmentDate() {
        return appoinmentDate;
    }

    public void setAppoinmentDate(Date appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }

    public String getAppoinmentTime() {
        return appoinmentTime;
    }

    public void setAppoinmentTime(String appoinmentTime) {
        this.appoinmentTime = appoinmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getJudgementNo() {
        return judgementNo;
    }

    public void setJudgementNo(String judgementNo) {
        this.judgementNo = judgementNo;
    }

    public Date getJudgementDate() {
        return judgementDate;
    }

    public void setJudgementDate(Date judgementDate) {
        this.judgementDate = judgementDate;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getReceiptDateOnline() {
        return receiptDateOnline;
    }

    public void setReceiptDateOnline(String receiptDateOnline) {
        this.receiptDateOnline = receiptDateOnline;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Integer receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public String getPaymentCleared() {
        return paymentCleared;
    }

    public void setPaymentCleared(String paymentCleared) {
        this.paymentCleared = paymentCleared;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getKuenselDate() {
        return kuenselDate;
    }

    public void setKuenselDate(Date kuenselDate) {
        this.kuenselDate = kuenselDate;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public Integer getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(Integer travelReason) {
        this.travelReason = travelReason;
    }

    public String getChildPassportNo() {
        return childPassportNo;
    }

    public void setChildPassportNo(String childPassportNo) {
        this.childPassportNo = childPassportNo;
    }

    public String getAppPassportNo() {
        return appPassportNo;
    }

    public void setAppPassportNo(String appPassportNo) {
        this.appPassportNo = appPassportNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getW2gewogId() {
        return w2gewogId;
    }

    public void setW2gewogId(String w2gewogId) {
        this.w2gewogId = w2gewogId;
    }

    public String getSpouseCidNo() {
        return spouseCidNo;
    }

    public void setSpouseCidNo(String spouseCidNo) {
        this.spouseCidNo = spouseCidNo;
    }

    public Date getSpouseApplicantDob() {
        return spouseApplicantDob;
    }

    public void setSpouseApplicantDob(Date spouseApplicantDob) {
        this.spouseApplicantDob = spouseApplicantDob;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(String spouseGender) {
        this.spouseGender = spouseGender;
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

    public Integer getSpouseVillageId() {
        return spouseVillageId;
    }

    public void setSpouseVillageId(Integer spouseVillageId) {
        this.spouseVillageId = spouseVillageId;
    }

    public Integer getSpouseDzongkhagId() {
        return spouseDzongkhagId;
    }

    public void setSpouseDzongkhagId(Integer spouseDzongkhagId) {
        this.spouseDzongkhagId = spouseDzongkhagId;
    }

    public Integer getSpouseGewogId() {
        return spouseGewogId;
    }

    public void setSpouseGewogId(Integer spouseGewogId) {
        this.spouseGewogId = spouseGewogId;
    }

    public String getSpouseHouseNo() {
        return spouseHouseNo;
    }

    public void setSpouseHouseNo(String spouseHouseNo) {
        this.spouseHouseNo = spouseHouseNo;
    }

    public String getSpouseTharmNo() {
        return spouseTharmNo;
    }

    public void setSpouseTharmNo(String spouseTharmNo) {
        this.spouseTharmNo = spouseTharmNo;
    }

    public String getSpouseNationality() {
        return spouseNationality;
    }

    public void setSpouseNationality(String spouseNationality) {
        this.spouseNationality = spouseNationality;
    }


    public Integer getSpouseReligion() {
        return spouseReligion;
    }

    public void setSpouseReligion(Integer spouseReligion) {
        this.spouseReligion = spouseReligion;
    }

    public String getConfirmChild() {
        return confirmChild;
    }

    public void setConfirmChild(String confirmChild) {
        this.confirmChild = confirmChild;
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

    public String getWitness1CidNo() {
        return witness1CidNo;
    }

    public void setWitness1CidNo(String witness1CidNo) {
        this.witness1CidNo = witness1CidNo;
    }

    public String getWitness1Name() {
        return witness1Name;
    }

    public void setWitness1Name(String witness1Name) {
        this.witness1Name = witness1Name;
    }

    public Date getW1Dob() {
        return w1Dob;
    }

    public void setW1Dob(Date w1Dob) {
        this.w1Dob = w1Dob;
    }

    public String getW1Gender() {
        return w1Gender;
    }

    public void setW1Gender(String w1Gender) {
        this.w1Gender = w1Gender;
    }

    public String getW1fathersName() {
        return w1fathersName;
    }

    public void setW1fathersName(String w1fathersName) {
        this.w1fathersName = w1fathersName;
    }

    public String getW1mothersName() {
        return w1mothersName;
    }

    public void setW1mothersName(String w1mothersName) {
        this.w1mothersName = w1mothersName;
    }

    public Integer getW1villageId() {
        return w1villageId;
    }

    public void setW1villageId(Integer w1villageId) {
        this.w1villageId = w1villageId;
    }

    public Integer getW1dzongkhagId() {
        return w1dzongkhagId;
    }

    public void setW1dzongkhagId(Integer w1dzongkhagId) {
        this.w1dzongkhagId = w1dzongkhagId;
    }

    public Integer getW1gewogId() {
        return w1gewogId;
    }

    public void setW1gewogId(Integer w1gewogId) {
        this.w1gewogId = w1gewogId;
    }

    public String getW1houseNo() {
        return w1houseNo;
    }

    public void setW1houseNo(String w1houseNo) {
        this.w1houseNo = w1houseNo;
    }

    public String getW1tharmNo() {
        return w1tharmNo;
    }

    public void setW1tharmNo(String w1tharmNo) {
        this.w1tharmNo = w1tharmNo;
    }

    public String getWitness2CidNo() {
        return witness2CidNo;
    }

    public void setWitness2CidNo(String witness2CidNo) {
        this.witness2CidNo = witness2CidNo;
    }

    public String getWitness2Name() {
        return witness2Name;
    }

    public void setWitness2Name(String witness2Name) {
        this.witness2Name = witness2Name;
    }

    public Date getW2Dob() {
        return w2Dob;
    }

    public void setW2Dob(Date w2Dob) {
        this.w2Dob = w2Dob;
    }

    public String getW2gender() {
        return w2gender;
    }

    public void setW2gender(String w2gender) {
        this.w2gender = w2gender;
    }

    public String getW2fathersName() {
        return w2fathersName;
    }

    public void setW2fathersName(String w2fathersName) {
        this.w2fathersName = w2fathersName;
    }

    public String getW2mothersName() {
        return w2mothersName;
    }

    public void setW2mothersName(String w2mothersName) {
        this.w2mothersName = w2mothersName;
    }

    public Integer getW2villageId() {
        return w2villageId;
    }

    public void setW2villageId(Integer w2villageId) {
        this.w2villageId = w2villageId;
    }

    public Integer getW2dzongkhagId() {
        return w2dzongkhagId;
    }

    public void setW2dzongkhagId(Integer w2dzongkhagId) {
        this.w2dzongkhagId = w2dzongkhagId;
    }

    public String getW2houseNo() {
        return w2houseNo;
    }

    public void setW2houseNo(String w2houseNo) {
        this.w2houseNo = w2houseNo;
    }

    public String getW2tharmNo() {
        return w2tharmNo;
    }

    public void setW2tharmNo(String w2tharmNo) {
        this.w2tharmNo = w2tharmNo;
    }




     //endregion

   /* public String getWitnessCidNo() {
        return witnessCidNo;
    }

    public void setWitnessCidNo(String witnessCidNo) {
        this.witnessCidNo = witnessCidNo;
    }

    public String getWitnessName() {
        return witnessName;
    }

    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    public Date getWitnessDob() {
        return witnessDob;
    }

    public void setWitnessDob(Date witnessDob) {
        this.witnessDob = witnessDob;
    }

    public String getWitnessGender() {
        return witnessGender;
    }

    public void setWitnessGender(String witnessGender) {
        this.witnessGender = witnessGender;
    }

    public String getWitnessFatherName() {
        return witnessFatherName;
    }

    public void setWitnessFatherName(String witnessFatherName) {
        this.witnessFatherName = witnessFatherName;
    }

    public String getWitnessMotherName() {
        return witnessMotherName;
    }

    public void setWitnessMotherName(String witnessMotherName) {
        this.witnessMotherName = witnessMotherName;
    }

    public Integer getWitnessVillageId() {
        return witnessVillageId;
    }

    public void setWitnessVillageId(Integer witnessVillageId) {
        this.witnessVillageId = witnessVillageId;
    }

    public Integer getWitnessGewogId() {
        return witnessGewogId;
    }

    public void setWitnessGewogId(Integer witnessGewogId) {
        this.witnessGewogId = witnessGewogId;
    }

    public Integer getWitnessDzongkhagId() {
        return witnessDzongkhagId;
    }

    public void setWitnessDzongkhagId(Integer witnessDzongkhagId) {
        this.witnessDzongkhagId = witnessDzongkhagId;
    }*/

    public String getWitnessTypeId() {
        return witnessTypeId;
    }

    public void setWitnessTypeId(String witnessTypeId) {
        this.witnessTypeId = witnessTypeId;
    }

    //region setters and getters

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getExamYear() {
        return examYear;
    }

    public void setExamYear(String examYear) {
        this.examYear = examYear;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getSrpNo() {
        return srpNo;
    }

    public void setSrpNo(String srpNo) {
        this.srpNo = srpNo;
    }

    public Integer getServiceSlNo() {
        return serviceSlNo;
    }

    public void setServiceSlNo(Integer serviceSlNo) {
        this.serviceSlNo = serviceSlNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    public Date getApplicantDob() {
        return applicantDob;
    }

    public void setApplicantDob(Date applicantDob) {
        this.applicantDob = applicantDob;
    }

    public Integer getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(Integer dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGewogId() {
        return gewogId;
    }

    public void setGewogId(Integer gewogId) {
        this.gewogId = gewogId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
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

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTharmNo() {
        return tharmNo;
    }

    public void setTharmNo(String tharmNo) {
        this.tharmNo = tharmNo;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }


    public List<AppliedDocumentDTO> getAppliedDocumentDTOs() {
        return appliedDocumentDTOs;
    }

    public void setAppliedDocumentDTOs(List<AppliedDocumentDTO> appliedDocumentDTOs) {
        this.appliedDocumentDTOs = appliedDocumentDTOs;
    }

    public List<FileAttachmentDTO> getFileAttachmentDTOs() {
        return fileAttachmentDTOs;
    }

    public void setFileAttachmentDTOs(List<FileAttachmentDTO> fileAttachmentDTOs) {
        this.fileAttachmentDTOs = fileAttachmentDTOs;
    }

    public List<ApplicantDetailDTO> getApplicantDetailDTOs() {
        return applicantDetailDTOs;
    }

    public void setApplicantDetailDTOs(List<ApplicantDetailDTO> applicantDetailDTOs) {
        this.applicantDetailDTOs = applicantDetailDTOs;
    }

    public List<SpouseDetailsDTO> getSpouseDetailsDTOs() {
        return spouseDetailsDTOs;
    }

    public void setSpouseDetailsDTOs(List<SpouseDetailsDTO> spouseDetailsDTOs) {
        this.spouseDetailsDTOs = spouseDetailsDTOs;
    }

    public List<WitnessDetailDTO> getWitnessDetailDTOs1() {
        return witnessDetailDTOs1;
    }

    public void setWitnessDetailDTOs1(List<WitnessDetailDTO> witnessDetailDTOs1) {
        this.witnessDetailDTOs1 = witnessDetailDTOs1;
    }

    public List<ChildMCDTO> getChildMCDTOs() {
        return childMCDTOs;
    }

    public void setChildMCDTOs(List<ChildMCDTO> childMCDTOs) {
        this.childMCDTOs = childMCDTOs;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRejectRemarks() {
        return rejectRemarks;
    }

    public void setRejectRemarks(String rejectRemarks) {
        this.rejectRemarks = rejectRemarks;
    }

    public Integer getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(Integer paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
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

    public Date getOrgFatherDob() {
        return orgFatherDob;
    }

    public void setOrgFatherDob(Date orgFatherDob) {
        this.orgFatherDob = orgFatherDob;
    }

    public String getOrgFatherName() {
        return orgFatherName;
    }

    public void setOrgFatherName(String orgFatherName) {
        this.orgFatherName = orgFatherName;
    }

    public String getOrgFatherGender() {
        return orgFatherGender;
    }

    public void setOrgFatherGender(String orgFatherGender) {
        this.orgFatherGender = orgFatherGender;
    }

    public String getOrgFatherFathersName() {
        return orgFatherFathersName;
    }

    public void setOrgFatherFathersName(String orgFatherFathersName) {
        this.orgFatherFathersName = orgFatherFathersName;
    }

    public Integer getOrgFatherDzongkhagId() {
        return orgFatherDzongkhagId;
    }

    public void setOrgFatherDzongkhagId(Integer orgFatherDzongkhagId) {
        this.orgFatherDzongkhagId = orgFatherDzongkhagId;
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

    public Date getOrgMotherDob() {
        return orgMotherDob;
    }

    public void setOrgMotherDob(Date orgMotherDob) {
        this.orgMotherDob = orgMotherDob;
    }

    public String getOrgMotherName() {
        return orgMotherName;
    }

    public void setOrgMotherName(String orgMotherName) {
        this.orgMotherName = orgMotherName;
    }

    public String getOrgMotherGender() {
        return orgMotherGender;
    }

    public void setOrgMotherGender(String orgMotherGender) {
        this.orgMotherGender = orgMotherGender;
    }

    public String getOrgMotherFathersName() {
        return orgMotherFathersName;
    }

    public void setOrgMotherFathersName(String orgMotherFathersName) {
        this.orgMotherFathersName = orgMotherFathersName;
    }

    public Integer getOrgMotherDzongkhagId() {
        return orgMotherDzongkhagId;
    }

    public void setOrgMotherDzongkhagId(Integer orgMotherDzongkhagId) {
        this.orgMotherDzongkhagId = orgMotherDzongkhagId;
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

    public String getTransferorApplicantName() {
        return transferorApplicantName;
    }

    public void setTransferorApplicantName(String transferorApplicantName) {
        this.transferorApplicantName = transferorApplicantName;
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

    public String getTransferorMothersName() {
        return transferorMothersName;
    }

    public void setTransferorMothersName(String transferorMothersName) {
        this.transferorMothersName = transferorMothersName;
    }

    public Integer getTransferorDzongkhagId() {
        return transferorDzongkhagId;
    }

    public void setTransferorDzongkhagId(Integer transferorDzongkhagId) {
        this.transferorDzongkhagId = transferorDzongkhagId;
    }

    public Integer getTransferorVillageId() {
        return transferorVillageId;
    }

    public void setTransferorVillageId(Integer transferorVillageId) {
        this.transferorVillageId = transferorVillageId;
    }

    public Integer getTransferorGewogId() {
        return transferorGewogId;
    }

    public void setTransferorGewogId(Integer transferorGewogId) {
        this.transferorGewogId = transferorGewogId;
    }

    public String getTransferorHouseNo() {
        return transferorHouseNo;
    }

    public void setTransferorHouseNo(String transferorHouseNo) {
        this.transferorHouseNo = transferorHouseNo;
    }

    public String getTransferorTharmNo() {
        return transferorTharmNo;
    }

    public void setTransferorTharmNo(String transferorTharmNo) {
        this.transferorTharmNo = transferorTharmNo;
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

    public Integer getW2GewogId() {
        return w2GewogId;
    }

    public void setW2GewogId(Integer w2GewogId) {
        this.w2GewogId = w2GewogId;
    }

    public String getLunarDateDzo() {
        return lunarDateDzo;
    }

    public void setLunarDateDzo(String lunarDateDzo) {
        this.lunarDateDzo = lunarDateDzo;
    }

    public String getLawyerDzo() {
        return lawyerDzo;
    }

    public void setLawyerDzo(String lawyerDzo) {
        this.lawyerDzo = lawyerDzo;
    }

    public String getApplicationIdDzo() {
        return applicationIdDzo;
    }

    public void setApplicationIdDzo(String applicationIdDzo) {
        this.applicationIdDzo = applicationIdDzo;
    }

    public String getJudgementNoDzo() {
        return judgementNoDzo;
    }

    public void setJudgementNoDzo(String judgementNoDzo) {
        this.judgementNoDzo = judgementNoDzo;
    }

    public String getDateDzo() {
        return dateDzo;
    }

    public void setDateDzo(String dateDzo) {
        this.dateDzo = dateDzo;
    }

    public String getCensusFormNo() {
        return censusFormNo;
    }

    public void setCensusFormNo(String censusFormNo) {
        this.censusFormNo = censusFormNo;
    }

    public String getSpouseCensusFormNo() {
        return spouseCensusFormNo;
    }

    public void setSpouseCensusFormNo(String spouseCensusFormNo) {
        this.spouseCensusFormNo = spouseCensusFormNo;
    }

    public String getGewogName() {
        return gewogName;
    }

    public void setGewogName(String gewogName) {
        this.gewogName = gewogName;
    }

    public String getDzongkhagName() {
        return dzongkhagName;
    }

    public void setDzongkhagName(String dzongkhagName) {
        this.dzongkhagName = dzongkhagName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getSpouseGewogName() {
        return spouseGewogName;
    }

    public void setSpouseGewogName(String spouseGewogName) {
        this.spouseGewogName = spouseGewogName;
    }

    public String getSpouseDzongkhagName() {
        return spouseDzongkhagName;
    }

    public void setSpouseDzongkhagName(String spouseDzongkhagName) {
        this.spouseDzongkhagName = spouseDzongkhagName;
    }

    public String getSpouseVillageName() {
        return spouseVillageName;
    }

    public void setSpouseVillageName(String spouseVillageName) {
        this.spouseVillageName = spouseVillageName;
    }

    public String getOrgFatherGewogName() {
        return orgFatherGewogName;
    }

    public void setOrgFatherGewogName(String orgFatherGewogName) {
        this.orgFatherGewogName = orgFatherGewogName;
    }

    public String getOrgFatherDzongkhagName() {
        return orgFatherDzongkhagName;
    }

    public void setOrgFatherDzongkhagName(String orgFatherDzongkhagName) {
        this.orgFatherDzongkhagName = orgFatherDzongkhagName;
    }

    public String getOrgFatherVillageName() {
        return orgFatherVillageName;
    }

    public void setOrgFatherVillageName(String orgFatherVillageName) {
        this.orgFatherVillageName = orgFatherVillageName;
    }

    public String getOrgMotherGewogName() {
        return orgMotherGewogName;
    }

    public void setOrgMotherGewogName(String orgMotherGewogName) {
        this.orgMotherGewogName = orgMotherGewogName;
    }

    public String getOrgMotherDzongkhagName() {
        return orgMotherDzongkhagName;
    }

    public void setOrgMotherDzongkhagName(String orgMotherDzongkhagName) {
        this.orgMotherDzongkhagName = orgMotherDzongkhagName;
    }

    public String getOrgMotherVillageName() {
        return orgMotherVillageName;
    }

    public void setOrgMotherVillageName(String orgMotherVillageName) {
        this.orgMotherVillageName = orgMotherVillageName;
    }

    public String getPatientDzongkhagName() {
        return patientDzongkhagName;
    }

    public void setPatientDzongkhagName(String patientDzongkhagName) {
        this.patientDzongkhagName = patientDzongkhagName;
    }

    public String getPatientVillageName() {
        return patientVillageName;
    }

    public void setPatientVillageName(String patientVillageName) {
        this.patientVillageName = patientVillageName;
    }

    public String getPatientGewogName() {
        return patientGewogName;
    }

    public void setPatientGewogName(String patientGewogName) {
        this.patientGewogName = patientGewogName;
    }

    public String getPatientWitnessVillageName() {
        return patientWitnessVillageName;
    }

    public void setPatientWitnessVillageName(String patientWitnessVillageName) {
        this.patientWitnessVillageName = patientWitnessVillageName;
    }

    public String getPatientWitness2VillageName() {
        return patientWitness2VillageName;
    }

    public void setPatientWitness2VillageName(String patientWitness2VillageName) {
        this.patientWitness2VillageName = patientWitness2VillageName;
    }

    public String getPatientWitnessGewogName() {
        return patientWitnessGewogName;
    }

    public void setPatientWitnessGewogName(String patientWitnessGewogName) {
        this.patientWitnessGewogName = patientWitnessGewogName;
    }

    public String getPatientWitness2GewogName() {
        return patientWitness2GewogName;
    }

    public void setPatientWitness2GewogName(String patientWitness2GewogName) {
        this.patientWitness2GewogName = patientWitness2GewogName;
    }

    public String getPatientWitnessDzongkhagName() {
        return patientWitnessDzongkhagName;
    }

    public void setPatientWitnessDzongkhagName(String patientWitnessDzongkhagName) {
        this.patientWitnessDzongkhagName = patientWitnessDzongkhagName;
    }

    public String getPatientWitness2DzongkhagName() {
        return patientWitness2DzongkhagName;
    }

    public void setPatientWitness2DzongkhagName(String patientWitness2DzongkhagName) {
        this.patientWitness2DzongkhagName = patientWitness2DzongkhagName;
    }

    public String getDonorDepDzongkhagName() {
        return donorDepDzongkhagName;
    }

    public void setDonorDepDzongkhagName(String donorDepDzongkhagName) {
        this.donorDepDzongkhagName = donorDepDzongkhagName;
    }

    public String getDonorDepVillageName() {
        return donorDepVillageName;
    }

    public void setDonorDepVillageName(String donorDepVillageName) {
        this.donorDepVillageName = donorDepVillageName;
    }

    public String getDonorDepGewogName() {
        return donorDepGewogName;
    }

    public void setDonorDepGewogName(String donorDepGewogName) {
        this.donorDepGewogName = donorDepGewogName;
    }

    public String getDonorDepWitnessVillageName() {
        return donorDepWitnessVillageName;
    }

    public void setDonorDepWitnessVillageName(String donorDepWitnessVillageName) {
        this.donorDepWitnessVillageName = donorDepWitnessVillageName;
    }

    public String getDonorDepWitness2VillageName() {
        return donorDepWitness2VillageName;
    }

    public void setDonorDepWitness2VillageName(String donorDepWitness2VillageName) {
        this.donorDepWitness2VillageName = donorDepWitness2VillageName;
    }

    public String getDonorDepWitnessGewogName() {
        return donorDepWitnessGewogName;
    }

    public void setDonorDepWitnessGewogName(String donorDepWitnessGewogName) {
        this.donorDepWitnessGewogName = donorDepWitnessGewogName;
    }

    public String getDonorDepWitness2GewogName() {
        return donorDepWitness2GewogName;
    }

    public void setDonorDepWitness2GewogName(String donorDepWitness2GewogName) {
        this.donorDepWitness2GewogName = donorDepWitness2GewogName;
    }

    public String getDonorDepWitnessDzongkhagName() {
        return donorDepWitnessDzongkhagName;
    }

    public void setDonorDepWitnessDzongkhagName(String donorDepWitnessDzongkhagName) {
        this.donorDepWitnessDzongkhagName = donorDepWitnessDzongkhagName;
    }

    public String getDonorDepWitness2DzongkhagName() {
        return donorDepWitness2DzongkhagName;
    }

    public void setDonorDepWitness2DzongkhagName(String donorDepWitness2DzongkhagName) {
        this.donorDepWitness2DzongkhagName = donorDepWitness2DzongkhagName;
    }

    public String getDonorWitnessVillageName() {
        return donorWitnessVillageName;
    }

    public void setDonorWitnessVillageName(String donorWitnessVillageName) {
        this.donorWitnessVillageName = donorWitnessVillageName;
    }

    public String getDonorWitness2VillageName() {
        return donorWitness2VillageName;
    }

    public void setDonorWitness2VillageName(String donorWitness2VillageName) {
        this.donorWitness2VillageName = donorWitness2VillageName;
    }

    public String getDonorWitnessGewogName() {
        return donorWitnessGewogName;
    }

    public void setDonorWitnessGewogName(String donorWitnessGewogName) {
        this.donorWitnessGewogName = donorWitnessGewogName;
    }

    public String getDonorWitness2GewogName() {
        return donorWitness2GewogName;
    }

    public void setDonorWitness2GewogName(String donorWitness2GewogName) {
        this.donorWitness2GewogName = donorWitness2GewogName;
    }

    public String getDonorWitnessDzongkhagName() {
        return donorWitnessDzongkhagName;
    }

    public void setDonorWitnessDzongkhagName(String donorWitnessDzongkhagName) {
        this.donorWitnessDzongkhagName = donorWitnessDzongkhagName;
    }

    public String getDonorWitness2DzongkhagName() {
        return donorWitness2DzongkhagName;
    }

    public void setDonorWitness2DzongkhagName(String donorWitness2DzongkhagName) {
        this.donorWitness2DzongkhagName = donorWitness2DzongkhagName;
    }

    public String getDonorDzongkhagName() {
        return donorDzongkhagName;
    }

    public void setDonorDzongkhagName(String donorDzongkhagName) {
        this.donorDzongkhagName = donorDzongkhagName;
    }

    public String getDonorVillageName() {
        return donorVillageName;
    }

    public void setDonorVillageName(String donorVillageName) {
        this.donorVillageName = donorVillageName;
    }

    public String getDonorGewogName() {
        return donorGewogName;
    }

    public void setDonorGewogName(String donorGewogName) {
        this.donorGewogName = donorGewogName;
    }

    public String getPatientWitnessName() {
        return patientWitnessName;
    }

    public void setPatientWitnessName(String patientWitnessName) {
        this.patientWitnessName = patientWitnessName;
    }

    public String getPatientWitness2Name() {
        return patientWitness2Name;
    }

    public void setPatientWitness2Name(String patientWitness2Name) {
        this.patientWitness2Name = patientWitness2Name;
    }

    public String getApplicantDobBh() {
        return applicantDobBh;
    }

    public void setApplicantDobBh(String applicantDobBh) {
        this.applicantDobBh = applicantDobBh;
    }

    public String getSpouseApplicantDobBh() {
        return spouseApplicantDobBh;
    }

    public void setSpouseApplicantDobBh(String spouseApplicantDobBh) {
        this.spouseApplicantDobBh = spouseApplicantDobBh;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getApplicationYear() {
        return applicationYear;
    }

    public void setApplicationYear(String applicationYear) {
        this.applicationYear = applicationYear;
    }

    public BigInteger getTotals() {
        return totals;
    }

    public void setTotals(BigInteger totals) {
        this.totals = totals;
    }

    public String getReject_Reason() {
        return Reject_Reason;
    }

    public void setReject_Reason(String reject_Reason) {
        Reject_Reason = reject_Reason;
    }

    public List<ReasonDTO> getReasonDTOs() {
        return reasonDTOs;
    }

    public void setReasonDTOs(List<ReasonDTO> reasonDTOs) {
        this.reasonDTOs = reasonDTOs;
    }

    public String getReceiptDatebh() {
        return receiptDatebh;
    }

    public void setReceiptDatebh(String receiptDatebh) {
        this.receiptDatebh = receiptDatebh;
    }

    //endregion
}
