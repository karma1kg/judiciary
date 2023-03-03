package com.spring.mvc.judiciary.dao;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.*;
import com.spring.mvc.judiciary.entity.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wso2.client.model.G2C_CommonBusinessAPI.JurisdictionObj;
import org.wso2.client.model.G2C_CommonBusinessAPI.UserRolePrivilegeHierarchyObj;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class CommonDao extends BaseDao {
    @Transactional(readOnly = true)
    public List<DropdownDTO> getAllReligion() {
        String sqlQuery = this.properties.getProperty("CommonDao.getAllReligion");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getAllCourt() {
        String sqlQuery = this.properties.getProperty("CommonDao.getAllCourt");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getDzongkhagList() {
        String sqlQuery = this.properties.getProperty("CommonDao.getDzongkhagList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getGewogList() {
        String sqlQuery = this.properties.getProperty("CommonDao.getGewogList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getVillageList() {
        String sqlQuery = this.properties.getProperty("CommonDao.getVillageList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getGewogListName(Integer dzoId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getGewogListName");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        hQuery.setParameter("dzoId", dzoId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getVillageListName(Integer gewogId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getVillageListName");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        hQuery.setParameter("gewogId", gewogId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getAllCourtOffline(Integer courtId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getAllCourtOffline");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        hQuery.setParameter("courtId", courtId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getAuthType() {
        String sqlQuery = this.properties.getProperty("CommonDao.getAuthType");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getAllCountry() {
        String sqlQuery = this.properties.getProperty("CommonDao.getAllCountry");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> documentList() {
        String sqlQuery = this.properties.getProperty("CommonDao.documentList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getRequiredDocumentList(String Service_Id) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getRequiredDocumentList");
            Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
            hQuery.setParameter("Service_Id", Service_Id);
            return hQuery.list().isEmpty() ? null : hQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getRelationshiptList() {
        String sqlQuery = this.properties.getProperty("CommonDao.getRelationshiptList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public String getCourtName(String courtId) {
        String courtName="";
        try{
        String sqlQuery = this.properties.getProperty("CommonDao.getCourtName");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        courtName= (String)hQuery.uniqueResult();
    }
        catch (Exception e){
        e.printStackTrace();
        }
        return courtName;
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getServiceName() {
        String sqlQuery = this.properties.getProperty("CommonDao.getServiceName");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getServiceNamePrint() {
        String sqlQuery = this.properties.getProperty("CommonDao.getServiceNamePrint");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public String getApplicationSerial(Integer globalServiceTypeId, String applicationYear, String applicationMonth, String applicationDay, String applicationType) {
        String sqlQuery = this.properties.getProperty("CommonDao.getApplicationSerial");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("globalServiceTypeId", globalServiceTypeId)
                .setParameter("applicationYear", applicationYear)
                .setParameter("applicationMonth", applicationMonth)
                .setParameter("applicationDay", applicationDay)
                .setParameter("applicationType", applicationType);
        return (String)hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveApplication(ApplicationDetail applicationDetail) {
        getReportingSession().saveOrUpdate(applicationDetail);
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveApplicant(ApplicantDetail applicantDetail) {
        try {
            getReportingSession().saveOrUpdate(applicantDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveSpouse(SpouseDetail spouseDetail) {
        try {
            getReportingSession().saveOrUpdate(spouseDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void savePatientDetail(PatientDetail patientDetail) {
        try {
            getReportingSession().saveOrUpdate(patientDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveDonorDetail(DonorDetail donorDetail) {
        try {
            getReportingSession().saveOrUpdate(donorDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveTransferorDetail(TransferorDetail transferorDetail) {
        try {
            getReportingSession().saveOrUpdate(transferorDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveDependentDetail(DependentDetail dependentDetail) {
        try {
            getReportingSession().saveOrUpdate(dependentDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveChildTravelDetail(ChildTravelDetail childTravelDetail) {
        try {
            getReportingSession().saveOrUpdate(childTravelDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveWitness(WitnessDetail witnessDetail) {
        try {
            getReportingSession().saveOrUpdate(witnessDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveWorkFlowDetail(WorkFlowDetail workFlowDetail) {
        try {
            getReportingSession().saveOrUpdate(workFlowDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveTaskDetail(TaskDetail taskDetail) {
        try {
            getReportingSession().saveOrUpdate(taskDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void savePaymentDetail(PaymentDetail paymentDetail) {
        getReportingSession().saveOrUpdate(paymentDetail);
    }

    @Transactional(readOnly = true)
    public Integer getWorkInstanceSerial() {
        Integer result = null;
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getWorkInstanceSerial");
            Query hQuery = sqlQuery(sqlQuery);
            result = (Integer)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Integer getTaskInstanceSerial() {
        Integer result = null;
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getTaskInstanceSerial");
            Query hQuery = sqlQuery(sqlQuery);
            result = (Integer)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Integer getLastPaymentDetailId() {
        String sqlQuery = this.properties.getProperty("CommonDao.getLastPaymentDetailId");
        Query hQuery = sqlQuery(sqlQuery);
        return (Integer)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getApplicationDetail(String applicationNo) {
        try {
            String query = this.properties.getProperty("CommonDao.getApplicationDetail");
            Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            return (ApplicationDetailDTO)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    public ApplicantDetailDTO getApplicantDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getApplicantDetail");
        Query hQuery = hibernateQuery(query, ApplicantDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ApplicantDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public SpouseDetailsDTO getSpouseDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getSpouseDetail");
        Query hQuery = hibernateQuery(query, SpouseDetailsDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (SpouseDetailsDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public ChildMCDTO getChildDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getChildMCDetail");
        Query hQuery = hibernateQuery(query, ChildMCDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ChildMCDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public ChildTravelDetailDTO getChildTravelDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getChildTravelDetail");
        Query hQuery = hibernateQuery(query, ChildTravelDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ChildTravelDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public WitnessDetailDTO getWitnessDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getWitnessDetail");
        Query hQuery = hibernateQuery(query, WitnessDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (WitnessDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public WitnessDetailDTO getWitnessDetail2(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getWitnessDetail2");
        Query hQuery = hibernateQuery(query, WitnessDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (WitnessDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public DonorDTO getDonorDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getDonorDetail");
        Query hQuery = hibernateQuery(query, DonorDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (DonorDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public DonorDepDTO getDonorDepDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getDonorDepDetail");
        Query hQuery = hibernateQuery(query, DonorDepDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (DonorDepDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public OrgFatherDTO getOrgFatherDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getOrgFatherDetail");
        Query hQuery = hibernateQuery(query, OrgFatherDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (OrgFatherDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public OrgMotherDTO getOrgMotherDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getOrgMotherDetail");
        Query hQuery = hibernateQuery(query, OrgMotherDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (OrgMotherDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public PatientDTO getPatientDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getPatientDetail");
        Query hQuery = hibernateQuery(query, PatientDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (PatientDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public TransferorDTO getTransferorDetail(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getTransferorDetail");
        Query hQuery = hibernateQuery(query, TransferorDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (TransferorDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<FileAttachmentDTO> getDocumentDetails(String applicationNo) {
        String query = this.properties.getProperty("CommonDao.getDocumentDetails");
        Query hQuery = hibernateQuery(query, FileAttachmentDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getRejectReasons() {
        String sqlQuery = this.properties.getProperty("CommonDao.getRejectReasons");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public String getRejectReasonByRejectReasonId(String rejectReasonId) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getRejectReasonByRejectReasonId");
            Query hQuery = sqlQuery(sqlQuery);
            hQuery.setParameter("rejectReasonId", rejectReasonId);
            return (String)hQuery.uniqueResult();
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public String validateDuplicateDocument(String cidNo, String indexNo, Integer serviceTypeId, Integer documentTypeId) {
        String sqlQuery = this.properties.getProperty("CommonDao.validateDuplicateDocument");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("cidNo", cidNo)
                .setParameter("indexNo", indexNo)
                .setParameter("serviceTypeId", serviceTypeId)
                .setParameter("documentTypeId", documentTypeId);
        return (String)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public String getDocumentName(Integer documentTypeId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getDocumentName");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("documentTypeId", documentTypeId);
        return (String)hQuery.uniqueResult();
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updatePrintStatus(String applicationNo) {
        String sqlQuery = this.properties.getProperty("CommonDao.updatePrintStatus");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("applicationNo", applicationNo);
        hQuery.executeUpdate();
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveAttachFile(FileAttachment fileAttachment) {
        try {
            getReportingSession().saveOrUpdate(fileAttachment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveChildMcDetail(ChildMcDetail childMcDetail) {
        try {
            getReportingSession().save(childMcDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public List<FileAttachmentDTO> getAttachedFiles(String applicationNo) {
        String sqlQuery = this.properties.getProperty("CommonDao.getAttachedFiles");
        Query hQuery = hibernateQuery(sqlQuery, FileAttachmentDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public FileAttachmentDTO downloadFile(Integer documentId) {
        FileAttachmentDTO fileAttachmentDTO = new FileAttachmentDTO();
        try {
            String sql = this.properties.getProperty("CommonDao.downloadFile");
            Query hQuery = hibernateQuery(sql, FileAttachmentDTO.class);
            hQuery.setParameter("documentId", documentId);
            fileAttachmentDTO = (FileAttachmentDTO)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileAttachmentDTO;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateAppoinmentDate(String applicationNo, String appoinmentDate, String appoinmentTime) {
        String sqlQuery = this.properties.getProperty("CommonDao.updateAppoinmentDate");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("applicationNo", applicationNo);
        hQuery.setParameter("appoinmentDate", appoinmentDate);
        hQuery.setParameter("appoinmentTime", appoinmentTime);
        hQuery.executeUpdate();
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean updatePaymentOnline(ApplicationDetailDTO applicationDetailDTO) {
        int save = 0;
        String paymentDate = applicationDetailDTO.getReceiptDateOnline();
        Date date1 = null;
        try {
            date1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(paymentDate);
            String sqlQuery = this.properties.getProperty("CommonDao.updatePaymentOnline");
            Query hQuery = hibernateQuery(sqlQuery);
            hQuery.setParameter("applicationNo", applicationDetailDTO.getApplicationNo());
            hQuery.setParameter("txnId", applicationDetailDTO.getReceiptNo());
            hQuery.setParameter("paymentDate", date1);
            hQuery.setParameter("txnAmount", applicationDetailDTO.getReceiptAmount());
            save = hQuery.executeUpdate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (save > 0)
            return true;
        return false;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateWorkFlowPayment(ApplicationDetailDTO applicationDetailDTO) {
        String sqlQuery = this.properties.getProperty("CommonDao.updateWorkFlowPayment");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("applicationNo", applicationDetailDTO.getApplicationNo());
        hQuery.executeUpdate();
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateTaskFlowPayment(ApplicationDetailDTO applicationDetailDTO) {
        String sqlQuery = this.properties.getProperty("CommonDao.updateTaskFlowPayment");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("applicationNo", applicationDetailDTO.getApplicationNo());
        hQuery.executeUpdate();
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getPaymentDetails(String serviceId) {
        String query = this.properties.getProperty("CommonDao.getPaymentDetails");
        Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
        hQuery.setParameter("serviceId", serviceId);
        return (ApplicationDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public CitizenDetailDTO getAgencyCode(String courtId) {
        String query = this.properties.getProperty("CommonDao.getAgencyCode");
        Query hQuery = hibernateQuery(query, CitizenDetailDTO.class);
        hQuery.setParameter("courtId", courtId);
        return (CitizenDetailDTO)hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public Integer checkForAlreadyExistApplicant(String cidNo, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkForAlreadyExistApplicant");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("cidNo", cidNo).setParameter("serviceId", serviceId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public Integer checkPreviousJudgementNo(String judgementNo, String serviceId, String courtId, String applicationYear) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkPreviousJudgementNo");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("judgementNo", judgementNo).setParameter("serviceId", serviceId).setParameter("courtId", courtId).setParameter("applicationYear", applicationYear);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public Integer checkPreviousRegistrationNo(String regNo, String serviceId, String courtId, String applicationYear) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkPreviousRegistrationNo");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("regNo", regNo).setParameter("serviceId", serviceId).setParameter("courtId", courtId).setParameter("applicationYear", applicationYear);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public Integer checkForAlreadyExistSpouse(String cidNo, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkForAlreadyExistSpouse");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("cidNo", cidNo).setParameter("serviceId", serviceId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public Integer checkForAlreadyAssigned(String appoinmentDate, String appoinmentTime) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkForAlreadyAssigned");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("appoinmentDate", appoinmentDate).setParameter("appoinmentTime", appoinmentTime);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public DropdownDTO getServiceNameCheck(String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getServiceNameCheck");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        hQuery.setParameter("serviceId", serviceId);
        return (DropdownDTO)hQuery.uniqueResult();
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveHusbandMCDetail(HusbandMCDetail husbandMCDetail) {
        getReportingSession().saveOrUpdate(husbandMCDetail);
    }

    @Transactional(value = "txManager", rollbackFor = {Exception.class})
    public void saveWifeMCDetail(WifeMCDetail wifeMCDetail) {
        getReportingSession().saveOrUpdate(wifeMCDetail);
    }

    public String getCourtPhoneNo(UserRolePrivilegeDto userBean) {
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        String sqlQuery = this.properties.getProperty("CommonDao.getCourtPhoneNo");
        Query hQuery = sqlQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return (String)hQuery.uniqueResult();
    }

    public Integer getGroupTaskSubmitted(UserRolePrivilegeHierarchyObj dto) {
        Integer courtId = ((JurisdictionObj)dto.getJurisdictions().getJurisdiction().get(0)).getLocationId();
        String sqlQuery = this.properties.getProperty("CommonDao.getGroupTaskSubmitted");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    public Integer getMyTaskSubmitted(UserRolePrivilegeHierarchyObj dto) {
        Integer courtId = ((JurisdictionObj)dto.getJurisdictions().getJurisdiction().get(0)).getLocationId();
        String sqlQuery = this.properties.getProperty("CommonDao.getMyTaskSubmitted");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    public Integer getGroupTaskVerified(UserRolePrivilegeHierarchyObj dto) {
        Integer courtId = ((JurisdictionObj)dto.getJurisdictions().getJurisdiction().get(0)).getLocationId();
        String sqlQuery = this.properties.getProperty("CommonDao.getGroupTaskVerified");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    public Integer getMyTaskVerified(UserRolePrivilegeHierarchyObj dto) {
        Integer courtId = ((JurisdictionObj)dto.getJurisdictions().getJurisdiction().get(0)).getLocationId();
        String sqlQuery = this.properties.getProperty("CommonDao.getMyTaskVerified");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    public Integer getApplicationCount(UserRolePrivilegeHierarchyObj dto, Integer serviceId, Integer status) {
        Integer courtId = ((JurisdictionObj)dto.getJurisdictions().getJurisdiction().get(0)).getLocationId();
        String sqlQuery = "";
        if (status.intValue() == 1) {
            sqlQuery = this.properties.getProperty("CommonDao.getApplicationCount");
        } else if (status.intValue() == 3) {
            sqlQuery = this.properties.getProperty("CommonDao.getApplicationCountVerified");
        }
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("serviceId", serviceId)
                .setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    public Integer getUpdatePaymentCount(UserRolePrivilegeDto dto) {
        String courtId = dto.getJurisdictions()[0].getLocationID();
        String sqlQuery = this.properties.getProperty("CommonDao.getUpdatePaymentCount");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("courtId", courtId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public Integer checkForAlreadyMarriedApplicant(String cidNo, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkForAlreadyMarriedApplicant");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("cidNo", cidNo).setParameter("serviceId", serviceId);
        return Integer.valueOf(((BigInteger)hQuery.uniqueResult()).intValue());
    }

    @Transactional(readOnly = true)
    public int checkForAlreadyMarriedSpouse(String cidNo, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.checkForAlreadyMarriedSpouse");
        Query hQuery = hibernateQuery(sqlQuery).setParameter("cidNo", cidNo).setParameter("serviceId", serviceId);
        return ((BigInteger)hQuery.uniqueResult()).intValue();
    }

    public ApplicantDetailDTO getcidDetails(HttpServletRequest request, String cidNo, ApplicantDetailDTO applicantDetailDTO, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.getcidDetails");
        Query hQuery = hibernateQuery(sqlQuery, ApplicantDetailDTO.class).setParameter("cidNo", cidNo).setParameter("serviceId", serviceId);
        return (ApplicantDetailDTO)hQuery.uniqueResult();
    }

    public ApplicantDetailDTO get_cidDetails(HttpServletRequest request, String spouseCidNo, ApplicantDetailDTO applicantDetailDTO, String serviceId) {
        String sqlQuery = this.properties.getProperty("CommonDao.get_cidDetails");
        Query hQuery = hibernateQuery(sqlQuery, ApplicantDetailDTO.class).setParameter("cidNo", spouseCidNo).setParameter("serviceId", serviceId);
        return (ApplicantDetailDTO)hQuery.uniqueResult();
    }

    public BigInteger getCount(String curent_date, Integer courtId, Integer Service_Sl_NO) {
        BigInteger aa = null;
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getCount");
            Query hQuery = hibernateQuery(sqlQuery);
            hQuery.setParameter(1, curent_date)
                    .setParameter(2, courtId)
                    .setParameter(3, Service_Sl_NO);
            aa = (BigInteger)hQuery.uniqueResult();
        } catch (Exception e) {
            System.out.print(e);
        }
        return aa;
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getRejectOthers() {
        String sqlQuery = this.properties.getProperty("CommonDao.getRejectOthers");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getRejectAttest() {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getRejectAttest");
            Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
            return hQuery.list().isEmpty() ? null : hQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    public String getRejectReasonByRejectReasonIds(Integer rejectReasonId) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getRejectReasonByRejectReasonId");
            Query hQuery = sqlQuery(sqlQuery);
            hQuery.setParameter("rejectReasonId", rejectReasonId);
            return (String)hQuery.uniqueResult();
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public String getRejectReasonOthersById(Integer rejectReasonId) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getRejectReasonOthersById");
            Query hQuery = sqlQuery(sqlQuery);
            hQuery.setParameter("rejectReasonId", rejectReasonId);
            return (String)hQuery.uniqueResult();
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }

    @Transactional(readOnly = true)
    public ApplicantDetailDTO getDivorceDetails(String cidNo) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getDivorceDetailsWithSpouse");
            Query hQuery = hibernateQuery(sqlQuery, ApplicantDetailDTO.class);
            hQuery.setParameter("cidNo", cidNo);
            hQuery.setParameter("scidNo", cidNo);
            return (ApplicantDetailDTO)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getApplicantName() {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getApplicantName");
            Query hQuery = sqlQuery(sqlQuery);
            return hQuery.uniqueResult();
        } catch (Exception e) {
            System.out.print(e);
            return null;
        }
    }

    public Integer checkForMcApplied3Times(String cidNo, String serviceId) {
        Integer aa = Integer.valueOf(0);
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getCountMc");
            Query hQuery = hibernateQuery(sqlQuery);
            hQuery.setParameter(1, cidNo)
                    .setParameter(2, serviceId);
            aa = (Integer)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aa;
    }

    public String getStatusId(String cidNo) {
        String statusId = "";
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getMCStatus");
            Query hQuery = hibernateQuery(sqlQuery);
            hQuery.setParameter(1, cidNo);
            statusId = (String)hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusId;
    }

    public ResponseMessage applicantisDivorced(String cidNo) {
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getApplicantDivorced");
            Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
            hQuery.setParameter(1, cidNo);
            hQuery.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ApplicationDetailDTO> getCreatedDate(String cidNo, String serviceId) {
        List<ApplicationDetailDTO> applicationDetailDTOs = null;
        try {
            String sqlQuery = this.properties.getProperty("CommonDao.getDivorceStatus");
            org.hibernate.Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class).setParameter(1, cidNo)
                    .setParameter(2,serviceId);
            applicationDetailDTOs = hQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationDetailDTOs;
    }

    public List<ApplicationDetailDTO> getMcData(String cidNo) {
        List<ApplicationDetailDTO> applicationDetailDTOList=null;
        try{
            String sqlQuery = this.properties.getProperty("CommonDao.getMcData");
            org.hibernate.Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class)
                    .setParameter(1, cidNo);
            applicationDetailDTOList= hQuery.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return applicationDetailDTOList;
    }
}