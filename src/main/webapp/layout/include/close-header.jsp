<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page import="com.spring.mvc.auth.dto.UserRolePrivilegeDto" %>
<%@ page import="com.spring.mvc.auth.dto.Service" %>
<%@ page import="com.spring.mvc.auth.dto.Privilege" %>
<%
    String roleName = "";
    String userId = "";
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
        userId=userBean.getUserType();
    }%>
<% UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) session.getAttribute("UserRolePrivilege");%>
<div class="header pb-lg-0 pt-lg-0 py-4" style="background: #120f65;">
    <div class="container">
        <div class="d-flex">
            <a class="header-brand" href="<c:url value='/'/>">
                <img src="<c:url value="/resources/images/logo.png"/>" class="header-brand-img" alt="Royal Court of Justice"
                     style="height:100px;width:100px">
            </a>
            <div class="header-panel">
                <h3 class="text-white organization-name">Government to Citizen Service Delivery Initiative</h3>
                <h4 class="text-white organization-name">Royal Court of Justice</h4>
            </div>

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
               <%-- <%if(roleName.equalsIgnoreCase("26034")){%>--%>
               <%-- <div class="d-flex order-lg-2 ml-auto">
                    <div class="dropdown">
                        <a href="#" class="nav-link pr-0" data-toggle="dropdown"><div style="width:200px; height:50px; background-color:blue;">Switch Role</div></a>
                        <div class="dropdown-menu dropdown-content" aria-labelledby="mastermanagement">
                            <a class="dropdown-item" href="<c:url value="/login"/>" id="notary">Notary</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="<c:url value="/login"/>" id="datamanager">Data Manager</a>
                        </div>
                        </div>
                    </div>--%>

            <%if(userBean.getRoles().length>=1) { %>
                        <span class="pull-right" style="padding-top: 5px;">
                            <ul>
                                <li>
                                    <div class="dropdown">
                                        <button class="btn btn-primary dropdown-toggle user-info" type="button" data-toggle="dropdown">
                                            <i class="fa fa-unlock"></i>&nbsp;
                                            <span>Switch Role</span></button>
                                        <ul class="dropdown-menu" style="text-align: left;">
                                            <%for(int m=0; m<userBean.getRoles().length; m++){%>
                                            <li><a href="<%=request.getContextPath() %>/login?roleCode=<%=userBean.getRoles()[m].getRoleId()%>"><i class="fa fa-lock fa-fw"></i> <%=userBean.getRoles()[m].getRoleName() %></a></li>
                                            <%if(m!=(userBean.getRoles().length-1)){ %>
                                            <li class="divider"></li>
                                             <% }}%>
                                        </ul>
                                    </div>
                                </li>
                            </ul>

                        </span>
            <%}%>
            <div class="d-flex order-lg-2 ml-auto">
                <div class="dropdown">
                    <a href="#" class="nav-link pr-0 leading-none" data-toggle="dropdown">
                        <span class="fa fa-user" style="font-size: 30px"></span>
                    <span class="ml-2 d-none d-lg-block">
                      <span class="text-white"><%=userBean.getFullName().replaceAll("null", "")%></span>
                      <small class="text-white d-block mt-1"><%=userBean.getCurrentRole().getRoleName()%></small>
                      <small class="text-white d-block mt-1"><%=userBean.getLocationName()%> Court</small>
                    </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                        <a class="dropdown-item" href="<c:url value="https://www.citizenservices.gov.bt/documents/20122/0/Judiciary+Services.pdf/f9d53d81-2d01-7c7d-9b2d-8012e06c0ec5?t=1604728319906"/>" target="_blank">
                            <i class="dropdown-icon fe fe-help-circle"></i> Need help?
                        </a>
                        <a class="dropdown-item" href="<c:url value="/login/SignOut"/>" style="color:#71dd8a;">
                            <i class="dropdown-icon fe fe-log-out"></i>Sign out
                        </a>
                    </div>
                </div>
            </div>
            <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse"
               data-target="#headerMenuCollapse"> <span class="header-toggler-icon"></span>
            </a>
        </div>
    </div>
</div>
<%--<script>
    if($('#notary').select()){
        majdjkakd

    }
</script>--%>
