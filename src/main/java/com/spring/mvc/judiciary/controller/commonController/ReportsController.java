package com.spring.mvc.judiciary.controller.commonController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.commonService.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by USER on 9/12/2019.
 */

/**
 * for reports in common with status
 */
@Controller
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    private ReportsService reportsService;
    @Autowired
    private CommonService commonService;

    ResponseMessage responseMessage;

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request,ModelMap model) {
        List<DropdownDTO> serviceList = commonService.getServiceName();
        List<DropdownDTO> statusList = reportsService.getStatusList();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("statusList", statusList);
        return "report/reports";
    }

    /**
     * to retrieve for with status reports
     * @param request
     * @param serviceId
     * @param fromDate
     * @param toDate
     * @param statusId
     * @return reports with select status
     */
    @ResponseBody
    @RequestMapping(value = "/getReport", method = RequestMethod.GET)
    public ResponseMessage getReport(HttpServletRequest request, Integer serviceId, Date fromDate, Date toDate, String statusId) {
        String newFromDate = formatDate(fromDate);
        String newToDate = formatDate1(toDate);
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = reportsService.getReport(serviceId, newFromDate, newToDate, statusId, courtId);
        return responseMessage;
    }
    private String formatDate(Date newFromDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(newFromDate);
        return date;
    }
    private String formatDate1(Date newToDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(newToDate);
        return date;
    }


    /*@ResponseBody
    @RequestMapping(value = "/reportsByService", method = RequestMethod.GET)
    public ResponseMessage getReport(HttpServletRequest request, Integer serviceId, Date fromDate, Date toDate, String statusId) {
        String newFromDate = formatDate(fromDate);
        String newToDate = formatDate1(toDate);
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = reportsService.getReport(serviceId, newFromDate, newToDate, statusId, courtId);
        return responseMessage;
    }*/



}
