package com.spring.mvc.judiciary.controller.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.dataManager.UpdateSingleMaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Sonam Tobgay on 4/10/2020.
 */
@Controller
@RequestMapping("/updateSingleMaritalStatus")
public class UpdateSingleMaritalStatusController {
    @Autowired
    private UpdateSingleMaritalStatusService updateSingleMaritalStatusService;
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
            return "dataManager/updateSingleMaritalStatus";
        } else {
            return "redirect:/dataManagerTaskList";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getApplicationDetail", method = RequestMethod.GET)
    public ResponseMessage getApplicationDetail(String applicationNo) {
        responseMessage = commonService.getApplicationDetails(applicationNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPreviousJudgementNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousJudgementNo(HttpServletRequest request,String judgementNo,String applicationYear) {
        String serviceId = "505";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = commonService.checkPreviousJudgementNo(judgementNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPreviousRegistrationNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousRegistrationNo(HttpServletRequest request,String regNo,String applicationYear) {
        String serviceId = "505";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = commonService.checkPreviousRegistrationNo(regNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/updateSingleMaritalStatus", method = RequestMethod.POST)
    public ResponseMessage updateSingleMaritalStatus(HttpServletRequest request, ApplicationDetailDTO applicationDetailDTO) throws Exception {
        String applicationNo = applicationDetailDTO.getApplicationNo();
        String regNo = applicationDetailDTO.getRegNo();
        Date regDate = applicationDetailDTO.getRegDate();
        String judgementNo = applicationDetailDTO.getJudgementNo();
        Date judgementDate = applicationDetailDTO.getJudgementDate();
        String lawyer = applicationDetailDTO.getLawyer();
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = updateSingleMaritalStatusService.updateApplication(userBean,
                applicationNo, regNo, regDate, judgementNo,judgementDate,lawyer);
        return responseMessage;
    }
}
