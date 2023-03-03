package com.spring.mvc.judiciary.controller.icsDataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.icsDataManager.UpdateNewMarriageCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kg on 23/08/2022.
 */

/**
 * for new mc update
 */
@Controller
@RequestMapping("/updateNewMarriageCertificate")
public class UpdateNewMarriageCertificateController {
    @Autowired
    private UpdateNewMarriageCertificateService updateNewMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;
    Calendar calendar;
    Integer currentYear;

    public UpdateNewMarriageCertificateController() {
        calendar = Calendar.getInstance();
        currentYear = calendar.get(1);
    }
    /**
     * to redirect to page from data manager tasklist
     * @param model
     * @returns page
     */
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD })
    public String index( ModelMap model) {
        if (model.size() != 0) {
             List<DropdownDTO> rejectReasons = (List<DropdownDTO>)commonService.getRejectReasons();
            model.addAttribute("rejectReasons", (Object)rejectReasons);

            return "icsDataManager/updateNewMarriageCertificate";
        }
        return "redirect:/dataManagerTaskList";
    }
    /**
     * to get application details
     * @param applicationNo
     * @return fetch required details from database
     */
    @ResponseBody
    @RequestMapping(value = { "/getApplicationDetail" }, method = { RequestMethod.GET })
    public ResponseMessage getApplicationDetail( String applicationNo) {
        return responseMessage = commonService.getApplicationDetail(applicationNo);
    }

    /**
     * to check for docuble judgement no.
     * @param request
     * @param model
     * @param judgementNo
     * @param applicationYear
     * @return true if there is matching of judgement no. with earlier given nos.
     */
    @ResponseBody
    @RequestMapping(value = { "/checkPreviousJudgementNo" }, method = { RequestMethod.GET })
    public ResponseMessage checkPreviousJudgementNo( HttpServletRequest request,Model model,  String judgementNo,  String applicationYear) {
         String serviceId = "512";
         UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
         String courtId = userBean.getJurisdictions()[0].getLocationID();
        return responseMessage = commonService.checkPreviousJudgementNo(judgementNo, serviceId, courtId, applicationYear);
    }

    /**
     * to check for double reg. nos.
     * @param request
     * @param regNo
     * @param applicationYear
     * @return true if it match with earlier reg. no.
     */
    @ResponseBody
    @RequestMapping(value = { "/checkPreviousRegistrationNo" }, method = { RequestMethod.GET })
    public ResponseMessage checkPreviousRegistrationNo( HttpServletRequest request,  String regNo,  String applicationYear) {
         String serviceId = "512";
         UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
         String courtId = userBean.getJurisdictions()[0].getLocationID();
        return responseMessage = commonService.checkPreviousRegistrationNo(regNo, serviceId, courtId, applicationYear);
    }

    /**
     * update service
     * @param request
     * @param applicationDetailDTO
     * @return for update of application.
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = { "/updateNewMarriageCertificate" }, method = { RequestMethod.POST })
    public ResponseMessage updateAffirmationMarriageCertificate( HttpServletRequest request,  ApplicationDetailDTO applicationDetailDTO) throws Exception {
         String applicationNo = applicationDetailDTO.getApplicationNo();
         String regNo = applicationDetailDTO.getRegNo();
         Date regDate = applicationDetailDTO.getRegDate();
         String judgementNo = applicationDetailDTO.getJudgementNo();
         Date judgementDate = applicationDetailDTO.getJudgementDate();
         String lawyer = applicationDetailDTO.getLawyer();
         UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        return responseMessage = updateNewMarriageCertificateService.updateApplication(userBean, applicationNo, regNo, regDate, judgementNo, judgementDate, lawyer);
    }
}
