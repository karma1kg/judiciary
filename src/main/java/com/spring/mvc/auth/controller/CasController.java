package com.spring.mvc.auth.controller;

import bt.gov.g2c.framework.common.vo.UserRolePrivilege;
import com.spring.mvc.auth.dto.*;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wso2.client.model.G2C_CommonBusinessAPI.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/*
for cas log in
 */
@Controller
@RequestMapping({ "/login" })
public class CasController
{
    @Autowired
    CommonService services;

    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    public String login(final HttpServletRequest request, @RequestParam(value = "roleCode", required = false) Integer roleCode) {
        final HttpSession session = request.getSession();
        String uid = null;
        Role currentRole = null;
        final int userRoleId = 0;
        final String LocationId = "";
        final String Juri_Type_Id = "";
        UserRolePrivilege userRolePrivilege = new UserRolePrivilege();
        if (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) {
            uid = request.getUserPrincipal().getName();
        }
        else if (request.getParameter("username") != null) {
            uid = request.getParameter("username");
        }
        final String roleId = String.valueOf(roleCode);
        if (session.getAttribute("userdetail") == null && uid != null) {
            userRolePrivilege.setUserId(uid);
            userRolePrivilege = this.services.populateUserRolePrivilegeHierarchy(userRolePrivilege, roleId, request);
            final UserRolePrivilegeHierarchyObj userRolePrivilegeHierarchyObj = new UserRolePrivilegeHierarchyObj();
            final bt.gov.g2c.framework.common.vo.Jurisdiction[] jurisdictions = userRolePrivilege.getJurisdictions();
            userRolePrivilegeHierarchyObj.setFullName(userRolePrivilege.getUserName());
            userRolePrivilegeHierarchyObj.setUserType(userRolePrivilege.getUserType());
            userRolePrivilegeHierarchyObj.setEmail(userRolePrivilege.getEmail());
            userRolePrivilegeHierarchyObj.setCid(userRolePrivilege.getUserCID());
            userRolePrivilegeHierarchyObj.setMobile(userRolePrivilege.getMobileNumber());
            final int jurisdictionLength = userRolePrivilege.getJurisdictions().length;
            final List<JurisdictionObj> deptJurisdictionList = new ArrayList<JurisdictionObj>();
            final JurisdictionsObj jurisdictionsObj = new JurisdictionsObj();
            for (int h = 0; h < jurisdictionLength; ++h) {
                final JurisdictionObj jurisdictionObj = new JurisdictionObj();
                if (jurisdictions[h].getLocationID() != null) {
                    jurisdictionObj.setLocationId(Integer.valueOf(Integer.parseInt(jurisdictions[h].getLocationID())));
                }
                jurisdictionObj.setJurisdiction(jurisdictions[h].getJurisdiction());
                jurisdictionObj.setJurisdictionId(Integer.valueOf(jurisdictions[h].getJurisdictionType()));
                deptJurisdictionList.add(jurisdictionObj);
                jurisdictionsObj.setJurisdiction((List)deptJurisdictionList);
                userRolePrivilegeHierarchyObj.setJurisdictions(jurisdictionsObj);
            }
            final int roleLength = userRolePrivilege.getRoles().length;
            final UserRolesObj userRolesObj = new UserRolesObj();
            final List<UserRoleObj> deptRoleList = new ArrayList<UserRoleObj>();
            for (int j = 0; j < roleLength; ++j) {
                final UserRoleObj userRoleObj = new UserRoleObj();
                userRoleObj.setRoleId(Integer.valueOf(Integer.parseInt(userRolePrivilege.getRoles()[j].getRoleId())));
                if (userRolePrivilege.getRoles()[j].getRoleName().equalsIgnoreCase("CC Operator")) {
                    userRoleObj.setRoleName("CC_Operator");
                }
                else {
                    userRoleObj.setRoleName(userRolePrivilege.getRoles()[j].getRoleName());
                }
                userRoleObj.setRoleDescription(userRolePrivilege.getRoles()[j].getRoleCode());
                if (userRolePrivilege.getRoles()[j].getServices() != null) {
                    final int serviceLength = userRolePrivilege.getRoles()[j].getServices().length;
                    final DeptServicesObj deptServicesObj = new DeptServicesObj();
                    final List<DeptServiceObj> deptServiceList = new ArrayList<DeptServiceObj>();
                    for (int i = 0; i < serviceLength; ++i) {
                        final DeptServiceObj deptServiceObj = new DeptServiceObj();
                        deptServiceObj.setServiceId(Integer.valueOf(Integer.parseInt(userRolePrivilege.getRoles()[j].getServices(i).getServiceId())));
                        deptServiceObj.setServiceName(userRolePrivilege.getRoles()[j].getServices(i).getServiceName());
                        deptServiceObj.setServiceDescription(userRolePrivilege.getRoles()[j].getServices(i).getServiceCode());
                        deptServiceList.add(deptServiceObj);
                        deptServicesObj.setDeptService((List)deptServiceList);
                        final int privilegeLength = userRolePrivilege.getRoles()[j].getServices(i).getPrivileges().length;
                        final ServicePrivilegesObj servicePrivilegesObj = new ServicePrivilegesObj();
                        final List<ServicePrivilegeObj> servicePrivilegeObjList = new ArrayList<ServicePrivilegeObj>();
                        for (int k = 0; k < privilegeLength; ++k) {
                            final ServicePrivilegeObj servicePrivilegeObj = new ServicePrivilegeObj();
                            servicePrivilegeObj.setPrivilegeId(Integer.valueOf(userRolePrivilege.getRoles()[j].getServices()[i].getPrivileges()[k].getPrivilegeId()));
                            servicePrivilegeObj.setPrivilegeName(userRolePrivilege.getRoles()[j].getServices()[i].getPrivileges()[k].getPrivilegeName());
                            servicePrivilegeObj.setPrivilegeDescription(userRolePrivilege.getRoles()[j].getServices()[i].getPrivileges()[k].getPrivilegeCode());
                            servicePrivilegeObjList.add(servicePrivilegeObj);
                            servicePrivilegesObj.setServicePrivilege((List)servicePrivilegeObjList);
                            deptServiceObj.setServicePrivileges(servicePrivilegesObj);
                        }
                        userRoleObj.setDeptServices(deptServicesObj);
                    }
                }
                deptRoleList.add(userRoleObj);
                userRolesObj.setUserRole((List)deptRoleList);
            }
            userRolePrivilegeHierarchyObj.setUserRoles(userRolesObj);
            final UserRolePrivilegeDto dto = new UserRolePrivilegeDto();
            final String fullName = userRolePrivilegeHierarchyObj.getFullName();
            final String cid = userRolePrivilegeHierarchyObj.getCid();
            final String mobileNo = userRolePrivilegeHierarchyObj.getMobile();
            final String emailId = userRolePrivilegeHierarchyObj.getEmail();
            final String userType = userRolePrivilegeHierarchyObj.getUserType();
            final String telephoneNo = userRolePrivilegeHierarchyObj.getTelephone();
            dto.setFullName(fullName);
            dto.setCid(cid);
            dto.setMobileNo(mobileNo);
            dto.setEmailId(emailId);
            dto.setUserType(uid);
            dto.setTelephoneNo(telephoneNo);
            final List<Role> roles = new ArrayList<Role>();
            final UserRolesObj userRoleList1 = userRolePrivilegeHierarchyObj.getUserRoles();
            for (int l = 0; l < userRoleList1.getUserRole().size(); ++l) {
                final Role role = new Role();
                role.setRoleId(String.valueOf(userRoleList1.getUserRole().get(l).getRoleId()));
                role.setRoleCode(userRoleList1.getUserRole().get(l).getRoleDescription());
                role.setRoleName(userRoleList1.getUserRole().get(l).getRoleName());
                final List<Service> services = new ArrayList<Service>();
                if (userRoleList1.getUserRole().get(l).getDeptServices() != null) {
                    final DeptServicesObj deptServicesObj2 = userRoleList1.getUserRole().get(l).getDeptServices();
                    for (int m = 0; m < deptServicesObj2.getDeptService().size(); ++m) {
                        final Service service = new Service();
                        service.setServiceId(String.valueOf(deptServicesObj2.getDeptService().get(m).getServiceId()));
                        service.setServiceCode(deptServicesObj2.getDeptService().get(m).getServiceDescription());
                        service.setServiceName(deptServicesObj2.getDeptService().get(m).getServiceName());
                        final List<Privilege> privileges = new ArrayList<Privilege>();
                        final ServicePrivilegesObj servicePrivilegesObj2 = deptServicesObj2.getDeptService().get(m).getServicePrivileges();
                        for (int k2 = 0; k2 < servicePrivilegesObj2.getServicePrivilege().size(); ++k2) {
                            final Privilege privilege = new Privilege();
                            privilege.setPrivilegeId(String.valueOf(servicePrivilegesObj2.getServicePrivilege().get(k2).getPrivilegeId()));
                            privilege.setPrivilegeCode(servicePrivilegesObj2.getServicePrivilege().get(k2).getPrivilegeDescription());
                            privilege.setPrivilegeName(servicePrivilegesObj2.getServicePrivilege().get(k2).getPrivilegeName());
                            privileges.add(privilege);
                        }
                        service.setPrivileges((Privilege[])privileges.toArray(new Privilege[privileges.size()]));
                        services.add(service);
                    }
                }
                role.setServices((Service[])services.toArray(new Service[services.size()]));
                roles.add(role);
            }
            dto.setRoles((Role[])roles.toArray(new Role[roles.size()]));
            if (roleCode == null) {
                roleCode = 0;
            }
            if (roles != null && roles.size() == 1) {
                dto.setCurrentRole((Role)roles.get(roleCode));
            }
            else if (roles.size() >= 1) {
                currentRole = roles.get(roleCode);
                dto.setCurrentRole(currentRole);
            }
            if (jurisdictions.length >= 1) {
                final List<Jurisdiction> jurisdictions2 = new ArrayList<Jurisdiction>();
                final JurisdictionsObj jurisdictionsObj2 = userRolePrivilegeHierarchyObj.getJurisdictions();
                for (int k3 = 0; k3 < jurisdictionsObj2.getJurisdiction().size(); ++k3) {
                    final Jurisdiction jurisdiction = new Jurisdiction();
                    final JurisdictionObj jurisdictionObj2 = jurisdictionsObj2.getJurisdiction().get(k3);
                    jurisdiction.setJurisdiction(jurisdictionObj2.getJurisdiction());
                    jurisdiction.setJurisdictionType(String.valueOf(jurisdictionObj2.getJurisdictionId()));
                    if (jurisdictionObj2.getLocationId() != null) {
                        jurisdiction.setLocationID(String.valueOf(jurisdictionObj2.getLocationId()));
                    }
                    jurisdictions2.add(jurisdiction);
                }
                dto.setJurisdictions((Jurisdiction[])jurisdictions2.toArray(new Jurisdiction[jurisdictions2.size()]));
                for (int m2 = 0; m2 < dto.getRoles().length; ++m2) {
                    for (int i2 = 0; i2 < dto.getRoles()[m2].getServices().length; ++i2) {
                        final Service svc = dto.getRoles()[m2].getServices()[i2];
                        for (int j2 = 0; j2 < svc.getPrivileges().length; ++j2) {
                            final Privilege privilege2 = svc.getPrivileges()[j2];
                        }
                    }
                }
            }
            final String courtId = dto.getJurisdictions()[0].getLocationID();
            final String courtName = this.services.getCourtName(courtId);
            dto.setLocationName(courtName);
            request.setAttribute("groupCountSubmitted", (Object)this.services.getGroupTaskSubmitted(userRolePrivilegeHierarchyObj));
            request.setAttribute("myCountSubmitted", (Object)this.services.getMyTaskSubmitted(userRolePrivilegeHierarchyObj));
            request.setAttribute("groupCountVerified", (Object)this.services.getGroupTaskVerified(userRolePrivilegeHierarchyObj));
            request.setAttribute("myCountVerified", (Object)this.services.getMyTaskVerified(userRolePrivilegeHierarchyObj));
            request.setAttribute("mcCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 501, 1));
            request.setAttribute("apCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 502, 1));
            request.setAttribute("amCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 503, 1));
            request.setAttribute("ldCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 504, 1));
            request.setAttribute("smCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 505, 1));
            request.setAttribute("ctCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 506, 1));
            request.setAttribute("adCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 507, 1));
            request.setAttribute("caCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 508, 1));
            request.setAttribute("ktCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 509, 1));
            request.setAttribute("saCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 510, 1));
            request.setAttribute("aaCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 511, 1));
            request.setAttribute("nmcCountSubmitted", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 512, 1));
            request.setAttribute("mcCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 501, 3));
            request.setAttribute("apCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 502, 3));
            request.setAttribute("amCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 503, 3));
            request.setAttribute("ldCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 504, 3));
            request.setAttribute("smCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 505, 3));
            request.setAttribute("ctCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 506, 3));
            request.setAttribute("adCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 507, 3));
            request.setAttribute("caCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 508, 3));
            request.setAttribute("ktCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 509, 3));
            request.setAttribute("saCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 510, 3));
            request.setAttribute("aaCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 511, 3));
            request.setAttribute("nmcCountVerified", (Object)this.services.getApplicationCount(userRolePrivilegeHierarchyObj, 512, 3));
            request.setAttribute("paymentCount", (Object)this.services.getUpdatePaymentCount(dto));
            session.setAttribute("UserRolePrivilege", (Object)dto);
            session.setAttribute("uid", (Object)request.getUserPrincipal().getName());
            session.setAttribute("userid", (Object)request.getParameter("username"));
        }
        return "common/dashBoard";
    }

    /**
     * cas log out
     * @param request request
     * @return redirect to cas login
     */

    @RequestMapping(value = { "/SignOut" }, method = { RequestMethod.GET })
    public String logout(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:https://www.citizenservices.gov.bt/cas/login";
    }
}
