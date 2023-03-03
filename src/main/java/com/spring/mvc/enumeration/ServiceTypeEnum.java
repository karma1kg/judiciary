package com.spring.mvc.enumeration;

/**
 * Created by USER on 7/29/2019.
 */
public enum ServiceTypeEnum {
    MARRIAGE_CERTIFICATE(501, "MC","Marriage Certificate"),
    AUTHENTICATION_PERSONAL_DETAILS(502, "AP","Authentication of personal details"),
    AFFIRMATION_MARRIAGE_CERTIFICATE(503,"AM", "Affirmation of marriage certificate"),
    LOST_DOCUMENTS(504,"LD", "Lost Documents"),
    SINGLE_MARITAL_STATUS(505,"SM", "Single Status/Marital Status"),
    CHILD_TRAVEL_DOCUMENT(506,"CT", "Child Travel Document"),
    ATTESTATION_OF_DOCUMENT(507,"AD", "Attestation of Documents"),
    CHILD_ADOPTION(508,"CA", "Child Adoption"),
    KIDNEY_TRANSPLANT(509,"KT", "Kidney Transplant"),
    CLOSING_AND_TRANSFER_OF_SHARES_AND_ACCOUNTS(510,"SA", "Closing and Transfer of Shares ans Accounts"),
    ATTEST_AGREEMENTS_WILLS_CONTRACTS_AND_TESTAMENTS(511,"AA", "Attest Agreements,Wills, contracts and Testaments"),
    NEW_MARRIAGE_CERTIFICATE(512, "NMC", "New Marriage Certificate"),
    DIVORCE_CERTIFICATE(513, "DA", "Divorce Marriage Certificate");


    private final Integer serviceTypeId;
    private final String serviceCode;
    private final String serviceName;

    ServiceTypeEnum(Integer serviceTypeId, String serviceCode, String serviceName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }
}
