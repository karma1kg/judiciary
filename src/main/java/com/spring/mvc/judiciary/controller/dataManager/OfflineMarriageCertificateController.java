package com.spring.mvc.judiciary.controller.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
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
import java.util.Calendar;

/**
 * Created by USER on 8/2/2019.
 */

/**
 * for offline applications for mc, as for comments, refer in affirmation of application
 */
@Controller
@RequestMapping("/offlineMarriageCertificate")
public class OfflineMarriageCertificateController {
    @Autowired
    private UpdateMarriageCertificateService updateMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model,HttpServletRequest request) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        Integer courtId = Integer.valueOf(userBean.getJurisdictions()[0].getLocationID());
        String Service_Id = "501";
        model.addAttribute("religion_list", commonService.getAllReligion());
        model.addAttribute("court_list", commonService.getAllCourtOffline(courtId));
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "offlineApplication/offlineMarriageCertificate";
    }

    @ResponseBody
    @RequestMapping(value = "/getCitizenDetails", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo) {
        responseMessage = commonService.getCitizenDetails(cidNo);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "501";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistSpouse(String cidNo) {
        String serviceId = "501";
        responseMessage = commonService.checkForAlreadyExistSpouse(cidNo,serviceId);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedApplicant(String cidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO) {
        String serviceId = "501";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.getCidDetails(request,cidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getSpouseCid();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        // ApplicationDetailDTO applicationDetailDTO1=commonService.getJudgementNumber(request,cidNo,applicationDetailDTO);
        responseMessage = commonService.checkForAlreadyMarriedApplicant(cidNo, serviceId,spouseCid,judgementNo);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedSpouse(String spouseCidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO) {
        String serviceId = "501";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.get_CidDetails(request,spouseCidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getCidNo();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        responseMessage = commonService.checkForAlreadyMarriedSpouse(spouseCidNo,serviceId,spouseCid,judgementNo);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/checkPreviousJudgementNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousJudgementNo(HttpServletRequest request,String judgementNo) {
        String serviceId = "501";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        String applicationYear = currentYear.toString().substring(2, 4);
        responseMessage = commonService.checkPreviousJudgementNo(judgementNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPreviousRegistrationNo", method = RequestMethod.GET)
    public ResponseMessage checkPreviousRegistrationNo(HttpServletRequest request,String regNo) {
        String serviceId = "501";
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String applicationYear = currentYear.toString().substring(2, 4);
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = commonService.checkPreviousRegistrationNo(regNo,serviceId,courtId,applicationYear);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/saveMarriageCertificate", method = RequestMethod.POST)
    public ResponseMessage saveMarriageCertificate(HttpServletRequest request, HttpServletResponse response,
                                                   ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                   WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO)throws Exception{
        responseMessage = updateMarriageCertificateService.saveMarriageCertificate(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        return responseMessage;
    }
}
