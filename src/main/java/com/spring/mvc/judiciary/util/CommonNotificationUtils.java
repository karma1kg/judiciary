package com.spring.mvc.judiciary.util;

import com.spring.mvc.helper.ResponseMessage;
import org.springframework.util.StringUtils;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Tshedp Gyeltshen on 6/27/2020.
 */
public class CommonNotificationUtils {

    private SMSUtil smsSender = null;
    private static  String SUBMISSION_EMAIL_SUBJECT = "Application submission notification";

    //SMS Notification part
    private static  String SMS_BODY_PART1 = "Your application ";
    private static  String SMS_BODY_PART2 = "Click on the link to make online payment ";
    private static  String SMS_BODY_PART3 = "This application is forwarded to Judicial official for verification and approval.";
    private static  String SMS_BODY_PART4 = "For more information call : ";

    private static String SMS_URL = null;
    Properties properties = null;

    public static boolean notifyOnSubmission(String appNumber, String courtName, String contactNumbers) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        boolean result = false;
        try {
            if (appNumber != null && contactNumbers != null) {
                 CommonNotificationUtils notification = new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;

                if(!StringUtils.isEmpty(contactNumbers)){
                    notification.smsSender = new SMSUtil();
                    notification.smsSender.setMobileNo(contactNumbers);
                    notification.smsSender.setSmsUrl(SMS_URL);
                    notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber+ " is submitted successfully. And the application is forwarded to " +courtName+" court. ");
                    notification.smsSender.sendSMS();
                }
            }
            result = true;
            System.out.println("Message sent successfully");
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        System.out.print(result+"*************Sent at recipient**********");
        return result;

    }

   /* public static Boolean notifyOnSubmission(String applicationNo,String mobileNo) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        boolean result = false;
        try {
            if (applicationNo == null && mobileNo != null) {
                CommonNotificationUtils notification = new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;

                if(!StringUtils.isEmpty(mobileNo)){
                    notification.smsSender = new SMSUtil();
                    notification.smsSender.setMobileNo(mobileNo);
                    notification.smsSender.setSmsUrl(SMS_URL);
                    notification.smsSender.setSmsContent(SMS_BODY_PART1+ "Application reached maximum limit set by system, please try again next day");
                    notification.smsSender.sendSMS();
                }
            }
            result = true;
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        return result;
    }*/

    public static boolean notifyOnRejection(ResponseMessage responseMessage, String[] contactNumbers, String phoneNo)
    {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        boolean result = false;
        String appNumber  = responseMessage.getApplicationNumber();
        String reason = responseMessage.getRejectOthers();
        try
        {
            if(appNumber!=null && contactNumbers!=null)
            {
                CommonNotificationUtils notification =new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;
                for(String mobile : contactNumbers){
                    if(!StringUtils.isEmpty(mobile)){
                        notification.smsSender = new SMSUtil();
                        notification.smsSender.setMobileNo(mobile);
                        notification.smsSender.setSmsUrl(SMS_URL);
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected due to:" + reason + SMS_BODY_PART4 + phoneNo);
                        /*else {
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected. The reject reason is "+reason+" and "+rejectRemarks+" "+SMS_BODY_PART4+ phoneNo);
                        }*/
                        notification.smsSender.sendSMS();
                    }
                }
            }
            result = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public static boolean notifyOnRejections(ResponseMessage responseMessage, String[] contactNumbers, String phoneNo)
    {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        boolean result = false;
        String appNumber  = responseMessage.getApplicationNumber();
        String reason = responseMessage.getRejectAttest();
        try
        {
            if(appNumber!=null && contactNumbers!=null)
            {
                CommonNotificationUtils notification =new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;
                for(String mobile : contactNumbers){
                    if(!StringUtils.isEmpty(mobile)){
                        notification.smsSender = new SMSUtil();
                        notification.smsSender.setMobileNo(mobile);
                        notification.smsSender.setSmsUrl(SMS_URL);
                        notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected due to:" + reason + SMS_BODY_PART4 + phoneNo);
                        /*else {
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected. The reject reason is "+reason+" and "+rejectRemarks+" "+SMS_BODY_PART4+ phoneNo);
                        }*/
                        notification.smsSender.sendSMS();
                    }
                }
            }
            result = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }



    public static boolean notifyOnRejectionMc(ResponseMessage responseMessage, String[] contactNumbers, String phoneNo)
    {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        boolean result = false;
        String appNumber  = responseMessage.getApplicationNumber();
        String reason = responseMessage.getRejectReason();
        try
        {
            if(appNumber!=null && contactNumbers!=null)
            {
                CommonNotificationUtils notification =new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;
                for(String mobile : contactNumbers){
                    if(!StringUtils.isEmpty(mobile)){
                        notification.smsSender = new SMSUtil();
                        notification.smsSender.setMobileNo(mobile);
                        notification.smsSender.setSmsUrl(SMS_URL);
                        notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected due to:" + reason + SMS_BODY_PART4 + phoneNo);
                        /*else {
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber +" has been rejected. The reject reason is "+reason+" and "+rejectRemarks+" "+SMS_BODY_PART4+ phoneNo);
                        }*/
                        notification.smsSender.sendSMS();
                    }
                }
            }
            result = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public static boolean notifyOnVerification (ResponseMessage responseMessage, String appoinmentDateApproveStatus, String appoinmentTimeApproveStatus,  String[] contactNumbers) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        String paymentURL = resourceBundle1.getString("payment.url.firstPart");
        boolean result = false;
        String appNumber  = responseMessage.getApplicationNumber();
        String courtName = responseMessage.getCourtName();
        try
        {
            if(appNumber!=null && contactNumbers!=null)
            {
                CommonNotificationUtils notification =new CommonNotificationUtils();
                if(smsURL!=null)
                    SMS_URL = smsURL;
                for(String mobile : contactNumbers){
                    if(!StringUtils.isEmpty(mobile)) {
                        notification.smsSender = new SMSUtil();
                        notification.smsSender.setMobileNo(mobile);
                        notification.smsSender.setSmsUrl(SMS_URL);
                        /*Online payment SMS*/
                        if(appNumber.startsWith("501")){
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber + " has been Verified. Your appointment date is : " + appoinmentDateApproveStatus + " and time is : " + appoinmentTimeApproveStatus + " and visit " + courtName + " court for hearing. " + SMS_BODY_PART2 + paymentURL + " ");
                        } else {
                            notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber + " has been Verified. Your appointment date is : " + appoinmentDateApproveStatus + " and time is : " + appoinmentTimeApproveStatus + " and visit " + courtName + " court for hearing. ");
                        }
                        notification.smsSender.sendSMS();
                    }
                }
            }
            result = true;
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        return result;
    }
    public static boolean notifyOnPrint(ResponseMessage responseMessage,  String[] contactNumbers) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String smsURL = resourceBundle1.getString("sms.url.firstPart");
        String appNumber = responseMessage.getApplicationNumber();
        String courtName = responseMessage.getCourtName();
        boolean result = false;
        try
        {
            if(appNumber!=null && contactNumbers!=null)
            {
                CommonNotificationUtils notification =new CommonNotificationUtils();
                if(smsURL!=null )
                    SMS_URL = smsURL;
                for(String mobile : contactNumbers){
                    if(!StringUtils.isEmpty(mobile)){
                        notification.smsSender = new SMSUtil();
                        notification.smsSender.setMobileNo(mobile);
                        notification.smsSender.setSmsUrl(SMS_URL);
                        notification.smsSender.setSmsContent(SMS_BODY_PART1 + appNumber + " has been printed. Please visit " + courtName +"court to collect your certificate during office hours.");
                        notification.smsSender.sendSMS();
                    }
                }
            }
            result = true;
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        return result;
    }

}
