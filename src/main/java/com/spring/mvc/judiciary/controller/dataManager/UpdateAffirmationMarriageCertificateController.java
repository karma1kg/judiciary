// 
// Decompiled by Procyon v0.5.36
// 

package com.spring.mvc.judiciary.controller.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.dataManager.UpdateAffirmationMarriageCertificateService;
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
 * for update by data manager
 */
@Controller
@RequestMapping({ "/updateAffirmationMarriageCertificate" })
public class UpdateAffirmationMarriageCertificateController
{
    @Autowired
    private UpdateAffirmationMarriageCertificateService updateAffirmationMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;
    Calendar calendar;
    Integer currentYear;

    public UpdateAffirmationMarriageCertificateController() {
        this.calendar = Calendar.getInstance();
        this.currentYear = this.calendar.get(1);
    }
    /**
     * to redirect to page from data manager tasklist
     * @param model
     * @returns page
     */
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD })
    public String index(final ModelMap model) {
        if (model.size() != 0) {
            final List<DropdownDTO> rejectReasons = (List<DropdownDTO>)this.commonService.getRejectReasons();
            model.addAttribute("rejectReasons", (Object)rejectReasons);

            return "dataManager/updateAffirmationMarriageCertificate";
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
    public ResponseMessage getApplicationDetail(final String applicationNo) {
        return this.responseMessage = this.commonService.getApplicationDetails(applicationNo);
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
    public ResponseMessage checkPreviousJudgementNo(final HttpServletRequest request,Model model, final String judgementNo, final String applicationYear) {
        final String serviceId = "503";
        final UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        final String courtId = userBean.getJurisdictions()[0].getLocationID();
        return this.responseMessage = this.commonService.checkPreviousJudgementNo(judgementNo, serviceId, courtId, applicationYear);
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
    public ResponseMessage checkPreviousRegistrationNo(final HttpServletRequest request, final String regNo, final String applicationYear) {
        final String serviceId = "503";
        final UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        final String courtId = userBean.getJurisdictions()[0].getLocationID();
        return this.responseMessage = this.commonService.checkPreviousRegistrationNo(regNo, serviceId, courtId, applicationYear);
    }

    /**
     * update service
     * @param request
     * @param applicationDetailDTO
     * @return for update of application.
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = { "/updateAffirmationMarriageCertificate" }, method = { RequestMethod.POST })
    public ResponseMessage updateAffirmationMarriageCertificate(final HttpServletRequest request, final ApplicationDetailDTO applicationDetailDTO) throws Exception {
        final String applicationNo = applicationDetailDTO.getApplicationNo();
        final String regNo = applicationDetailDTO.getRegNo();
        final Date regDate = applicationDetailDTO.getRegDate();
        final String judgementNo = applicationDetailDTO.getJudgementNo();
        final Date judgementDate = applicationDetailDTO.getJudgementDate();
        final String lawyer = applicationDetailDTO.getLawyer();
        final UserRolePrivilegeDto userBean = (UserRolePrivilegeDto)request.getSession().getAttribute("UserRolePrivilege");
        return this.responseMessage = this.updateAffirmationMarriageCertificateService.updateApplication(userBean, applicationNo, regNo, regDate, judgementNo, judgementDate, lawyer);
    }
}