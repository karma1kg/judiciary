package com.spring.mvc.judiciary.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by USER on 9/8/2019.
 */
public class PaymentDetailDTO {
    //region private variables
    private Integer paymentDetailId;
    private String applicationNo;
    private Integer serviceNo;
    private String paymentType;
    private Integer receiptAmount;
    private Integer bankId;

    @NotNull(message = "Receipt no is required")
    @Size(min = 1, max = 150, message = "Receipt no should be maximum of 150 characters")
    private String receiptNo;
    private String voucherNo;
    @NotNull(message = "Deposit date is required")
    private Date depositDate;
    private String isPaid;
    //endregion

    //region setters and getters
    public Integer getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(Integer paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Integer receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    //endregion
}
