package com.spring.mvc.judiciary.controller.commonController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.PrintPDFUtility;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.commonService.PrintCertificateService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by USER on 9/13/2019.
 */

/**
 * to print certificate for each applications
 */
@Controller
@RequestMapping("/printCertificate")
public class PrintCertificateController {

    @Autowired
    private PrintCertificateService printCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        List<DropdownDTO> serviceList = commonService.getServiceNamePrint();
        model.addAttribute("serviceList", serviceList);
        return "common/printCertificate";
    }

    /**
     * to generate certificate lists with request of courdId and serviceId
     * @param request
     * @param response
     * @param serviceId
     * @return certificate lists
     */
    @ResponseBody
    @RequestMapping(value = "/getCertificateList", method = RequestMethod.GET)
    public ResponseMessage getCertificateList(HttpServletRequest request, HttpServletResponse response,
                                              Integer serviceId) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = printCertificateService.getCertificateList(serviceId, courtId);
        return responseMessage;
    }

    /**
     * request for service id with application No. to print certificate
     * @param model
     * @param request
     * @param applicationNo
     * @return certificate detail
     * @throws Exception
     */
    //@ResponseBody
    @RequestMapping(value = "/printCertificate", method = RequestMethod.GET)
    public String printCertificate(ModelMap model, HttpServletRequest request, String applicationNo)throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        //responseMessage = printCertificateService.printCertificate(applicationNo);
        if(applicationNo.startsWith("501")){
            model.addAttribute("applicationDetail", printCertificateService.getPrintApplicationDetailMC(applicationNo));
            model.addAttribute("husbandDetail", printCertificateService.getHusbandDetail(applicationNo));
            model.addAttribute("wifeDetail", printCertificateService.getWifeDetail(applicationNo));
            return "printCertificate/marriageCertificate";
        }else if(applicationNo.startsWith("502")) {
            return "printCertificate/authenticationPersonalDetails";
        }else if(applicationNo.startsWith("503")) {
            return "printCertificate/affirmationMarriageCertificate";
        }else if(applicationNo.startsWith("504")) {
            return "printCertificate/lostDocument";
        }else if(applicationNo.startsWith("505")) {
            return "printCertificate/singleMaritalStatus";
        }else if(applicationNo.startsWith("506")) {
            return "printCertificate/childTravelDocument";
        }else if(applicationNo.startsWith("508")) {
            return "printCertificate/childAdoption";
        }else if(applicationNo.startsWith("509")) {
            return "printCertificate/organTransplant";
        }else if(applicationNo.startsWith("510")) {
            return "printCertificate/closingTransferAccounts";
        }
        return "common/printCertificate";
        //return responseMessage;
    }

    /**
     * print certificate in jasper
     * @param request application number
     * @param response
     * @param applicationNo
     * @return print certificate in pdf
     */
    @RequestMapping(value = "/printCertificateJasper", method = RequestMethod.GET)
    public String printCertificateJasper (HttpServletRequest request,HttpServletResponse response,String applicationNo) {
        File filepath = null;
        String applicantCidNo = "";

        JasperPrint jasperprint = new JasperPrint();
        String url =null;
        try{
            //applicationNo = request.getParameter("applicationNo");
            ApplicationDetailDTO applicationDetailDTO = printCertificateService.getPrintApplicationDetailMC(applicationNo);
            applicantCidNo = applicationDetailDTO.getCidNo();

            PrintPDFUtility printPDFUtility = new PrintPDFUtility();
            url = request.getSession().getServletContext().getRealPath("/resources/JasperCertificate");
            filepath = new File(request.getSession().getServletContext().getRealPath("/resources/JasperCertificate"));

            jasperprint = printPDFUtility.getJasperPrintForExporting(
                    filepath.getPath(),
                    applicationNo,
                    response);
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf;charset=UTF-8");
            if(applicationNo.startsWith("502")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("503")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("504")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("505")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("506")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("508")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("509")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }else if(applicationNo.startsWith("510")){
                response.setHeader("Content-Disposition", "attachment; filename="+applicantCidNo+"_"+applicationNo+".pdf");
            }
            JasperExportManager.exportReportToPdfStream(jasperprint, out);
            out.flush();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
