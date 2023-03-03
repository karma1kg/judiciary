package com.spring.mvc.judiciary.dao;

import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by USER on 8/22/2019.
 */
@Repository
public class TrackApplicationDao extends BaseDao {
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetail(String applicationNo) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetail");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailMC(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailMC");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailAP(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailAP");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailAM(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailAM");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailLD(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailAM");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailSM(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailSM");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailCD(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailCD");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailAD(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailAD");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailCA(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailCA");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailKT(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailKT");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailCT(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailCT");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailAA(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailAA");
            org.hibernate.Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public ApplicationDetailDTO getTrackApplicationDetailDA(String applicationNo, String serviceId) {
        try {
            String query = properties.getProperty("TrackApplicationDao.getTrackApplicationDetailDA");
            org.hibernate

                    .Query hQuery = hibernateQuery(query, ApplicationDetailDTO.class);
            hQuery.setParameter("applicationNo", applicationNo);
            hQuery.setParameter("cidNo", applicationNo);
            hQuery.setParameter("serviceId", serviceId);
            return (ApplicationDetailDTO) hQuery.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}




