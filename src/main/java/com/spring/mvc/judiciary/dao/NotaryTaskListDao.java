package com.spring.mvc.judiciary.dao;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by USER on 8/2/2019.
 */
@Repository
public class NotaryTaskListDao extends BaseDao {
    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO>getNotaryTaskList(String courtId, String serviceId) {
        String sqlQuery = properties.getProperty("NotaryTaskListDao.getNotaryTaskList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("courtId", courtId)
        .setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO>getNotaryTaskListByServiceId(String courtId,String serviceId) {
        String sqlQuery = properties.getProperty("NotaryTaskListDao.getNotaryTaskListByServiceId");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("courtId", courtId);
        hQuery.setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getClaimedTaskList(UserRolePrivilegeDto userBean, String serviceId) {
        String sqlQuery = properties.getProperty("NotaryTaskListDao.getClaimedTaskList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("owner",  userBean.getUserType());
        hQuery.setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getClaimedTaskListByServiceId(UserRolePrivilegeDto userBean) {
        String sqlQuery = properties.getProperty("NotaryTaskListDao.getClaimedTaskListByServiceId");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("owner",  userBean.getUserType());
        hQuery.setParameter("serviceId",  userBean.getCurrentRole().getServices()[0].getServiceId());
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }
}

