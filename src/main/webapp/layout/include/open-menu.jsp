<%@ page import="bt.gov.ditt.sso.client.dto.UserSessionDetailDTO" %>
<%@ page import="bt.gov.ditt.sso.client.SSOClientConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="header collapse d-lg-flex p-0" id="headerMenuCollapse">
    <div class="container">
        <div class="row pull-right">
            <div class="col-lg order-lg-first">
                <ul class="nav nav-tabs border-0 flex-column flex-lg-row">
                    <li class="nav-item ">
                        <a href="<c:url value='/public/index'/>" class="nav-link" style="color:black">
                            <i class="fa fa-home"></i>Home</a>
                    </li>
                    <li class="nav-item" style="color:black">
                        <a href="javascript:void(0)" class="nav-link" data-toggle="dropdown"><i class="fe fe-edit"></i>
                            Application <i class="fa fa-chevron-down"></i></a>
                        <div class="dropdown-menu dropdown-menu-arrow">
                            <a href="<c:url value='/marriageCertificate'/>" class="dropdown-item">
                                <i class="fa fa-certificate"></i> Apply for Marriage Certificate</a>
                            <a href="<c:url value='/authenticationPersonalDetails'/>" class="dropdown-item">
                                <i class="fa fa-key"></i>Apply for Authentication/Verification of Personal Details</a>
                            <a href="<c:url value='/affirmationMarriageCertificate'/>" class="dropdown-item ">
                                <i class="fe fe-folder"></i>Apply for Translation of Marriage Certificate</a>
                            <a href="<c:url value='/lostDocument'/>" class="dropdown-item">
                                <i class="fe fe-airplay"></i>Apply for Lost Documents</a>
                            <a href="<c:url value='/singleMaritalStatus'/>" class="dropdown-item">
                                <i class="fe fe-anchor"></i>Apply for Single/Marital Status</a>
                            <a href="<c:url value='/childTravelDocument'/>" class="dropdown-item">
                                <i class="fe fe-alert-octagon"></i>Apply for Child Travel Documents</a>
							<a href="<c:url value='/attestationDocument'/>" class="dropdown-item">
                                <i class="fe fe-activity"></i>Apply for Attestation of Documents</a>
							<a href="<c:url value='/childAdoption'/>" class="dropdown-item">
                                <i class="fe fe-aperture"></i>Apply for Child Adoption</a>
							<a href="<c:url value='/organTransplant'/>" class="dropdown-item">
                                <i class="fe fe-at-sign"></i>Apply for Organ Transplant</a>
							<a href="<c:url value='/closingTransferAccounts'/>" class="dropdown-item">
                                <i class="fe fe-bar-chart"></i>Apply for Closing of Accounts and Transfer of Shares	</a>
							<a href="<c:url value='/attestAgreementWillsContract'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i>Apply for Attesting Agreement,Wills,Contracts and Testaments</a>
                            <a href="<c:url value='/newMarriageCertificate'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i>Apply for New Marriage Certificate</a>
                            <a href="<c:url value='/divorceApplication'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i>Apply for Divorce Certificate</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a href="<c:url value='/trackApplication'/>" class="nav-link" style="color:black"> <strong><i
                                class="fe fe-search"></i>Track Your Application</strong></a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>