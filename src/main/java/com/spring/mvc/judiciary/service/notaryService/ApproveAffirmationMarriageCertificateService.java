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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ApproveAffirmationMarriageCertificateService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonDao commonDao;

    public ResponseMessage approveApplication(UserRolePrivilegeDto userBean, String applicationNo, String remarks, String rejectReasonId, Date appoinmentDate, String appoinmentTime, String mobileNo) throws ParseException {
        if (null == rejectReasonId)
            updateAppoinmentDate(applicationNo, appoinmentDate, appoinmentTime);
        ResponseMessage responseMessage = this.commonService.approveApplication(userBean, applicationNo, remarks, rejectReasonId);
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setServiceName(ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceName());
        ArrayList<String> contactNo = new ArrayList<>();
        contactNo.add(mobileNo);
        String[] contactNums = contactNo.<String>toArray(new String[contactNo.size()]);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String appoinmentDateApproveStatus = dateFormat.format(appoinmentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date3 = sdf.parse(appoinmentTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        String appoinmentTimeApproveStatus = sdf2.format(date3);
        String phoneNo = this.commonService.getCourtPhoneNo(userBean);
        if (rejectReasonId == null) {
            Boolean var19 = Boolean.valueOf(CommonNotificationUtils.notifyOnVerification(responseMessage, appoinmentDateApproveStatus, appoinmentTimeApproveStatus, contactNums));
        } else {
            Boolean var19 = Boolean.valueOf(CommonNotificationUtils.notifyOnRejection(responseMessage, contactNums, phoneNo));
        }
        responseMessage.setAppoinmentDateApprove(appoinmentDateApproveStatus);
        responseMessage.setAppoinmentTimeApprove(appoinmentTimeApproveStatus);
        return responseMessage;
    }

    public ResponseMessage approveApplications(UserRolePrivilegeDto userBean, String applicationNo, String remarks, Integer rejectReasonId, String rejectRemarks, String mobileNo) throws ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            responseMessage = this.commonService.approveApplicationss(userBean, applicationNo, remarks, rejectReasonId, rejectRemarks);
            responseMessage.setApplicationNumber(applicationNo);
            responseMessage.setServiceName(ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceName());
            ArrayList<String> contactNo = new ArrayList<>();
            contactNo.add(mobileNo);
            String[] contactNums = contactNo.<String>toArray(new String[contactNo.size()]);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
            String phoneNo = this.commonService.getCourtPhoneNo(userBean);
            String appoinmentDateApproveStatus = "";
            String appoinmentTimeApproveStatus = "";
            String str = phoneNo.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println("headCourt phone number --------------" + str + "------------------printed");
            Boolean bool = Boolean.valueOf(CommonNotificationUtils.notifyOnRejection(responseMessage, contactNums, str));
        } catch (Exception e) {
            System.out.print(e);
        }
        return responseMessage;
    }

    private ResponseMessage updateAppoinmentDate(String applicationNo, Date appoinmentDate, String appoinmentTime) throws ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        if (appoinmentDate == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Appointment date not found");
            return responseMessage;
        }
        if (!appoinmentDate.equals("")) {
            this.commonDao.updateAppoinmentDate(applicationNo, formatDate(appoinmentDate), formatTime(appoinmentTime));
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
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
}
