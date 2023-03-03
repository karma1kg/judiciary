<%@ page import="bt.gov.ditt.sso.client.SSOClientConstants" %>
<%@ page import="bt.gov.ditt.sso.client.dto.UserSessionDetailDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: Sonam Tobgay
  Date: 05-Jun-18
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<jsp:include page="/WEB-INF/pages/rpIFrame.jsp"/>
<%UserSessionDetailDTO userSessionDetailDTO =(UserSessionDetailDTO)request.getSession().getAttribute(SSOClientConstants.SSO_SESSION_OBJ_KEY);%>
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
                    <div class="d-flex order-lg-2 ml-auto">
                        <div class="dropdown">
                            <span>
                            <%if (userSessionDetailDTO!=null){%>
                            <%if(userSessionDetailDTO.getFirstName()!=null && !userSessionDetailDTO.getFirstName().equalsIgnoreCase("null")){%>
                            <a href="#" class="nav-link pr-0 leading-none pt-4" data-toggle="dropdown">
                            <span class="ml-2 d-none d-lg-block">
                              <span class="text-white">
                                  <i class="fas fa-sign-out-alt" style="font-size:25px;color:white">
                                      <%=userSessionDetailDTO.getFirstName().replaceAll("null", "")%>
                                      <%=userSessionDetailDTO.getMiddleName().replaceAll("null", "")%>
                                      <%=userSessionDetailDTO.getLastName().replaceAll("null","")%>
                                  </i>
                              </span>
                            </span>
                            </a>
                            <% }%>
                            <%}else{%>
                            <a href="#" class="nav-link pr-0 leading-none pt-4" data-toggle="dropdown">
                                <i class="fa fa-sign-out" style="font-size:48px;color:red"></i>
                            <span class="ml-2 d-none d-lg-block">
                              <span class="text-white">Sonam Tobgay</span>
                            </span>
                            </a>
                            <%}%>
                            <%--<div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                <a class="dropdown-item" href="<%= userSessionDetailDTO.getOAuth2Client().getLogoutEndpoint()
                                +"?post_logout_redirect_uri="+userSessionDetailDTO.getOAuth2Client().getLogoutCallback()
                                +"&id_token_hint="+userSessionDetailDTO.getIdToken()%>">
                                <i class="dropdown-icon fe fe-log-out"></i>Log out
                                </a>
                            </div>--%>
</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

