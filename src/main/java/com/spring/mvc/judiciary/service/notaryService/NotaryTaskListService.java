package com.spring.mvc.judiciary.service.notaryService;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.NotaryTaskListDao;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 8/2/2019.
 */
@Service
public class NotaryTaskListService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private NotaryTaskListDao notaryTaskListDao;

    public ResponseMessage getNotaryTaskList(String courtId, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> notaryList = notaryTaskListDao.getNotaryTaskList(courtId,serviceId);
        if (notaryList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(notaryList);
        }
        return responseMessage;
    }

    public ResponseMessage getNotaryTaskListByServiceId(String courtId,String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> notaryList = notaryTaskListDao.getNotaryTaskListByServiceId(courtId,serviceId);
        if (notaryList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(notaryList);
        }
        return responseMessage;
    }

    public ResponseMessage getClaimedTaskList(UserRolePrivilegeDto userBean, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> notaryList = notaryTaskListDao.getClaimedTaskList(userBean,serviceId);
      // notaryList.set(0).setApplicationYear(notaryList.get(0).getApplicationYear());
        if (notaryList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(notaryList);
        }
        return responseMessage;
    }

    public ResponseMessage getClaimedTaskListByServiceId(UserRolePrivilegeDto userBean) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> notaryList = notaryTaskListDao.getClaimedTaskListByServiceId(userBean);
        if (notaryList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(notaryList);
        }
        return responseMessage;
    }

    public ResponseMessage saveClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage = commonService.saveClaimTask(userBean, applicationNo);
        return responseMessage;
    }

    public ResponseMessage saveUnClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage = commonService.saveUnClaimTask(userBean, applicationNo);
        return responseMessage;
    }
}
