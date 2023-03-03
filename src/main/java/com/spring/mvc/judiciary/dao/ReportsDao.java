package com.spring.mvc.judiciary.dao;

import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 9/12/2019.
 */
@Repository
public class ReportsDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<DropdownDTO> getStatusList() {
        String sqlQuery = properties.getProperty("ReportsDao.getStatusList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getCertificateReport(Integer serviceId, String newFromDate,
                                                                   String newToDate, String statusId, String courtId) {
        String sqlQuery = properties.getProperty("ReportsDao.getCertificateReport");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("serviceId", serviceId)
                .setParameter("fromDate", newFromDate)
                .setParameter("toDate", newToDate)
                .setParameter("statusId", statusId)
                .setParameter("courtId", courtId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getReportByCourt(Integer serviceId, String newFromDate,
                                                                   String newToDate, Integer courtId) {
        List<ApplicationDetailDTO> objects= new ArrayList<ApplicationDetailDTO>();
        try{
         String sqlQuery = properties.getProperty("ReportsDao.getReportByCourt");
         Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
         hQuery.setParameter("courtId", courtId)
                 .setParameter("fromDate", newFromDate)
                 .setParameter("toDate", newToDate)
                 .setParameter("serviceId", serviceId);
         objects= hQuery.list().isEmpty() ? null : hQuery.list();
     }
     catch (Exception e){
         e.printStackTrace();
     }
        return objects;
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getReportByService(String newFromDate, String newToDate,Integer serviceId) {
        List<ApplicationDetailDTO> objects=new ArrayList<ApplicationDetailDTO>();
        try {
            String sqlQuery = properties.getProperty("ReportsDao.getReportByService");
            Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
            hQuery.setParameter("fromDate", newFromDate)
                    .setParameter("toDate", newToDate)
                    .setParameter("serviceId", serviceId);
                   objects= hQuery.list().isEmpty() ? null : hQuery.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return objects;
    }
}
