package com.spring.mvc.judiciary.dao;

import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by USER on 9/13/2019.
 */
@Repository
public class PrintCertificateDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getCertificateListMC(Integer serviceId, String courtId) {
        String sqlQuery = properties.getProperty("PrintCertificateDao.getCertificateListMC");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("serviceId", serviceId);
        hQuery.setParameter("courtId", courtId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getCertificateList(Integer serviceId, String courtId) {
        String sqlQuery = properties.getProperty("PrintCertificateDao.getCertificateList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("serviceId", serviceId);
        hQuery.setParameter("courtId", courtId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public ApplicantDetailDTO getHusbandDetail(String applicationNo) {
        String sqlQuery = properties.getProperty("PrintCertificateDao.getHusbandDetail");
        Query hQuery = hibernateQuery(sqlQuery, ApplicantDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ApplicantDetailDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public SpouseDetailsDTO getWifeDetail(String applicationNo) {
        String sqlQuery = properties.getProperty("PrintCertificateDao.getWifeDetail");
        Query hQuery = hibernateQuery(sqlQuery, SpouseDetailsDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (SpouseDetailsDTO) hQuery.uniqueResult();
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getPrintApplicationDetailMC(String applicationNo) {
        String sqlQuery = properties.getProperty("PrintCertificateDao.getPrintApplicationDetailMC");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("applicationNo", applicationNo);
        return (ApplicationDetailDTO) hQuery.uniqueResult();
    }
}
