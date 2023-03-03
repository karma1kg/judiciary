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
 * reports by court
 */
@Controller
@RequestMapping("/reportsByCourt")
public class ReportsControllerByCourt {
    @Autowired
    private ReportsService reportsService;
    @Autowired
    private CommonService commonService;

    ResponseMessage responseMessage;

    @RequestMapping(method = RequestMethod.GET)
    public String reportsByCourt(HttpServletRequest request,ModelMap model) {
       // List<DropdownDTO> serviceList = commonService.getServiceName();
 //       model.addAttribute("serviceList", serviceList);
        List<DropdownDTO> court_list= commonService.getAllCourt();
        model.addAttribute("court_list", court_list);
        List<DropdownDTO> serviceList= commonService.getServiceName();
        model.addAttribute("serviceList", serviceList);
        return "report/reportsByCourt";
    }

    /**
     * report for court
     * @param request
     * @param serviceId
     * @param courtId
     * @param fromDate
     * @param toDate
     * @return report details for selected court
     */
    @ResponseBody
    @RequestMapping(value = "/getReportByCourt", method = RequestMethod.GET)
    public ResponseMessage getReportByCourt(HttpServletRequest request, Integer serviceId, Integer courtId, Date fromDate, Date toDate) {
        String newFromDate = formatDate(fromDate);
        String newToDate = formatDate1(toDate);
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        //String courtId = userBean.getJurisdictions()[0].getLocationID();
        responseMessage = reportsService.getReportByCourt(serviceId, newFromDate, newToDate, courtId);
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
