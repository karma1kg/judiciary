package com.spring.mvc.judiciary.controller.notaryController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.notaryService.ApproveAffirmationMarriageCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({ "/approveAffirmationMarriageCertificate" })
public class ApproveAffirmationMarriageCertificateController
{
    /**
     * declare of required private variables
     */
    @Autowired
    private ApproveAffirmationMarriageCertificateService approveAffirmationMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    /**
     * to redirect to page from notary tasklist
     * @param model
     * @returns page
     */
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD })
    public String index(final ModelMap model) {
        if (model.size() != 0) {
            final List<DropdownDTO> rejectReasons = (List<DropdownDTO>)this.commonService.getRejectReasons();
            List<DropdownDTO> rejectOthers=(List<DropdownDTO>)this.commonService.getRejectOthers();
            model.addAttribute("rejectOthers",(Object)rejectOthers);
            model.addAttribute("rejectReasons", (Object)rejectReasons);
            model.addAttribute("court_list", (Object)this.commonService.getAllCourt());
            return "notary/approveAffirmationMarriageCertificate";
        }
        return "redirect:/notaryTaskList";
    }

    /**
     * to get application details
     * @param applicationNo
     * @return fetch required details from database
     */
    @ResponseBody
    @RequestMapping(value = { "/getApplicationDetail" }, method = { RequestMethod.GET })
    public ResponseMessage getApplicationDetail(final String applicationNo) {
        return this.responseMessage = this.commonService.getApplicationDetails(applicationNo);
    }

    /**
     * to get attached files
     * @param applicationNo
     * @return show all attached files for view
     */
    @ResponseBody
    @RequestMapping(value = "/getAttachedFiles", method = RequestMethod.GET)
    public ResponseMessage getAttachedFiles(String applicationNo) {
        responseMessage = commonService.getAttachedFiles(applicationNo);
        return responseMessage;
    }

    /**
     * for downlaod of attachments
     * @param documentId
     * @param response
     * @return downloads files
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/downloadFile/{documentId}", method = RequestMethod.GET)
    public ResponseMessage downloadFile(@PathVariable Integer documentId, HttpServletResponse response) throws IOException {
        responseMessage = commonService.downloadFile(documentId, response);
        return responseMessage;
    }

   /* @ResponseBody
    @RequestMapping(value = { "/getAttachedFiles" }, method = { RequestMethod.GET })
    public ResponseMessage getAttachedFiles(final String applicationNo) {
        return this.responseMessage = this.commonService.getAttachedFiles(applicationNo);
    }

   *//* @ResponseBody
    @RequestMapping(value = { "/downloadFile/{documentId}" }, method = { RequestMethod.GET })
    public ResponseMessage downloadFile(@PathVariable final Integer documentId, final HttpServletResponse response) throws IOException {
        return this.responseMessage = this.commonService.downloadFile(documentId, response);
    }
*//*
   @ResponseBody
   @RequestMapping(value = "/downloadFile/{documentId}", method = RequestMethod.GET)
   public ResponseMessage downloadFile(@PathVariable Integer documentId, HttpServletResponse response) throws IOException {
       responseMessage = commonService.downloadFile(documentId, response);
       return responseMessage;
   }
*/

    /**
     * to check for date and time if its already given before
     * @param appoinmentDate
     * @param appoinmentTime
     * @return response message according to check from database
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping(value = { "/checkForAlreadyAssigned" }, method = { RequestMethod.GET })
    public ResponseMessage checkForAlreadyAssigned(final Date appoinmentDate, final String appoinmentTime) throws ParseException {
        return this.responseMessage = this.commonService.checkForAlreadyAssigned(appoinmentDate, appoinmentTime);
    }

    /**
     * save data for approval of service
     * @param request
     * @param response
     * @param applicationNo
     * @param remarks
     * @param appoinmentDate
     * @param appoinmentTime
     * @param mobileNo
     * @return response message as approved
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping(value = {"/saveApproveAffirmationMarriageCertificate"}, method = {RequestMethod.POST})
    public ResponseMessage saveApproveAffirmationMarriageCertificate(HttpServletRequest request, HttpServletResponse response, String applicationNo, String remarks, Date appoinmentDate, String appoinmentTime, String mobileNo) throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        String rejectReasonId=request.getParameter("rejectedId");
        this.responseMessage = this.approveAffirmationMarriageCertificateService.approveApplication(userBean, applicationNo, remarks, rejectReasonId, appoinmentDate, appoinmentTime, mobileNo);
        return this.responseMessage;
    }

    /**
     * to reject application
     * @param request
     * @param response
     * @param applicationNo
     * @param remarks
     * @param rejectReasons
     * @param mobileNo
     * @return reject message
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = { "/saveApproveAffirmationMarriageCertificates"}, method = RequestMethod.POST)
    public ResponseMessage saveApproveAffirmationMarriageCertificates(HttpServletRequest request, HttpServletResponse response,String applicationNo,String remarks, Integer rejectReasons,String mobileNo) throws Exception {
        final UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        /*String rejectReasonId=request.getParameter("rejectedId");
        Integer reasonid=Integer.parseInt(rejectReasonId);*/
        String rejectRemarks=String.valueOf(rejectReasons);
        /*String rejectReasonId=request.getParameter("rejectedId");
        String applicationNo=request.getParameter("applicationNo");
        String remarks=request.getParameter("remarks");
       // String array[]=request.getParameterValues("");
        Integer reasonid=Integer.parseInt(rejectReasonId);
        String rejectRemarks= String.valueOf(reasonid);
        String mobileNo=request.getParameter("mobileNo");*/
         this.responseMessage = this.approveAffirmationMarriageCertificateService.approveApplications(userBean, applicationNo, remarks, rejectReasons, rejectRemarks, mobileNo);
        return this.responseMessage;
    }
}
