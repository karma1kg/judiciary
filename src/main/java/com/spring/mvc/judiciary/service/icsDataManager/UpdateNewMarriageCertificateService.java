package com.spring.mvc.judiciary.service.icsDataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by kg on 23/08/2022.
 */
@Service
public class UpdateNewMarriageCertificateService
{
    @Autowired
    private CommonService commonService;
    public ResponseMessage updateApplication(UserRolePrivilegeDto userBean, String applicationNo, String regNo,
                                             Date regDate, String judgementNo,Date judgementDate,String lawyer) {
        ResponseMessage responseMessage;
        responseMessage = commonService.updateApplication(userBean, applicationNo, regNo, regDate, judgementNo, judgementDate, lawyer);
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setServiceName(ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceName());
        System.out.print(responseMessage);
        return responseMessage;
    }
}
