package com.spring.mvc.helper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public  class PrintPDFUtility {

    String url = null;
    public final JasperPrint getJasperPrintForExporting(
            final String url,
            final String applicationNo,
        HttpServletResponse response) {

            response.setContentType("application/pdf;charset=UTF-8");
            JasperPrint jasperprint = new JasperPrint();
            Map<String, Object> parameters = new HashMap<String, Object>();
            String filepath = "";
            String JudiciaryLogo = "";
            String courtLogo = "";
            String courtBanner = "";
            try {
                JudiciaryLogo = url + "/jasperImages/judiciary.jpg";
                courtLogo = url + "/jasperImages/courtLogo.jpg";
                courtBanner = url + "/jasperImages/courtBanner.jpg";
                parameters.put("URL", url);
                parameters.put("JudiciaryLogo", JudiciaryLogo);
                parameters.put("courtLogo", courtLogo);
                parameters.put("courtBanner", courtBanner);
                parameters.put("applicationNo", applicationNo);

                if(applicationNo.startsWith("502")){
                    filepath = url + "/jasperReport/authenticationPersonalDetails.jasper";
                } else if(applicationNo.startsWith("503")){
                    filepath = url + "/jasperReport/affirmationOfMC.jasper";
                } else if(applicationNo.startsWith("504")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }else if(applicationNo.startsWith("505")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }else if(applicationNo.startsWith("506")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }else if(applicationNo.startsWith("508")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }else if(applicationNo.startsWith("509")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }else if(applicationNo.startsWith("510")){
                    filepath = url + "/jasperReport/affirmationOfMarriageCertificate.jasper";
                }
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3308/judiciary_db", "root", "root");
                //Connection connection= DriverManager.getConnection("jdbc:mysql://172.30.2.25:3306/judiciary_db", "usr_judiciary", "Q3rsJ}3s3X2sAw3x");
                JasperReport jasperreport = (JasperReport) JRLoader.loadObjectFromFile(filepath);
                parameters.put(net.sf.jasperreports.engine.JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);
                jasperprint = JasperFillManager.fillReport(jasperreport, parameters,connection);

            }catch (Exception e){
                e.printStackTrace();
            }
    return jasperprint;
    }
}
