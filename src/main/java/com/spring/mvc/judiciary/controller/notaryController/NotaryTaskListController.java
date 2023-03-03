package com.spring.mvc.judiciary.controller.notaryController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.notaryService.NotaryTaskListService;
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

/**
 * Created by USER on 8/2/2019.
 */

/**
 * request for notary tasklist controller
 */
@Controller
@RequestMapping("/notaryTaskList")
public class NotaryTaskListController {
    @Autowired
    private NotaryTaskListService notaryTaskListService;
    ResponseMessage responseMessage;

    /**
     * request notary tasklist with service id for segregating the service wise applications
     * @param request
     * @param modelMap
     * @param serviceId
     * @return notary dashboard
     */
    @RequestMapping(value = "/{serviceId}",method = RequestMethod.GET)
    public String index(HttpServletRequest request,ModelMap modelMap,@PathVariable String serviceId) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        // String serviceId = userBean.getCurrentRole().getServices()[0].getServiceId();
        modelMap.addAttribute("serviceId",serviceId);
        return "notary/notaryTaskList";
    }

   /* @ResponseBody
    @RequestMapping(value = "/getNotaryTaskListByServiceId", method = RequestMethod.GET)
    public ResponseMessage getNotaryTaskListByServiceId(HttpServletRequest request, HttpServletResponse response) {
        UserRolePrivilege userBean = (UserRolePrivilege) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        String serviceId = userBean.getCurrentRole().getServices()[0].getServiceId();
        responseMessage = notaryTaskListService.getNotaryTaskListByServiceId(courtId,serviceId);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/getClaimedTaskListByServiceId", method = RequestMethod.GET)
    public ResponseMessage getClaimedTaskListByServiceId(HttpServletRequest request, HttpServletResponse response) {
        UserRolePrivilege userBean = (UserRolePrivilege) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = notaryTaskListService.getClaimedTaskListByServiceId(userBean);
        return responseMessage;
    }*/

    /**
     * finds for tasklist in notary
     *  finds for get tasklist for notary
     * @param request
     * @return get notary tasklists
     */
    @ResponseBody
    @RequestMapping(value = "/notaryTaskList/getNotaryTaskList", method = RequestMethod.GET)
    public ResponseMessage getNotaryTaskList(HttpServletRequest request) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        //String serviceId = userBean.getCurrentRole().getServices()[0].getServiceId();
        //Integer globalServiceTypeId = ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceTypeId();
        String serviceId = request.getParameter("serviceId");
        responseMessage = notaryTaskListService.getNotaryTaskList(courtId,serviceId);
        return responseMessage;
    }

    /**
     * request for tasks which are claimed as group task
     * @param request
     * @param response
     * @return all claimed tasks
     */
    @ResponseBody
    @RequestMapping(value = "/notaryTaskList/getClaimedTaskList", method = RequestMethod.GET)
    public ResponseMessage getClaimedTaskList(HttpServletRequest request, HttpServletResponse response) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String serviceId = request.getParameter("serviceId");
        responseMessage = notaryTaskListService.getClaimedTaskList(userBean,serviceId);
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
    @RequestMapping(value = "/notaryTaskList/saveClaimTask", method = RequestMethod.POST)
    public ResponseMessage saveClaimTask(HttpServletRequest request, HttpServletResponse response, String applicationNo) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = notaryTaskListService.saveClaimTask(userBean, applicationNo);
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
    @RequestMapping(value = "/notaryTaskList/saveUnClaimTask", method = RequestMethod.POST)
    public ResponseMessage saveUnClaimTask(HttpServletRequest request, HttpServletResponse response, String applicationNo) {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = notaryTaskListService.saveUnClaimTask(userBean, applicationNo);
        return responseMessage;
    }

    /**
     * for redirects to particular page
     * @param applicationNo
     * @param redirectAttributes
     * @return page
     */
    @RequestMapping(value = "/notaryTaskList/navigateToApproveMarriageCertificate", method = RequestMethod.GET)
    public String navigateToApproveMarriageCertificate(String applicationNo,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveMarriageCertificate";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveAuthenticationPersonalDetails", method = RequestMethod.GET)
    public String navigateToApproveAuthenticationPersonalDetails(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveAuthenticationPersonalDetails";
    }
    @RequestMapping(value = "/notaryTaskList/navigateToApproveAffirmationMarriageCertificate", method = RequestMethod.GET)
    public String navigateToApproveAffirmationMarriageCertificate(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveAffirmationMarriageCertificate";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveLostDocument", method = RequestMethod.GET)
    public String navigateToApproveLostDocument(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveLostDocument";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveSingleMaritalStatus", method = RequestMethod.GET)
    public String navigateToApproveSingleMaritalStatus(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveSingleMaritalStatus";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveChildTravelDocument", method = RequestMethod.GET)
    public String navigateToApproveChildTravelDocument(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveChildTravelDocument";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveAttestationDocument", method = RequestMethod.GET)
    public String navigateToApproveAttestationDocument(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveAttestationDocument";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveChildAdoption", method = RequestMethod.GET)
    public String navigateToApproveChildAdoption(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveChildAdoption";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveOrganTransplant", method = RequestMethod.GET)
    public String navigateToApproveOrganTransplant(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveOrganTransplant";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveClosingTransferAccounts", method = RequestMethod.GET)
    public String navigateToApproveClosingTransferAccounts(String applicationNo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveClosingTransferAccounts";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveAttestAgreementWillsContract", method = RequestMethod.GET)
    public String navigateToApproveAttestAgreementWillsContract(String applicationNo,  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveAttestAgreementWillsContract";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveNewMarriageCertificate", method = RequestMethod.GET)
    public String navigateToApproveNewMarriageController(String applicationNo,  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveNewMarriageCertificate";
    }

    @RequestMapping(value = "/notaryTaskList/navigateToApproveDivorceApplication", method = RequestMethod.GET)
    public String navigateToApproveDivorceApplication(String applicationNo,  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("applicationNo", applicationNo);
        redirectAttributes.addFlashAttribute("urlRedirectBack", "notaryTaskList");
        return "redirect:/approveNewMarriageCertificate";
    }
}
