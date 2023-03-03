package com.spring.mvc.judiciary.service.notaryService;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.util.CommonNotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by USER on 8/2/2019.
 */
@Service
public class ApproveMarriageCertificateService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private CommonDao commonDao;

    @Transactional
    public ResponseMessage approveApplication(UserRolePrivilegeDto userBean, String applicationNo, String remarks,
                                              String rejectReasonId, Date appoinmentDate,String appoinmentTime,String mobileNo) throws ParseException {

        ResponseMessage responseMessage = commonService.approveApplication(userBean, applicationNo, remarks, rejectReasonId);
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setServiceName(ServiceTypeEnum.MARRIAGE_CERTIFICATE.getServiceName());
        if (null==rejectReasonId) {
            updateAppoinmentDate(applicationNo, appoinmentDate,appoinmentTime);
        }
        //responseMessage.setCourtName(appoinmentDate);
        ArrayList<String> contactNo = new ArrayList<String>();
        String[] contactNums;
        contactNo.add(mobileNo);
        contactNums = contactNo.toArray(new String[contactNo.size()]);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String appoinmentDateApproveStatus = dateFormat.format(appoinmentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date3 = sdf.parse(appoinmentTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        String appoinmentTimeApproveStatus = sdf2.format(date3);
        String phoneNo = commonService.getCourtPhoneNo(userBean);
        if(null==rejectReasonId){
            Boolean result = CommonNotificationUtils.notifyOnVerification(responseMessage, appoinmentDateApproveStatus, appoinmentTimeApproveStatus, contactNums);
        }else {
            Boolean result = CommonNotificationUtils.notifyOnRejection(responseMessage, contactNums,phoneNo);
        }
        if(null==rejectReasonId) {
            String courtId = userBean.getJurisdictions()[0].getLocationID();
            commonService.pushForOnlinePayment(applicationNo,courtId);
        }
        responseMessage.setAppoinmentDateApprove(appoinmentDateApproveStatus);
        responseMessage.setAppoinmentTimeApprove(appoinmentTimeApproveStatus);
        return responseMessage;
    }
    private ResponseMessage updateAppoinmentDate(String applicationNo, Date appoinmentDate,String appoinmentTime) throws ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        if (appoinmentDate == null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Appointment date not found");
            return responseMessage;
        }
        if (!appoinmentDate.equals("")) {
            commonDao.updateAppoinmentDate(applicationNo, formatDate(appoinmentDate),formatTime(appoinmentTime));
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        }
        return responseMessage;
    }

    private String formatDate(Date appoinmentDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(appoinmentDate);
        return date;
    }
    private String formatTime(String appoinmentTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date3 = sdf.parse(appoinmentTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        String time = sdf2.format(date3);
        return time;
    }

    public ResponseMessage approveApplications(UserRolePrivilegeDto userBean, String applicationNo, String remarks,
                                              String rejectReasonId,String mobileNo) throws ParseException {
        ResponseMessage responseMessage=commonService.approveApplications(userBean, applicationNo, remarks, rejectReasonId);
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setServiceName(ServiceTypeEnum.MARRIAGE_CERTIFICATE.getServiceName());
        //responseMessage.setCourtName(appoinmentDate);
        ArrayList<String> contactNo = new ArrayList<String>();
        String[] contactNums;
        contactNo.add(mobileNo);
        contactNums = contactNo.toArray(new String[contactNo.size()]);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        String phoneNo = commonService.getCourtPhoneNo(userBean);
        String appoinmentDateApproveStatus="";
        String appoinmentTimeApproveStatus="";
        String str = phoneNo.replaceAll("[^a-zA-Z0-9]", "");
        Boolean var19;
        if(rejectReasonId!=null) {
            var19 = CommonNotificationUtils.notifyOnRejectionMc(responseMessage, contactNums, str);
        }
        else{
            var19 = CommonNotificationUtils.notifyOnVerification(responseMessage, appoinmentDateApproveStatus, appoinmentTimeApproveStatus, contactNums);
        }
        return responseMessage;
    }
}
