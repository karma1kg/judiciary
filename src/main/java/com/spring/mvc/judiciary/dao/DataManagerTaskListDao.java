package com.spring.mvc.judiciary.dao;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sonam Tobgay on 4/1/2020.
 */
@Repository
public class DataManagerTaskListDao extends BaseDao{

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getDataManagerTaskList(String courtId,String serviceId) {
        String sqlQuery = properties.getProperty("DataManagerTaskListDao.getDataManagerTaskList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("courtId", courtId)
        .setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getUpdateClaimedTaskList(UserRolePrivilegeDto userBean, String serviceId) {
        String sqlQuery = properties.getProperty("DataManagerTaskListDao.getUpdateClaimedTaskList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("owner",  userBean.getUserType())
        .setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }
}
