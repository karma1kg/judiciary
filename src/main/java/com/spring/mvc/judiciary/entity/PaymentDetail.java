package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 9/8/2019.
 */
@Entity
@Table(name = "t_app_payment_details")
public class PaymentDetail {
    //region private variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_DETAIL_ID")
    private Integer paymentDetailId;

    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "SERVICE_ID")
    private Integer serviceNo;

    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "AMOUNT_CHARGE")
    private Integer amountCharge;

    @Column(name = "BANK_ID")
    private Integer bankId;

    @Column(name = "RECEIPT_NO")
    private String receiptNo;

    @Column(name = "VOUCHER_NO")
    private String voucherNo;

    @Column(name = "DEPOSITE_DATE")
    private Date depositDate;

    @Column(name = "IS_PAID")
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

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getAmountCharge() {
        return amountCharge;
    }

    public void setAmountCharge(Integer amountCharge) {
        this.amountCharge = amountCharge;
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

    //endregion
}
