package com.spring.mvc.judiciary.dto;

import com.spring.mvc.helper.DropdownDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Project Name: NHDCL.
 * Class Name: CurrentUser.java
 * Description:
 * Created By: Hidhen.
 * Creation Date: 28-Jul-19.
 */
public class CurrentUser implements Serializable {

    //region Private variables

    private RoleDTO currentRole;
    private String userId;
    private String userName;
    private String userType;
    private String userCID;
    private String email;
    private String ccId;
    private String ccName;
    private String ministryId;
    private String ministryCode;
    private String deptCode;
    private String departmentNumber;
    private String cn;
    private String sn;
    private String givenName;
    private String midName;
    private String displayName;
    private String designation;
    private String initials;
    private String mobileNumber;
    private String telephoneNumber;
    private String registeredAddress;
    private String uid;
    private String contact;
    private Date systemOpenDate;
    private Date serverDate;
    private String locationID;
    private String roleName;
    private String roleID;
    private RoleDTO[] roleDTOList;
    private List<DropdownDTO> serviceStatusDropdownList;
    private JurisdictionDTO[] jurisdictionDTOs;

    //endregion

    //region Public getter and setter methods

    public RoleDTO getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(RoleDTO currentRole) {
        this.currentRole = currentRole;
    }

    public String getUserId() {
        return userId;

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserCID() {
        return userCID;
    }

    public void setUserCID(String userCID) {
        this.userCID = userCID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public String getMinistryId() {
        return ministryId;
    }

    public void setMinistryId(String ministryId) {
        this.ministryId = ministryId;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getSystemOpenDate() {
        return systemOpenDate;
    }

    public void setSystemOpenDate(Date systemOpenDate) {
        this.systemOpenDate = systemOpenDate;
    }

    public Date getServerDate() {
        return serverDate;
    }

    public void setServerDate(Date serverDate) {
        this.serverDate = serverDate;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleDTO[] getRoleDTOList() {
        return roleDTOList;
    }

    public void setRoleDTOList(RoleDTO[] roleDTOList) {
        this.roleDTOList = roleDTOList;
    }

    public List<DropdownDTO> getServiceStatusDropdownList() {
        return serviceStatusDropdownList;
    }

    public void setServiceStatusDropdownList(List<DropdownDTO> serviceStatusDropdownList) {
        this.serviceStatusDropdownList = serviceStatusDropdownList;
    }

    public JurisdictionDTO[] getJurisdictionDTOs() {
        return jurisdictionDTOs;
    }

    public void setJurisdictionDTOs(JurisdictionDTO[] jurisdictionDTOs) {
        this.jurisdictionDTOs = jurisdictionDTOs;
    }

//endregion

}
