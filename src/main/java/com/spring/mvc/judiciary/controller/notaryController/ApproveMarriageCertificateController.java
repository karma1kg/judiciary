package com.spring.mvc.judiciary.controller.notaryController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.notaryService.ApproveMarriageCertificateService;
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

/**
 * Created by USER on 8/2/2019.
 */
@Controller
@RequestMapping("/approveMarriageCertificate")
public class ApproveMarriageCertificateController {
    @Autowired
    private ApproveMarriageCertificateService approveMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        if (model.size() != 0) {
                    List<DropdownDTO> rejectReasons = commonService.getRejectReasons();
            model.addAttribute("rejectReasons", rejectReasons);
            model.addAttribute("religion_list", commonService.getAllReligion());
            model.addAttribute("court_list", commonService.getAllCourt());
            return "notary/approveMarriageCertificate";
        } else {
            return "redirect:/notaryTaskList";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getApplicationDetail", method = RequestMethod.GET)
    public ResponseMessage getApplicationDetail(String applicationNo) {
        responseMessage = commonService.getApplicationDetail(applicationNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/getAttachedFiles", method = RequestMethod.GET)
    public ResponseMessage getAttachedFiles(String applicationNo) {
        responseMessage = commonService.getAttachedFiles(applicationNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/downloadFile/{documentId}", method = RequestMethod.GET)
    public ResponseMessage downloadFile(@PathVariable Integer documentId, HttpServletResponse response) throws IOException {
        responseMessage = commonService.downloadFile(documentId, response);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyAssigned", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyAssigned(Date appoinmentDate,String appoinmentTime) throws ParseException {
        responseMessage = commonService.checkForAlreadyAssigned(appoinmentDate, appoinmentTime);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/saveApproveMarriageCertificate", method = RequestMethod.POST)
    public ResponseMessage saveApproveMarriageCertificate(HttpServletRequest request,
                                                                String applicationNo, String remarks,
                                                                 Date appoinmentDate, String appoinmentTime, String mobileNo )
            throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String rejectReasonId=request.getParameter("rejectedId");
        responseMessage = approveMarriageCertificateService.approveApplication(userBean,
                applicationNo, remarks, rejectReasonId, appoinmentDate, appoinmentTime, mobileNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/saveApproveMarriageCertificates", method = RequestMethod.POST)
    public ResponseMessage saveApproveMarriageCertificates(HttpServletRequest request,HttpServletResponse response)
            throws Exception {
        String rejectReasonId=request.getParameter("rejectedId");
        String applicationNo=request.getParameter("applicationNo");
        String remarks=request.getParameter("remarks");
        //String rejectRemarks=request.getParameter("rejectRemarks");
        String mobileNo=request.getParameter("mobileNo");
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = approveMarriageCertificateService.approveApplications(userBean,
                applicationNo, remarks, rejectReasonId,mobileNo);
        return responseMessage;
    }
}
