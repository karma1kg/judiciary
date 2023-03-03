<%@ page import="com.spring.mvc.auth.dto.UserRolePrivilegeDto" %>
<%@ page import="com.spring.mvc.auth.dto.Service" %>
<%@ page import="com.spring.mvc.auth.dto.Privilege" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
    String roleName = "";
    String username = "";
    if (session.getAttribute("UserRolePrivilege") != null) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) session.getAttribute("UserRolePrivilege");
        String LocationId="";
        if(userBean.getJurisdictions().length >=1){
            for (int n = 0; n < userBean.getJurisdictions().length; n++) {
                LocationId=userBean.getJurisdictions()[n].getLocationID();
            }
        }
        for (int m = 0; m < userBean.getRoles().length; m++) {
            for (int i = 0; i < userBean.getRoles()[m].getServices().length; i++) {
                Service svc = userBean.getCurrentRole().getServices()[i];
                for (int j = 0; j < svc.getPrivileges().length; j++) {
                    Privilege priv = svc.getPrivileges()[j];
                }
            }
        }
        roleName = userBean.getCurrentRole().getRoleId();
        username=userBean.getUserType();
    }%>
<% Integer paymentCount = (Integer) request.getAttribute("paymentCount"); %>
<div class="header collapse d-lg-flex p-0" id="headerMenuCollapse">
    <div class="container">
        <div class="row pull-right">
            <div class="col-lg order-lg-first">
                <ul class="nav nav-tabs border-0 flex-column flex-lg-row">
                    <li class="nav-item ">
                        <a class="nav-link" href="<c:url value="/login"><c:param name="username" value="<%=username%>"/></c:url>" style="color:black"><i class="fa fa-home"></i>&nbsp;Home <span class="sr-only">(current)</span></a>
                    </li>
                    <%if(roleName.equalsIgnoreCase("26033")){%>
                    <li class="nav-item ">
                        <a href="<c:url value="/notaryTaskList/ALL"/>" class="nav-link" style="color:black">
                            <i class="fa fa-list"></i>Task List</a>
                    </li>
                    <%}else if (roleName.equalsIgnoreCase("26034")){%>
                    <li class="nav-item ">
                        <a href="<c:url value="/dataManagerTaskList/ALL"/>" class="nav-link" style="color:black">
                            <i class="fa fa-list"></i>Task List</a>
                    </li>
                    <%}%>
                    <%if(roleName.equalsIgnoreCase("26077")){%>
                        <li class="nav-item ">
                            <a href="<c:url value="/nonNationalMarriageCertificate"/>" class="nav-link" style="color:black">
                                <i class="fa fa-dollar"></i>Marriage Certificate with Bhutanese and Foreigner</a>
                        </li>
                    <%}%>
                    <%if(roleName.equalsIgnoreCase("26034")){%>
                    <li class="nav-item" style="color:black">
                        <a href="javascript:void(0)" class="nav-link" data-toggle="dropdown"><i class="fa fa-paypal"></i><%--<span class="badge badge-danger"><%=paymentCount%></span>--%>
                            Update Offline Payment <i class="fa fa-chevron-down"></i></a>
                        <div class="dropdown-menu dropdown-menu-arrow">
                            <a href="<c:url value='/paymentDetail?serviceId=501'/>" class="dropdown-item">
                                <i class="fa fa-certificate"></i>  Marriage Certificate</a>
                            <a href="<c:url value='/paymentDetail?serviceId=502'/>" class="dropdown-item">
                                <i class="fa fa-key"></i> Authentication/Verification of Personal Details</a>
                            <a href="<c:url value='/paymentDetail?serviceId=503'/>" class="dropdown-item ">
                                <i class="fe fe-folder"></i> Translation of Marriage Certificate</a>
                            <a href="<c:url value='/paymentDetail?serviceId=504'/>" class="dropdown-item">
                                <i class="fe fe-airplay"></i> Lost Documents</a>
                            <a href="<c:url value='/paymentDetail?serviceId=505'/>" class="dropdown-item">
                                <i class="fe fe-anchor"></i> Single/Marital Status</a>
                            <a href="<c:url value='/paymentDetail?serviceId=506'/>" class="dropdown-item">
                                <i class="fe fe-alert-octagon"></i> Child Travel Documents</a>
                            <a href="<c:url value='/paymentDetail?serviceId=507'/>" class="dropdown-item">
                                <i class="fe fe-activity"></i> Attestation of Documents</a>
                            <a href="<c:url value='/paymentDetail?serviceId=508'/>" class="dropdown-item">
                                <i class="fe fe-aperture"></i> Child Adoption</a>
                            <a href="<c:url value='/paymentDetail?serviceId=509'/>" class="dropdown-item">
                                <i class="fe fe-at-sign"></i> Organ Transplant</a>
                            <a href="<c:url value='/paymentDetail?serviceId=510'/>" class="dropdown-item">
                                <i class="fe fe-bar-chart"></i> Closing of Accounts and Transfer of Shares	</a>
                            <a href="<c:url value='/paymentDetail?serviceId=511'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i> Attesting Agreement,Wills,Contracts and Testaments</a>
                            <a href="<c:url value='/paymentDetail?serviceId=512'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i> New Marriage Certificate</a>
                        </div>
                    </li>
                    <li class="nav-item" style="color:black">
                        <a href="javascript:void(0)" class="nav-link" data-toggle="dropdown"><i class="fa fa-file-pdf-o"></i>
                            Offline Application <i class="fa fa-chevron-down"></i></a>
                        <div class="dropdown-menu dropdown-menu-arrow">
                            <a href="<c:url value='/offlineMarriageCertificate'/>" class="dropdown-item">
                                <i class="fa fa-certificate"></i>  Marriage Certificate</a>
                           <%-- <a href="<c:url value='/authenticationPersonalDetails'/>" class="dropdown-item">
                                <i class="fa fa-key"></i> Authentication/Verification of Personal Details</a>
                            <a href="<c:url value='/affirmationMarriageCertificate'/>" class="dropdown-item ">
                                <i class="fe fe-folder"></i> Translation of Marriage Certificate</a>
                            <a href="<c:url value='/lostDocument'/>" class="dropdown-item">
                                <i class="fe fe-airplay"></i> Lost Documents</a>
                            <a href="<c:url value='/singleMaritalStatus'/>" class="dropdown-item">
                                <i class="fe fe-anchor"></i> Single/Marital Status</a>
                            <a href="<c:url value='/childTravelDocument'/>" class="dropdown-item">
                                <i class="fe fe-alert-octagon"></i> Child Travel Documents</a>
                            <a href="<c:url value='/attestationDocument'/>" class="dropdown-item">
                                <i class="fe fe-activity"></i> Attestation of Documents</a>
                            <a href="<c:url value='/childAdoption'/>" class="dropdown-item">
                                <i class="fe fe-aperture"></i> Child Adoption</a>
                            <a href="<c:url value='/organTransplant'/>" class="dropdown-item">
                                <i class="fe fe-at-sign"></i> Organ Transplant</a>
                            <a href="<c:url value='/closingTransferAccounts'/>" class="dropdown-item">
                                <i class="fe fe-bar-chart"></i> Closing of Accounts and Transfer of Shares	</a>
                            <a href="<c:url value='/attestAgreementWillsContract'/>" class="dropdown-item">
                                <i class="fe fe-battery"></i> Attesting Agreement,Wills,Contracts and Testaments</a>--%>
                        </div>
                    </li>
                    <%}%>
                    <%if(roleName.equalsIgnoreCase("26034")){%>
                        <li class="nav-item ">
                            <a href="<c:url value="/printCertificate"/>" class="nav-link" style="color:black">
                                <i class="fa fa-print"></i>Print Certificate</a>
                        </li>
                    <%--<li class="nav-item" style="color:black">
                        <a href="javascript:void(0)" class="nav-link" data-toggle="dropdown"><i class="fa fa-print"></i>
                            Print Certificates <i class="fa fa-chevron-down"></i></a>
                        <div class="dropdown-menu dropdown-menu-arrow">
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fa fa-certificate"></i> Marriage Certificate</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fa fa-key"></i> Authentication/Verification of Personal Details</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item ">
                                <i class="fe fe-folder"></i> Translation of Marriage Certificate</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-airplay"></i> Lost Documents</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-anchor"></i> Single/Marital Status</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-alert-octagon"></i> Child Travel Documents</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-aperture"></i> Child Adoption</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-at-sign"></i> Organ Transplant</a>
                            <a href="<c:url value='/printCertificate'/>" class="dropdown-item">
                                <i class="fe fe-bar-chart"></i> Closing of Accounts and Transfer of Shares	</a>
                        </div>
                    </li>--%>
                    <%}%>
                    <%if(roleName.equalsIgnoreCase("26033") || roleName.equalsIgnoreCase("26034") || roleName.equalsIgnoreCase("26077")){%>
                    <li class="nav-item" style="color:black">
                        <a href="javascript:void(0)" class="nav-link" data-toggle="dropdown"><i class="fe fe-edit"></i>
                            Reports <i class="fa fa-chevron-down"></i></a>
                        <div class="dropdown-menu dropdown-menu-arrow">
                            <a href="<c:url value="/reports"/>" class="dropdown-item">
                                <i class="fa fa-certificate"></i>General Report</a>
                            <a href="<c:url value="/reportByService"/>" class="dropdown-item">
                                <i class="fa fa-key"></i>Statistical Report by Service</a>
                            <a href="<c:url value="/reportsByCourt"/>" class="dropdown-item ">
                                <i class="fe fe-folder"></i>Statistical Report by Court</a>
                        </div>
                    </li>
                    <%}%>
                    <li class="nav-item">
                        <a href="<c:url value="/trackApplication"/>" class="nav-link" style="color:black"> <strong><i
                                class="fe fe-search"></i>Track Your Application</strong></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>