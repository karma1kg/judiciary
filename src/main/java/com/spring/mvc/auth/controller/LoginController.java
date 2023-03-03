package com.spring.mvc.auth.controller;

import com.spring.mvc.auth.dto.*;
import com.spring.mvc.judiciary.entity.Token;
import com.spring.mvc.judiciary.service.APIService;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wso2.client.api.ApiClient;
import org.wso2.client.api.G2C_CommonBusinessAPI.DefaultApi;
import org.wso2.client.model.G2C_CommonBusinessAPI.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * rediect to cas login
 */
@Controller
@RequestMapping({ "/loginSSO" })
public class LoginController
{
    @Autowired
    private APIService api;
    @Autowired
    private CommonService commonService;

    /**
     *
     * @param request api for user and department details
     * @param model
     * @return cas login page
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    public String login(final HttpServletRequest request, final ModelMap model) throws ServletException, IOException {
        final ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        final String getUserDetails = resourceBundle1.getString("getUserDetails.endPointURL");
        final String deptshortcode = resourceBundle1.getString("getDeptCode.endPointURL");
        Role currentRole = null;
        final UserRolePrivilegeDto dto = new UserRolePrivilegeDto();
        int userRoleId = 0;
        String LocationId = "";
        String Juri_Type_Id = "";
        final HttpSession session = request.getSession();
        try {
            if (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) {
                final String uid = request.getUserPrincipal().getName();
                final OkHttpClient httpClient = new OkHttpClient();
                httpClient.setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
                httpClient.setReadTimeout(10000L, TimeUnit.MILLISECONDS);
                final ApiClient apiClient = new ApiClient();
                apiClient.setHttpClient(httpClient);
                apiClient.setBasePath(getUserDetails);
                final Token token = this.api.getApplicationToken();
                apiClient.setAccessToken(token.getAccess_token());
                final DefaultApi api = new DefaultApi(apiClient);
                final UserRolePrivilegeHierarchyResponse userRolePrivilegeResponse = api.userroleprivilegehierarchyUseridDeptshortcodeGet(uid, deptshortcode);
                UserRolePrivilegeHierarchyObj userRolePrivilegeObj = null;
                if (userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy() != null && !userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy().isEmpty()) {
                    userRolePrivilegeObj = userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy().get(0);
                    final String fullName = userRolePrivilegeObj.getFullName();
                    final String cid = userRolePrivilegeObj.getCid();
                    final String mobileNo = userRolePrivilegeObj.getMobile();
                    final String emailId = userRolePrivilegeObj.getEmail();
                    final String userType = userRolePrivilegeObj.getUserType();
                    final String telephoneNo = userRolePrivilegeObj.getTelephone();
                    dto.setFullName(fullName);
                    dto.setCid(cid);
                    dto.setMobileNo(mobileNo);
                    dto.setEmailId(emailId);
                    dto.setUserType(uid);
                    dto.setTelephoneNo(telephoneNo);
                    final List<Role> roles = new ArrayList<Role>();
                    final UserRolesObj userRoleList = userRolePrivilegeObj.getUserRoles();
                    for (int i = 0; i < userRoleList.getUserRole().size(); ++i) {
                        final UserRoleObj userRole = userRoleList.getUserRole().get(i);
                        final int roleId = userRole.getRoleId();
                        final String roleName = userRole.getRoleName();
                        final String roleDescription = userRole.getRoleDescription();
                        final Role role = new Role();
                        userRoleId = roleId;
                        role.setRoleId(Integer.toString(roleId));
                        role.setRoleCode(roleDescription);
                        role.setRoleName(roleName);
                        final List<Service> services = new ArrayList<Service>();
                        final DeptServicesObj deptServicesObj = userRole.getDeptServices();
                        for (int j = 0; j < deptServicesObj.getDeptService().size(); ++j) {
                            final DeptServiceObj deptServiceObj = deptServicesObj.getDeptService().get(j);
                            final int serviceId = deptServiceObj.getServiceId();
                            final String serviceName = deptServiceObj.getServiceName();
                            final String serviceDescription = deptServiceObj.getServiceDescription();
                            final Service service = new Service();
                            service.setServiceId(Integer.toString(serviceId));
                            service.setServiceCode(serviceDescription);
                            service.setServiceName(serviceName);
                            final List<Privilege> privileges = new ArrayList<Privilege>();
                            final ServicePrivilegesObj servicePrivilegesObj = deptServiceObj.getServicePrivileges();
                            for (int k = 0; k < servicePrivilegesObj.getServicePrivilege().size(); ++k) {
                                final ServicePrivilegeObj servicePrivilegeObj = servicePrivilegesObj.getServicePrivilege().get(k);
                                final int privilegeId = servicePrivilegeObj.getPrivilegeId();
                                final String privilegeName = servicePrivilegeObj.getPrivilegeName();
                                final String privilegeDescription = servicePrivilegeObj.getPrivilegeDescription();
                                final Privilege privilege = new Privilege();
                                privilege.setPrivilegeId(Integer.toString(privilegeId));
                                privilege.setPrivilegeCode(privilegeDescription);
                                privilege.setPrivilegeName(privilegeName);
                                privileges.add(privilege);
                            }
                            service.setPrivileges((Privilege[])privileges.toArray(new Privilege[privileges.size()]));
                            services.add(service);
                        }
                        role.setServices((Service[])services.toArray(new Service[services.size()]));
                        roles.add(role);
                    }
                    dto.setRoles((Role[])roles.toArray(new Role[roles.size()]));
                    if (roles != null && roles.size() == 1) {
                        dto.setCurrentRole((Role)roles.get(0));
                    }
                    else if (roles.size() > 1) {
                        currentRole = roles.get(0);
                        dto.setCurrentRole(currentRole);
                    }
                    final List<Jurisdiction> jurisdictions = new ArrayList<Jurisdiction>();
                    final JurisdictionsObj jurisdictionsObj = userRolePrivilegeObj.getJurisdictions();
                    for (int l = 0; l < jurisdictionsObj.getJurisdiction().size(); ++l) {
                        final JurisdictionObj jurisdictionObj = jurisdictionsObj.getJurisdiction().get(l);
                        final Jurisdiction jurisdiction = new Jurisdiction();
                        jurisdiction.setJurisdiction(Integer.toString(jurisdictionObj.getJurisdictionId()));
                        jurisdiction.setJurisdictionType(jurisdictionObj.getJurisdiction());
                        jurisdiction.setLocationID(Integer.toString(jurisdictionObj.getLocationId()));
                        jurisdictions.add(jurisdiction);
                    }
                    dto.setJurisdictions((Jurisdiction[])jurisdictions.toArray(new Jurisdiction[jurisdictions.size()]));
                    for (int m = 0; m < dto.getRoles().length; ++m) {
                        for (int i2 = 0; i2 < dto.getRoles()[m].getServices().length; ++i2) {
                            final Service svc = dto.getCurrentRole().getServices()[i2];
                            for (int j2 = 0; j2 < svc.getPrivileges().length; ++j2) {
                                final Privilege privilege2 = svc.getPrivileges()[j2];
                            }
                        }
                    }
                    for (int n = 0; n < dto.getJurisdictions().length; ++n) {
                        LocationId = dto.getJurisdictions()[n].getLocationID();
                        Juri_Type_Id = dto.getJurisdictions()[n].getJurisdiction();
                    }
                    final String courtId = dto.getJurisdictions()[0].getLocationID();
                    final String courtName = this.commonService.getCourtName(courtId);
                    dto.setLocationName(courtName);
                    request.setAttribute("groupCountSubmitted", (Object)this.commonService.getGroupTaskSubmitted(userRolePrivilegeObj));
                    request.setAttribute("myCountSubmitted", (Object)this.commonService.getMyTaskSubmitted(userRolePrivilegeObj));
                    request.setAttribute("groupCountVerified", (Object)this.commonService.getGroupTaskVerified(userRolePrivilegeObj));
                    request.setAttribute("myCountVerified", (Object)this.commonService.getMyTaskVerified(userRolePrivilegeObj));
                    request.setAttribute("mcCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 501, 1));
                    request.setAttribute("apCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 502, 1));
                    request.setAttribute("amCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 503, 1));
                    request.setAttribute("ldCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 504, 1));
                    request.setAttribute("smCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 505, 1));
                    request.setAttribute("ctCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 506, 1));
                    request.setAttribute("adCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 507, 1));
                    request.setAttribute("caCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 508, 1));
                    request.setAttribute("ktCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 509, 1));
                    request.setAttribute("ctCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 510, 1));
                    request.setAttribute("aaCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 511, 1));
                    request.setAttribute("mcCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 501, 6));
                    request.setAttribute("apCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 502, 6));
                    request.setAttribute("amCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 503, 6));
                    request.setAttribute("ldCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 504, 6));
                    request.setAttribute("smCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 505, 6));
                    request.setAttribute("ctCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 506, 6));
                    request.setAttribute("adCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 507, 6));
                    request.setAttribute("caCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 508, 6));
                    request.setAttribute("ktCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 509, 6));
                    request.setAttribute("ctCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 510, 6));
                    request.setAttribute("aaCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 511, 6));
                    session.setAttribute("UserRolePrivilege", (Object)dto);
                    session.setAttribute("uid", (Object)request.getUserPrincipal().getName());
                    return "common/dashBoard";
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error at GetUserDetails[doAction]" + e);
        }
        return "common/dashBoard";
    }

    @RequestMapping({ "/homePage" })
    public String homePage(final HttpServletRequest request, @RequestParam("userId") final String userId) throws ServletException, IOException {
        Role currentRole = null;
        final UserRolePrivilegeDto dto = new UserRolePrivilegeDto();
        int userRoleId = 0;
        String LocationId = "";
        String Juri_Type_Id = "";
        final String uid = "";
        final HttpSession session = request.getSession();
        final ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        final String getUserDetails = resourceBundle1.getString("getUserDetails.endPointURL");
        final String getDeptCode = resourceBundle1.getString("getDeptCode.endPointURL");
        try {
            request.setAttribute("userId", (Object)userId);
            final OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000L, TimeUnit.MILLISECONDS);
            final ApiClient apiClient = new ApiClient();
            apiClient.setHttpClient(httpClient);
            apiClient.setBasePath(getUserDetails);
            final Token token = this.api.getApplicationToken();
            apiClient.setAccessToken(token.getAccess_token());
            final DefaultApi api = new DefaultApi(apiClient);
            final UserRolePrivilegeHierarchyResponse userRolePrivilegeResponse = api.userroleprivilegehierarchyUseridDeptshortcodeGet(userId, getDeptCode);
            UserRolePrivilegeHierarchyObj userRolePrivilegeObj = null;
            if (userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy() != null && !userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy().isEmpty()) {
                userRolePrivilegeObj = userRolePrivilegeResponse.getUserRolePrivilegeHierarchyResponse().getUserRolePrivilegeHierarchy().get(0);
                final String fullName = userRolePrivilegeObj.getFullName();
                final String cid = userRolePrivilegeObj.getCid();
                final String mobileNo = userRolePrivilegeObj.getMobile();
                final String emailId = userRolePrivilegeObj.getEmail();
                final String userType = userRolePrivilegeObj.getUserType();
                final String telephoneNo = userRolePrivilegeObj.getTelephone();
                dto.setFullName(fullName);
                dto.setCid(cid);
                dto.setMobileNo(mobileNo);
                dto.setEmailId(emailId);
                dto.setUserType(userId);
                dto.setTelephoneNo(telephoneNo);
                final List<Role> roles = new ArrayList<Role>();
                final UserRolesObj userRoleList = userRolePrivilegeObj.getUserRoles();
                for (int i = 0; i < userRoleList.getUserRole().size(); ++i) {
                    final UserRoleObj userRole = userRoleList.getUserRole().get(i);
                    final int roleId = userRole.getRoleId();
                    final String roleName = userRole.getRoleName();
                    final String roleDescription = userRole.getRoleDescription();
                    final Role role = new Role();
                    userRoleId = roleId;
                    role.setRoleId(Integer.toString(roleId));
                    role.setRoleCode(roleDescription);
                    role.setRoleName(roleName);
                    final List<Service> services = new ArrayList<Service>();
                    final DeptServicesObj deptServicesObj = userRole.getDeptServices();
                    for (int j = 0; j < deptServicesObj.getDeptService().size(); ++j) {
                        final DeptServiceObj deptServiceObj = deptServicesObj.getDeptService().get(j);
                        final int serviceId = deptServiceObj.getServiceId();
                        final String serviceName = deptServiceObj.getServiceName();
                        final String serviceDescription = deptServiceObj.getServiceDescription();
                        final Service service = new Service();
                        service.setServiceId(Integer.toString(serviceId));
                        service.setServiceCode(serviceDescription);
                        service.setServiceName(serviceName);
                        final List<Privilege> privileges = new ArrayList<Privilege>();
                        final ServicePrivilegesObj servicePrivilegesObj = deptServiceObj.getServicePrivileges();
                        for (int k = 0; k < servicePrivilegesObj.getServicePrivilege().size(); ++k) {
                            final ServicePrivilegeObj servicePrivilegeObj = servicePrivilegesObj.getServicePrivilege().get(k);
                            final int privilegeId = servicePrivilegeObj.getPrivilegeId();
                            final String privilegeName = servicePrivilegeObj.getPrivilegeName();
                            final String privilegeDescription = servicePrivilegeObj.getPrivilegeDescription();
                            final Privilege privilege = new Privilege();
                            privilege.setPrivilegeId(Integer.toString(privilegeId));
                            privilege.setPrivilegeCode(privilegeDescription);
                            privilege.setPrivilegeName(privilegeName);
                            privileges.add(privilege);
                        }
                        service.setPrivileges((Privilege[])privileges.toArray(new Privilege[privileges.size()]));
                        services.add(service);
                    }
                    role.setServices((Service[])services.toArray(new Service[services.size()]));
                    roles.add(role);
                }
                dto.setRoles((Role[])roles.toArray(new Role[roles.size()]));
                if (roles != null && roles.size() == 1) {
                    dto.setCurrentRole((Role)roles.get(0));
                }
                else if (roles.size() > 1) {
                    currentRole = roles.get(0);
                    dto.setCurrentRole(currentRole);
                }
                final List<Jurisdiction> jurisdictions = new ArrayList<Jurisdiction>();
                final JurisdictionsObj jurisdictionsObj = userRolePrivilegeObj.getJurisdictions();
                for (int l = 0; l < jurisdictionsObj.getJurisdiction().size(); ++l) {
                    final JurisdictionObj jurisdictionObj = jurisdictionsObj.getJurisdiction().get(l);
                    final Jurisdiction jurisdiction = new Jurisdiction();
                    jurisdiction.setJurisdiction(Integer.toString(jurisdictionObj.getJurisdictionId()));
                    jurisdiction.setJurisdictionType(jurisdictionObj.getJurisdiction());
                    jurisdiction.setLocationID(Integer.toString(jurisdictionObj.getLocationId()));
                    jurisdictions.add(jurisdiction);
                }
                dto.setJurisdictions((Jurisdiction[])jurisdictions.toArray(new Jurisdiction[jurisdictions.size()]));
                for (int m = 0; m < dto.getRoles().length; ++m) {
                    for (int i2 = 0; i2 < dto.getRoles()[m].getServices().length; ++i2) {
                        final Service svc = dto.getCurrentRole().getServices()[i2];
                        for (int j2 = 0; j2 < svc.getPrivileges().length; ++j2) {
                            final Privilege privilege2 = svc.getPrivileges()[j2];
                        }
                    }
                }
                for (int n = 0; n < dto.getJurisdictions().length; ++n) {
                    LocationId = dto.getJurisdictions()[n].getLocationID();
                    Juri_Type_Id = dto.getJurisdictions()[n].getJurisdiction();
                }
                final String courtId = dto.getJurisdictions()[0].getLocationID();
                final String courtName = this.commonService.getCourtName(courtId);
                dto.setLocationName(courtName);
                request.setAttribute("groupCountSubmitted", (Object)this.commonService.getGroupTaskSubmitted(userRolePrivilegeObj));
                request.setAttribute("myCountSubmitted", (Object)this.commonService.getMyTaskSubmitted(userRolePrivilegeObj));
                request.setAttribute("groupCountVerified", (Object)this.commonService.getGroupTaskVerified(userRolePrivilegeObj));
                request.setAttribute("myCountVerified", (Object)this.commonService.getMyTaskVerified(userRolePrivilegeObj));
                request.setAttribute("mcCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 501, 1));
                request.setAttribute("apCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 502, 1));
                request.setAttribute("amCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 503, 1));
                request.setAttribute("ldCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 504, 1));
                request.setAttribute("smCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 505, 1));
                request.setAttribute("ctCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 506, 1));
                request.setAttribute("adCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 507, 1));
                request.setAttribute("caCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 508, 1));
                request.setAttribute("ktCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 509, 1));
                request.setAttribute("ctCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 510, 1));
                request.setAttribute("aaCountSubmitted", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 511, 1));
                request.setAttribute("mcCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 501, 6));
                request.setAttribute("apCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 502, 6));
                request.setAttribute("amCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 503, 6));
                request.setAttribute("ldCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 504, 6));
                request.setAttribute("smCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 505, 6));
                request.setAttribute("ctCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 506, 6));
                request.setAttribute("adCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 507, 6));
                request.setAttribute("caCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 508, 6));
                request.setAttribute("ktCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 509, 6));
                request.setAttribute("ctCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 510, 6));
                request.setAttribute("aaCountVerified", (Object)this.commonService.getApplicationCount(userRolePrivilegeObj, 511, 6));
                session.setAttribute("UserRolePrivilege", (Object)dto);
                session.setAttribute("UserId", (Object)request.getParameter("userId"));
                return "common/dashBoard";
            }
        }
        catch (Exception e) {
            System.out.println("Error at GetUserDetails[doAction]" + e);
        }
        return "common/dashBoard";
    }

    /**
     * cas logout
     * @param request
     * @return logs out from cas and redirect to cas log in
     */
    @RequestMapping(value = { "/SignOut" }, method = { RequestMethod.GET })
    public String logout(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:https://www.citizenservices.gov.bt/cas/login";
    }
}