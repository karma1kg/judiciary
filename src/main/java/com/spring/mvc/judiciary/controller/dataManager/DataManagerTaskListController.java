package com.spring.mvc.judiciary.controller.dataManager;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.dataManager.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * Created by USER on 8/2/2019.
 */
/**
 * request for data manager tasklist controller
 */
@Controller
@RequestMapping("/dataManagerTaskList")
public class DataManagerTaskListController {
    @Autowired
    private DataManagerService dataManagerService;
    ResponseMessage responseMessage;
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);

    /**
     * request data manager with service id for segregating the service wise applications
     * @param request
     * @param response
     * @param model
     * @param serviceId
     * @return data manager tasklist
     */
    @RequestMapping(value = "/{serviceId}",method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model,@PathVariable String serviceId) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        model.addAttribute("serviceId",serviceId);
            return "dataManager/dataManagerTaskList";
    }

    /**
     * finds for tasklist in data manager
     *  finds for get tasklist for notary
     * @param request
     * @return get data manager tasklists
     */
    @ResponseBody
    @RequestMapping(value = "/dataManagerTaskList/getDataManagerTaskList", method = RequestMethod.GET)
    public ResponseMessage getDataManagerTaskList(HttpServletRequest request, HttpServletResponse response) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        String serviceId=request.getParameter("serviceId");
        responseMessage = dataManagerService.getDataManagerTaskList(courtId,serviceId);
        return responseMessage;
    }
    /**
     * request for tasks which are claimed as group task
     * @param request
     * @param response
     * @return all claimed tasks
     */
    @ResponseBody
    @RequestMapping(value = "/dataManagerTaskList/getUpdateClaimedTaskList", method = RequestMethod.GET)
    public ResponseMessage getUpdateClaimedTaskList(HttpServletRequest request, HttpServletResponse response) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String serviceId=request.getParameter("serviceId");
        responseMessage = dataManagerService.getUpdateClaimedTaskList(userBean,serviceId);
        return responseMessage;
    }
    /**
     * for save of claimed tasks
     * @param request
     * @param response
     * @param applicationNo
     * @return saves for claimed tasks in group task
     */
    @ResponseBody
    @RequestMapping(value = "/dataManagerTaskList/saveUpdateClaimTask", method = RequestMethod.POST)
    public ResponseMessage saveUpdateClaimTask(HttpServletRequest request, HttpServletResponse response, String applicationNo) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = dataManagerService.saveUpdateClaimTask(userBean, applicationNo);
        return responseMessage;
    }
    /**
     * for unclaim of task and save in my task again
     * @param request
     * @param response
     * @param applicationNo
     * @return response message with application thrown into my task
     */
    @ResponseBody
    @RequestMapping(value = "/dataManagerTaskList/saveUpdateUnClaimTask", method = RequestMethod.POST)
    public ResponseMessage saveUpdateUnClaimTask(HttpServletRequest request, HttpServletResponse response, String applicationNo) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        Calendar calendar = Calendar.getInstance();
        Integer currentYear = calendar.get(Calendar.YEAR);
        responseMessage = dataManagerService.saveUpdateUnClaimTask(userBean, applicationNo);
        return responseMessage;
    }
    /**
     * for redirects to particular page
     * @param applicationNo
     * @param redirectAttributes
     * @return to controller for loading particular page
     */
    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateMarriageCertificate", method = RequestMethod.GET)
    public String navigateToUpdateMarriageCertificate(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateMarriageCertificate";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateAuthenticationPersonalDetails", method = RequestMethod.GET)
    public String navigateToUpdateAuthenticationPersonalDetails(String applicationNo,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateAuthenticationPersonalDetails";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateAffirmationMarriageCertificate", method = RequestMethod.GET)
    public String navigateToUpdateAffirmationMarriageCertificate(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateAffirmationMarriageCertificate";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateLostDocument", method = RequestMethod.GET)
    public String navigateToUpdateLostDocument(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateLostDocument";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateSingleMaritalStatus", method = RequestMethod.GET)
    public String navigateToUpdateSingleMaritalStatus(String applicationNo,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateSingleMaritalStatus";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateChildTravelDocument", method = RequestMethod.GET)
    public String navigateToUpdateChildTravelDocument(String applicationNo,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateChildTravelDocument";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateAttestationDocument", method = RequestMethod.GET)
    public String navigateToUpdateAttestationDocument(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateAttestationDocument";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateChildAdoption", method = RequestMethod.GET)
    public String navigateToUpdateChildAdoption(String applicationNo,  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateChildAdoption";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateOrganTransplant", method = RequestMethod.GET)
    public String navigateToUpdateOrganTransplant(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateOrganTransplant";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateClosingTransferAccounts", method = RequestMethod.GET)
    public String navigateToUpdateClosingTransferAccounts(String applicationNo,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateClosingTransferAccounts";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateAttestAgreementWillsContract", method = RequestMethod.GET)
    public String navigateToUpdateAttestAgreementWillsContract(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateAttestAgreementWillsContract";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateNewMarriageCertificate", method = RequestMethod.GET)
    public String navigateToUpdateNewMarriageCertificate(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateNewMarriageCertificate";
    }

    @RequestMapping(value = "/dataManagerTaskList/navigateToUpdateDivorceApplication", method = RequestMethod.GET)
    public String navigateToUpdateDivorceApplication(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        String applicationYear=currentYear.toString();
        //model.addAttribute("ApplicationYear",ApplicationYear);
        redirectAttributes.addFlashAttribute("applicationYear", applicationYear);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "dataManagerTaskList");
        return "redirect:/updateNewMarriageCertificate";
    }
}
