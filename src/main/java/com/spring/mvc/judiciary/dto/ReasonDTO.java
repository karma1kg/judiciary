package com.spring.mvc.judiciary.dto;

/**
 * Created by kg on 09/04/2022.
 */
public class ReasonDTO {
    private String reasonText;
    private int reasonId;

    public ReasonDTO() {
    }

    public ReasonDTO(String reasonText, int reasonId) {
        this.reasonText = reasonText;
        this.reasonId = reasonId;
    }

    public String getReasonText() {
        return reasonText;
    }

    public void setReasonText(String reasonText) {
        this.reasonText = reasonText;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }
}
