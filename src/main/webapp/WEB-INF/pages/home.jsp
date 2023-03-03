<%@ page import="com.spring.mvc.auth.dto.UserRolePrivilegeDto" %>
<%@ page import="com.spring.mvc.auth.dto.Service" %>
<%@ page import="com.spring.mvc.auth.dto.Privilege" %>
<%@ page import="org.wso2.client.model.G2C_CommonBusinessAPI.UserRolePrivilegeHierarchyObj" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="auth" property="principal"/>
<%
    String roleName = "";
    String userId = "";
    if (session.getAttribute("UserRolePrivilege") != null) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) session.getAttribute("UserRolePrivilege");
        String LocationId = "";
        for (int n = 0; n < userBean.getJurisdictions().length; n++) {
            LocationId = userBean.getJurisdictions()[n].getLocationID();
            System.out.println("The location ID" + LocationId);
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
        userId = userBean.getCurrentRole().getRoleName();
        System.out.println("The role ID is = "+userId);
        System.out.println("The role ID is = "+roleName);
    }%>
<html>
<head>
    <title>Judicial Services</title>
    <meta name="decorator" content="/layout/close-layout.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/pages/common/dashBoard.jsp"/>
<%if (roleName.equalsIgnoreCase("26033")){%>
    <jsp:include page="notary/notaryTaskList.jsp"/>
<%}%>
<%if (roleName.equalsIgnoreCase("26034")){%>
    <jsp:include page="dataManager/dataManagerTaskList.jsp"/>
<jsp:include page="common/printCertificate.jsp"/>
<%}%>
<%if (roleName.equalsIgnoreCase("26039")){%>
<jsp:include page="highCourt/nonNationalMarriageCertificate.jsp"/>
<%}%>
</body>
</html>
