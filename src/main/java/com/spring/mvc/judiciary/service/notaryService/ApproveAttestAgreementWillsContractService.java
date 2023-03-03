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

/**
 * Created by Sonam Tobgay on 4/10/2020.
 */
@Service
public class ApproveAttestAgreementWillsContractService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private CommonDao commonDao;

    public ResponseMessage approveApplication(UserRolePrivilegeDto userBean, String applicationNo, String remarks,
                                              String rejectReasonId, Date appoinmentDate, String appoinmentTime,String mobileNo) throws ParseException {
        ResponseMessage responseMessage;
        if (null==rejectReasonId) {
            updateAppoinmentDate(applicationNo, appoinmentDate,appoinmentTime);
        }
        responseMessage = commonService.approveApplication(userBean, applicationNo, remarks, rejectReasonId);
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setServiceName(ServiceTypeEnum.ATTEST_AGREEMENTS_WILLS_CONTRACTS_AND_TESTAMENTS.getServiceName());
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
        if(rejectReasonId==null){
            Boolean result = CommonNotificationUtils.notifyOnVerification(responseMessage, appoinmentDateApproveStatus, appoinmentTimeApproveStatus, contactNums);
        }else {
            Boolean result = CommonNotificationUtils.notifyOnRejection(responseMessage, contactNums,phoneNo);
        }
        /*if(rejectReasonId == 0) {
            String courtId = userBean.getJurisdictions()[0].getLocationID();
            commonService.pushForOnlinePayment(applicationNo,courtId);
        }*/
        responseMessage.setAppoinmentDateApprove(appoinmentDateApproveStatus);
        responseMessage.setAppoinmentTimeApprove(appoinmentTimeApproveStatus);
        return responseMessage;
    }
    private ResponseMessage updateAppoinmentDate(String applicationNo, Date appoinmentDate, String appoinmentTime) throws ParseException {
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

    public ResponseMessage approveApplications(UserRolePrivilegeDto userBean, String applicationNo, String remarks, Integer rejectReasonId,String rejectRemarks,String mobileNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            responseMessage = commonService.approveApplicationss(userBean, applicationNo, remarks, rejectReasonId, rejectRemarks);
            responseMessage.setApplicationNumber(applicationNo);
            responseMessage.setServiceName(ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceName());
            ArrayList<String> contactNo = new ArrayList<String>();
            String[] contactNums;
            contactNo.add(mobileNo);
            contactNums = contactNo.toArray(new String[contactNo.size()]);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
            String phoneNo = commonService.getCourtPhoneNo(userBean);
            String appoinmentDateApproveStatus = "";
            String appoinmentTimeApproveStatus = "";
            String str = phoneNo.replaceAll("[^a-zA-Z0-9]", "");

            Boolean var19;
            if (rejectReasonId != 0) {
                System.out.println("headCourt phone number --------------"+str+"------------------printed");
                var19 = CommonNotificationUtils.notifyOnRejection(responseMessage, contactNums, str);
            } else {
                var19 = CommonNotificationUtils.notifyOnVerification(responseMessage, appoinmentDateApproveStatus, appoinmentTimeApproveStatus, contactNums);
            }
        } catch (Exception e){
            System.out.print(e);
        }
        /*if(rejectReasonId == 0) {
            String courtId = userBean.getJurisdictions()[0].getLocationID();
            commonService.pushForOnlinePayment(applicationNo,courtId);
        }*/

        return responseMessage;
    }
}
