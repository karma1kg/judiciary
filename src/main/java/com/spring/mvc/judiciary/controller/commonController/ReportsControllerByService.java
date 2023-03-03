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
 * report for service
 */
@Controller
@RequestMapping("/reportByService")
public class ReportsControllerByService {
    @Autowired
    private ReportsService reportsService;

    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    @RequestMapping(method = RequestMethod.GET)
    public String reportsByService(HttpServletRequest request,ModelMap model) {
        List<DropdownDTO> serviceList = commonService.getServiceName();
        model.addAttribute("serviceList", serviceList);
        return "report/reportsByService";
    }

    /**
     * request for report of service
     * @param request
     * @param fromDate
     * @param toDate
     * @param serviceId
     * @return get report details for selected service
     */
    @ResponseBody
    @RequestMapping(value = "/getReportByService", method = RequestMethod.GET)
    public ResponseMessage getReportByService(HttpServletRequest request, Date fromDate, Date toDate,Integer serviceId) {
        String newFromDate = formatDate(fromDate);
        String newToDate = formatDate1(toDate);
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        //String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = reportsService.getReportByService(newFromDate, newToDate, serviceId);
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
}
