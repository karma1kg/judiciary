<%@ page import="com.spring.mvc.auth.dto.UserRolePrivilegeDto" %>
<%@ page import="com.spring.mvc.auth.dto.Service" %>
<%@ page import="com.spring.mvc.auth.dto.Privilege" %>
<%@ page import="java.util.List" %>
<%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String roleId = "";
    String userId = "";
    if (session.getAttribute("UserRolePrivilege") != null) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) session.getAttribute("UserRolePrivilege");
        String LocationId="";
        /*if(userBean.getJurisdictions().length >=1){
            for (int n = 0; n < userBean.getJurisdictions().length; n++) {
                LocationId=userBean.getJurisdictions()[n].getLocationID();
            }
        }*/
        for (int m = 0; m < userBean.getRoles().length; m++) {
            for (int i = 0; i < userBean.getRoles()[m].getServices().length; i++) {
                Service svc = userBean.getCurrentRole().getServices()[i];
                for (int j = 0; j < svc.getPrivileges().length; j++) {
                    Privilege priv = svc.getPrivileges()[j];
                }
            }
        }
        roleId = userBean.getCurrentRole().getRoleId();
        userId=userBean.getUserType();
    }%>
<% UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) session.getAttribute("UserRolePrivilege");%>
<% Integer groupCountSubmitted = (Integer) request.getAttribute("groupCountSubmitted"); %>
<% Integer myCountSubmitted = (Integer) request.getAttribute("myCountSubmitted"); %>
<% Integer groupCountVerified = (Integer) request.getAttribute("groupCountVerified"); %>
<% Integer myCountVerified = (Integer) request.getAttribute("myCountVerified"); %>

<%--Application Submitted Count--%>
<% Integer mcCountSubmitted = (Integer) request.getAttribute("mcCountSubmitted"); %>
<% Integer apCountSubmitted = (Integer) request.getAttribute("apCountSubmitted"); %>
<% Integer amCountSubmitted = (Integer) request.getAttribute("amCountSubmitted"); %>
<% Integer ldCountSubmitted = (Integer) request.getAttribute("ldCountSubmitted"); %>
<% Integer smCountSubmitted = (Integer) request.getAttribute("smCountSubmitted"); %>
<% Integer ctCountSubmitted = (Integer) request.getAttribute("ctCountSubmitted"); %>
<% Integer adCountSubmitted = (Integer) request.getAttribute("adCountSubmitted"); %>
<% Integer caCountSubmitted = (Integer) request.getAttribute("caCountSubmitted"); %>
<% Integer ktCountSubmitted = (Integer) request.getAttribute("ktCountSubmitted"); %>
<% Integer saCountSubmitted = (Integer) request.getAttribute("saCountSubmitted"); %>
<% Integer aaCountSubmitted = (Integer) request.getAttribute("aaCountSubmitted"); %>
<% Integer nmcCountSubmitted = (Integer) request.getAttribute("nmcCountSubmitted"); %>

<%--Application Verified Count--%>
<% Integer mcCountVerified = (Integer) request.getAttribute("mcCountVerified"); %>
<% Integer apCountVerified = (Integer) request.getAttribute("apCountVerified"); %>
<% Integer amCountVerified = (Integer) request.getAttribute("amCountVerified"); %>
<% Integer ldCountVerified = (Integer) request.getAttribute("ldCountVerified"); %>
<% Integer smCountVerified = (Integer) request.getAttribute("smCountVerified"); %>
<% Integer ctCountVerified = (Integer) request.getAttribute("ctCountVerified"); %>
<% Integer adCountVerified = (Integer) request.getAttribute("adCountVerified"); %>
<% Integer caCountVerified = (Integer) request.getAttribute("caCountVerified"); %>
<% Integer ktCountVerified = (Integer) request.getAttribute("ktCountVerified"); %>
<% Integer saCountVerified = (Integer) request.getAttribute("saCountVerified"); %>
<% Integer aaCountVerified = (Integer) request.getAttribute("aaCountVerified"); %>
<% Integer nmcCountVerified = (Integer) request.getAttribute("nmcCountVerified"); %>
<head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Judicial Services</title>
</head>
<body>
<div id="loadMainPage">
    <div class="my-3 my-md-5">
        <div class="container">
            <div class="row row-cards">
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="height: 100%;">
                        <div class="card-status bg-blue"></div>
                        <div class="card-header">
                            <h3 class="card-title">Select Service to Take Action</h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div>
                                    <div class="" id="navbarSupportedContent33" style="margin-top:-50px;">
                                        <ul class="navbar-nav mr-auto">
                                            <li class="dropdown nav-item pt-5">
                                                <a class="nav-link dropdown-toggle" href="#" id="ah3" role="button"
                                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <span class="fa fa-check-circle pr-2"></span>Judicial Services
                                                </a>
                                               <% if(roleId.equalsIgnoreCase("26033")){%>
                                                <div class="dropdown-menu dropdown-menu-arrow bg-cyan-lightest" aria-labelledby="navbarDropdown3">
                                                    <a class="dropdown-item" style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/"></c:url>">
                                                        Claim Application
                                                    </a>
                                                </div><br/><br/><br/>
                                                <strong>Total Application Submitted</strong>
                                                <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                                                    <div class="card">
                                                        <div class="card-status bg-green"></div>
                                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px;">
                                                            <div class="row">
                                                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">
                                                                    <div class="progress progress-sm">
                                                                        <div class="progress-bar bg-green" style="width: <%=groupCountSubmitted%>%"></div>
                                                                    </div>
                                                                    <strong><%=groupCountSubmitted%></strong>
                                                                    <div class="h8">Group Task</div>
                                                                </div>
                                                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">
                                                                    <div class="progress progress-sm">
                                                                        <div class="progress-bar bg-green" style="width: <%=myCountSubmitted%>%"></div>
                                                                    </div>
                                                                    <strong><%=myCountSubmitted%></strong>
                                                                    <div class="h8">My Task</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%} else if (roleId.equalsIgnoreCase("26034")) {%>
                                                <div class="dropdown-menu dropdown-menu-arrow bg-cyan-lightest" aria-labelledby="navbarDropdown3">
                                                    <a class="dropdown-item" style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/"></c:url>">
                                                        Claim Application
                                                    </a>
                                                </div><br/><br/><br/>
                                                <strong>Total Application Verified</strong>
                                                <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                                                    <div class="card">
                                                        <div class="card-status bg-green"></div>
                                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px;">
                                                            <div class="row">
                                                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">
                                                                    <div class="progress progress-sm">
                                                                        <div class="progress-bar bg-green" style="width: <%=groupCountVerified%>%"></div>
                                                                    </div>
                                                                    <strong><%=groupCountVerified%></strong>
                                                                    <div class="h8">Group Task</div>
                                                                </div>
                                                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">
                                                                    <div class="progress progress-sm">
                                                                        <div class="progress-bar bg-green" style="width: <%=myCountVerified%>%"></div>
                                                                    </div>
                                                                    <strong><%=myCountVerified%></strong>
                                                                    <div class="h8">My Task</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%}%>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-6">
                    <div class="card">
                        <div class="card-status bg-blue"></div>
                        <div class="card-header">
                            <h3 class="card-title"><b>DashBoard</b></h3>
                        </div>
                        <%if(roleId.equalsIgnoreCase("26033")){%>
                        <div class="card-body">
                            <h5 style="text-align:center;"><b>Application Submitted</b></h5>
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <input type="hidden" readonly="true" class="form-control field" name="serviceSlNo" id="serviceSlNo">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/501"></c:url>">Marriage Certificate (<strong id=""><%=mcCountSubmitted%></strong>)</a></div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-green" style="width: <%=mcCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/502"></c:url>">Authentication of Personal Details (<strong><%=apCountSubmitted%></strong>)</a></div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-yellow" style="width: <%=apCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/503"></c:url>">Affirmation of Marriage Certificate (<strong><%=amCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red" style="width: <%=amCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/504"></c:url>">Lost Documents (<strong><%=ldCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue" style="width: <%=ldCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-gray"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/505"></c:url>">Single Status/Marital Status (<strong><%=smCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-gray" style="width: <%=smCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-orange"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/506"></c:url>">Child Travel Documents (<strong><%=ctCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-orange" style="width: <%=ctCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/507"></c:url>" id="adjang" >Attestation of Documents (<strong><%=adCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue-dark" style="width: <%=adCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/508"></c:url>">Child Adoption (<strong><%=caCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-yellow-dark" style="width: <%=caCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/509"></c:url>">Kidney Transplant (<strong><%=ktCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-green-dark" style="width: <%=ktCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/510"></c:url>">Closing & Transfer of Shares & Accounts (<strong><%=saCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue-dark" style="width: <%=saCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/511"></c:url>">Attest Agreements,Wills, contracts & Testaments (<strong><%=aaCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red-dark" style="width: <%=aaCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/notaryTaskList/512"></c:url>">New Marriage Certificate (<strong><%=nmcCountSubmitted%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red-dark" style="width: <%=nmcCountSubmitted%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <%}else if(roleId.equalsIgnoreCase("26034")){%>
                        <div class="card-body">
                            <h5 style="text-align:center;"><b>Application Verified</b></h5><br>
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/501"></c:url>">Marriage Certificate (<strong><%=mcCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-green" style="width: <%=mcCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/502"></c:url>">Authentication of Personal Details (<strong><%=apCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-yellow" style="width: <%=apCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/503"></c:url>">Affirmation of Marriage Certificate (<strong><%=amCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red" style="width: <%=amCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/504"></c:url>">Lost Documents (<strong><%=ldCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue" style="width: <%=ldCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-gray"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/505"></c:url>">Single Status/Marital Status (<strong><%=smCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-gray" style="width: <%=smCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-orange"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/506"></c:url>">Child Travel Documents (<strong><%=ctCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-orange" style="width: <%=ctCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/507"></c:url>">Attestation of Documents (<strong><%=adCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue-dark" style="width: <%=adCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/508"></c:url>">Child Adoption (<strong><%=caCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-yellow-dark" style="width: <%=caCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/509"></c:url>">Kidney Transplant (<strong><%=ktCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-green-dark" style="width: <%=ktCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/510"></c:url>">Closing & Transfer of Shares & Accounts (<strong><%=saCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-blue-dark" style="width: <%=saCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/511"></c:url>">Attest Agreements,Wills, contracts & Testaments (<strong><%=aaCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red-dark" style="width: <%=aaCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6 col-sm-6 col-lg-6 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="<c:url value="/dataManagerTaskList/512"></c:url>">New Marriage Certificate(<strong><%=nmcCountVerified%></strong>)</a> </div>
                                            <div class="progress progress-sm">
                                                <div class="progress-bar bg-red-dark" style="width: <%=nmcCountVerified%>%"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <%}else if(roleId.equalsIgnoreCase("26077")){%>
                        <div class="card-body">
                            <h5 style="text-align:center;"><b>Application Completed</b></h5><br>
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Marriage Certificate</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Authentication Personal Details</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Affirmation of MC</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Lost Documents</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Single Status/Marital Status</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Child Travel Documnets</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Attestation of Documents</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-yellow-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Child Adoption</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-green-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Kidney Transplant</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-blue-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Closing and Transfer of Shares ans Accounts</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">Attest Agreements,Wills, contracts and Testaments</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-3 col-sm-3 col-lg-3 col-xs-12" style="max-height: 90px!important; min-height: 93px;">
                                    <div class="card" style="max-height: 90px!important; min-height: 93px;">
                                        <div class="card-status bg-red-dark"></div>
                                        <div class="card-body text-center" style="padding-bottom: 2px;padding-top: 5px; height: 13px;">
                                            <div class="h5"><a style="color:#4b4b5f;" href="">New Marriage Certificate</a> </div>
                                            <div class="progress progress-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
