package com.spring.mvc.judiciary.controller.notaryController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.notaryService.ApproveChildAdoptionService;
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
 * Created by Sonam Tobgay on 4/10/2020.
 */
@Controller
@RequestMapping("/approveChildAdoption")
public class ApproveChildAdoptionController {
    @Autowired
    private ApproveChildAdoptionService approveChildAdoptionService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        if (model.size() != 0) {
            List<DropdownDTO> rejectReasons = commonService.getRejectReasons();
            model.addAttribute("rejectReasons", rejectReasons);
            List<DropdownDTO> rejectOthers=(List<DropdownDTO>)this.commonService.getRejectOthers();
            model.addAttribute("rejectOthers",(Object)rejectOthers);
            model.addAttribute("religion_list", commonService.getAllReligion());
            model.addAttribute("court_list", commonService.getAllCourt());
            return "notary/approveChildAdoption";
        } else {
            return "redirect:/notaryTaskList";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getApplicationDetail", method = RequestMethod.GET)
    public ResponseMessage getApplicationDetail(String applicationNo) {
        responseMessage = commonService.getApplicationDetails(applicationNo);
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
    @RequestMapping(value = "/saveApproveChildAdoption", method = RequestMethod.POST)
    public ResponseMessage saveApproveChildAdoption(HttpServletRequest request,
                                                          String applicationNo, String remarks,
                                                        Date appoinmentDate,String appoinmentTime, String mobileNo)
            throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String rejectReasonId=request.getParameter("rejectedId");
        responseMessage = approveChildAdoptionService.approveApplication(userBean,
                applicationNo, remarks, rejectReasonId, appoinmentDate,appoinmentTime,mobileNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/saveApproveChildAdoptions", method = RequestMethod.POST)
    public ResponseMessage saveApproveChildAdoption(HttpServletRequest request, HttpServletResponse response,String applicationNo,String remarks, Integer rejectReasons,String mobileNo)
            throws Exception {
        String rejectRemarks= String.valueOf(rejectReasons);
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = approveChildAdoptionService.approveApplications(userBean,
                applicationNo, remarks, rejectReasons,rejectRemarks,mobileNo);
        return responseMessage;
    }
}

