package com.spring.mvc.judiciary.service.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dao.DataManagerTaskListDao;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sonam Tobgay on 4/1/2020.
 */
@Service
public class DataManagerService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private DataManagerTaskListDao dataManagerTaskListDao;

    public ResponseMessage getDataManagerTaskList(String courtId,String serviceId ) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> dataManagerList = dataManagerTaskListDao.getDataManagerTaskList(courtId,serviceId);
        if (dataManagerList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(dataManagerList);
        }
        return responseMessage;
    }

    public ResponseMessage getUpdateClaimedTaskList(UserRolePrivilegeDto userBean, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> dataManagerList = dataManagerTaskListDao.getUpdateClaimedTaskList(userBean,serviceId);
        if (dataManagerList != null){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(dataManagerList);
        }
        return responseMessage;
    }

    public ResponseMessage saveUpdateClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage = commonService.saveUpdateClaimTask(userBean, applicationNo);
        return responseMessage;
    }

    public ResponseMessage saveUpdateUnClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage = commonService.saveUpdateUnClaimTask(userBean, applicationNo);
        return responseMessage;
    }
}
