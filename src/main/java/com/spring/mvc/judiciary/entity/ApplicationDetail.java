package com.spring.mvc.judiciary.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by N-Zepa on 27-Jul-19.
 */
@Entity
@Table(name = "t_application_details")
public class ApplicationDetail {

    //region private variables
    @Id
    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "SERVICE_SL_NO")
    private Integer serviceSlNo;

    @Column(name = "LETTER_NO")
    private String letterNo;

    @Column(name = "LETTER_DATE")
    private Date letterDate;

    @Column(name = "INCORRECT_TYPE")
    private Integer incorrectType;

    @Column(name = "INCORRECT_NAME")
    private String incorrectName;

    @Column(name = "INCORRECT_DOB")
    private Date incorrectDate;

    @Column(name = "INCORRECT_CID")
    private String incorrectCidNo;

    @Column(name = "INCORRECT_DZONGKHAG_ID")
    private Integer incorrectDzongkhagName;

    @Column(name = "INCORRECT_GEWOG_ID")
    private Integer incorrectGewogName;

    @Column(name = "INCORRECT_VILLAGE_ID")
    private Integer incorrectVillageName;

    @Column(name = "INCORRECT_OTHERS")
    private String incorrectOthers;

    @Column(name = "MC_NO")
    private String mcNo;

    @Column(name = "CMC_NO")
    private String cmcNo;

    @Column(name = "HOSPITAL_NAME")
    private String hospitalName;

    @Column(name = "RELATIONSHIP")
    private String relationship;

    @Column(name = "DOC_NAME")
    private String docName;

    @Column(name = "LOST_DOC_TYPE")
    private Integer lostDocType;

    @Column(name = "COURT_ID")
    private Integer courtId;

    @Column(name = "DATE_OF_APPOINTMENT")
    private Date appoinmentDate;

    @Column(name = "STATUS_ID")
    private String statusId;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CASE_NO")
    private String caseNo;

    @Column(name = "JUDGEMENT_NO")
    private String judgementNo;

    @Column(name = "JUDGEMENT_DATE")
    private Date judgementDate;

    @Column(name = "CLERK")
    private String clerk;

    @Column(name = "LAWYER")
    private String lawyer;

    @Column(name = "RECEIPT_NO")
    private String receiptNo;

    @Column(name = "RECEIPT_DATE")
    private Date receiptDate;

    @Column(name = "RECEIPT_AMOUNT")
    private Integer receiptAmount;

    @Column(name = "UPDATE_BY")
    private String updatedBy;

    @Column(name = "PRINT_STATUS")
    private String printStatus;

    @Column(name = "PAYMENT_CLEARED")
    private String paymentCleared;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "EXAM_YEAR")
    private String examYear;

    @Column(name = "KUENSEL_DATE")
    private Date kuenselDate;

    @Column(name = "INDEX_NO")
    private String indexNo;

    @Column(name = "CLASS_TYPE")
    private Integer classType;

    @Column(name = "TRAVEL_REASON")
    private Integer travelReason;

    @Column(name = "CHILD_PASSPORT_NO")
    private String childPassportNo;

    @Column(name = "APP_PASSPORT_NO")
    private String appPassportNo;

    @Column(name = "REG_NO")
    private String regNo;

    @Column(name = "REG_DATE")
    private Date regDate;
    //endregion
   @Column(name = "applicationYear")
   private String applicationYear;

    @Column(name = "Reject_Reason")
    private String Reject_Reason;
    //region setters and getters
    @Column(name="CREATED_DATE_TIME")
  private String created_Date_Time;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getServiceSlNo() {
        return serviceSlNo;
    }

    public void setServiceSlNo(Integer serviceSlNo) {
        this.serviceSlNo = serviceSlNo;
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

    public Integer getIncorrectType() {
        return incorrectType;
    }

    public void setIncorrectType(Integer incorrectType) {
        this.incorrectType = incorrectType;
    }

    public String getIncorrectCidNo() {
        return incorrectCidNo;
    }

    public void setIncorrectCidNo(String incorrectCidNo) {
        this.incorrectCidNo = incorrectCidNo;
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

    public String getIncorrectOthers() {
        return incorrectOthers;
    }

    public void setIncorrectOthers(String incorrectOthers) {
        this.incorrectOthers = incorrectOthers;
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

    public Date getAppoinmentDate() {
        return appoinmentDate;
    }

    public void setAppoinmentDate(Date appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getExamYear() {
        return examYear;
    }

    public void setExamYear(String examYear) {
        this.examYear = examYear;
    }

    public Date getKuenselDate() {
        return kuenselDate;
    }

    public void setKuenselDate(Date kuenselDate) {
        this.kuenselDate = kuenselDate;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
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

    public String getApplicationYear() {
        return applicationYear;
    }

    public void setApplicationYear(String applicationYear) {
        this.applicationYear = applicationYear;
    }

    public String getReject_Reason() {
        return Reject_Reason;
    }

    public void setReject_Reason(String reject_Reason) {
        Reject_Reason = reject_Reason;
    }

    /*public String getCreated_Date_Time() {
        return created_Date_Time;
    }

    public void setCreated_Date_Time(DateTime created_Date_Time) {
        this.created_Date_Time = created_Date_Time;
    }*/

    //endregion
}
