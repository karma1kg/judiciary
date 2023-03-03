package com.spring.mvc.judiciary.util;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;
import java.net.HttpURLConnection;
public class SMSUtil implements Runnable{

    ResourceBundle bundle = ResourceBundle.getBundle("wsEndPointURL_en_US");
    String smsUrl =bundle.getString("sms.url.firstPart");

    private String mobileNo = null;
    private String smsContent = null;
    boolean result = false;
    public static final String SMS_ENCONDING_TYPE = "UTF-8";
    public static final String URL_MIDDLE_PART = "&msg=";
    public boolean sendSMS(){
        Thread thread = new Thread(this);
        thread.start();
        return result;
    }
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    @Override
    public void run() {

        String encodedMobileNo = null;
        String encodedSMScontent = null;
        String fullURLStr = null;
        URL url =null;
        HttpURLConnection connection = null;
        String responseMSg = null;

        if(smsUrl!=null && mobileNo!=null && smsContent!=null){
            try{
                encodedMobileNo=URLEncoder.encode(mobileNo, SMS_ENCONDING_TYPE);
                encodedSMScontent=URLEncoder.encode(smsContent, SMS_ENCONDING_TYPE);
                fullURLStr = smsUrl + mobileNo+ URL_MIDDLE_PART +smsContent;
                fullURLStr= fullURLStr.replaceAll(" ","%20");
                url = new URL(fullURLStr);
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(false);
                connection.setDoInput(true);
                responseMSg = connection.getResponseMessage();
                int code = connection.getResponseCode() ;
                if (code == HttpURLConnection.HTTP_OK){
                    connection.disconnect() ;
                    result = true;
                }
            }
            catch(Exception e){
            }
        }
    }
}