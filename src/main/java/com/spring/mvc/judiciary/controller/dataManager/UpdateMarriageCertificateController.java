package com.spring.mvc.judiciary.controller.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.dataManager.UpdateMarriageCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 8/2/2019.
 */
@Controller
@RequestMapping("/updateMarriageCertificate")
public class UpdateMarriageCertificateController {
    @Autowired
    private UpdateMarriageCertificateService updateMarriageCertificateService;
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
            return "dataManager/updateMarriageCertificate";
        } else {
            return "redirect:/dataManagerTaskList";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getApplicationDetail", method = RequestMethod.GET)
    public ResponseMessage getApplicationDetail(String applicationNo,ModelMap model) {
        responseMessage = commonService.getApplicationDetail(applicationNo);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/checkPreviousJudgementNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousJudgementNo(HttpServletRequest request,String judgementNo,String applicationYear) {
        String serviceId = "501";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = commonService.checkPreviousJudgementNo(judgementNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPreviousRegistrationNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousRegistrationNo(HttpServletRequest request,String regNo,String applicationYear) {
        String serviceId = "501";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = commonService.checkPreviousRegistrationNo(regNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

   /* @ResponseBody
    @RequestMapping(value = "/updateMarriageCertificate", method = RequestMethod.POST)
    public ResponseMessage updateMarriageCertificate(HttpServletRequest request, HttpServletResponse response,
                                                     ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                     SpouseDetailsDTO spouseDetailsDTO) throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = updateMarriageCertificateService.updateApplication(userBean, applicationDetailDTO, applicantDetailDTO, spouseDetailsDTO);
        return responseMessage;
    }*/

    @ResponseBody
    @RequestMapping(
            value = {"/updateMarriageCertificate"},
            method = {RequestMethod.POST}
    )
    public ResponseMessage updateMarriageCertificate(HttpServletRequest request, HttpServletResponse response, ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        this.responseMessage = this.updateMarriageCertificateService.updateApplication(userBean, applicationDetailDTO, applicantDetailDTO, spouseDetailsDTO);
        return this.responseMessage;
    }
}
