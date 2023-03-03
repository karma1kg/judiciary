package com.spring.mvc.judiciary.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class  EmailUtil {
    private String m_strToList;
    private String m_strFromList;
    private String m_strSubject;
    private String m_strMailBody;

    public void sendMail() throws IOException {
        String to = getTOList();
        String from = getFrom();
        String strSubject = getSubject();
        String strMailBody = getMailBody();
        to = getValidEmailAddresses(to);
        from = getValidEmailAddresses(from);
        Message mailMessage = new MimeMessage(getSession());
        if (mailMessage != null) {
            try {
                System.out.println("SMTP Server IS UP and RUNNING ");
                mailMessage.setFrom(new InternetAddress(from));
                mailMessage.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to, false));
                mailMessage.setSubject(strSubject);
                mailMessage.setSentDate(new Date());
                mailMessage.setText(strMailBody);
                Transport.send(mailMessage);
            } catch (MessagingException ex) {
                System.out.println("Exception occured in sendMail method" + ex);
            }
        }
    }
    private String getTOList()
    {
        return m_strToList;
    }
    private String getFrom()
    {
        return m_strFromList;
    }
    private String getSubject()
    {
        return m_strSubject;
    }
    private String getMailBody()
    {
        return m_strMailBody;
    }
    public void setTOList(String strToList)
    {
        m_strToList = strToList;
    }
    public void setTOListFromArray(String[] strToListArr) {
        int position = 0;
        if(strToListArr!=null && strToListArr.length>0){
            for(String emailStr : strToListArr){
                if(emailStr!=null && emailStr!=""){
                    if(position==0)
                        m_strToList = emailStr;
                    else
                        m_strToList+=emailStr;
                    if(position<strToListArr.length-1)
                        m_strToList+= ",";
                    position++;
                }
            }
        }
    }

    public void setFrom(String strFromList)
    {
        m_strFromList = strFromList;
    }
    public void setSubject(String strSubject)
    {
        m_strSubject = strSubject;
    }
    public void setMailBody(String strMailBody)
    {
        m_strMailBody = strMailBody;
    }
    private static String getValidEmailAddresses(String emailAddresses) {
        try {
            String[] emailAddrArr = emailAddresses.split(",");
            StringBuffer buf = new StringBuffer("");
            for (int i = 0; i < emailAddrArr.length; i++) {
                String emailAddr = emailAddrArr[i];
                if ( emailAddr.indexOf('@') == -1 || emailAddr.indexOf('.') == -1) {
                    continue;
                }
                buf.append(emailAddr).append(",");
            }
            return buf.toString();
        }
        catch (Exception e) {
            System.out.println(" Exception occured in getValidEmailAddresses method of EmailUtil.java " + e);
            return emailAddresses;
        }
    }

//	private class Authenticator extends javax.mail.Authenticator {
//		private PasswordAuthentication authentication;
//		public Authenticator() {
//			String username = "oisua295";
//			String password = "oisua295";
//			authentication = new PasswordAuthentication(username, password);
//		}
//		protected PasswordAuthentication getPasswordAuthentication()
//		{
//			return authentication;
//		}
//	}

    private Session getSession() {
//		Authenticator authenticator = new Authenticator();
        Properties properties = new Properties();
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String SMTP_HOST = resourceBundle1.getString("mail.host");
        String SMTP_HOST_NAME = resourceBundle1.getString("mail.smtpHost");
        String SMTP_PORT = resourceBundle1.getString("mail.port");
        String SMTP_PORT_NAME = resourceBundle1.getString("mail.smtpPort");
        String UTF8 = resourceBundle1.getString("mail.utf8");
        String UTF8_NAME = resourceBundle1.getString("mail.utf8.name");
        /*String AUTH = resourceBundle1.getString("mail.auth");
        String AUTH_NAME = resourceBundle1.getString("mail.smtpAuth");*/

        properties.setProperty(SMTP_HOST_NAME,SMTP_HOST);
        properties.setProperty(SMTP_PORT_NAME,SMTP_PORT);
        properties.setProperty(UTF8_NAME,UTF8);
        //properties.setProperty(AUTH_NAME,AUTH);
        return Session.getInstance(properties);
    }
}