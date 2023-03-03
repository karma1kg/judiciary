package com.spring.mvc.judiciary.service.commonService;

import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.ReportsDao;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 9/12/2019.
 */
@Service
public class ReportsService {
    @Autowired
    private ReportsDao reportsDao;

    public List<DropdownDTO> getStatusList() {
        return reportsDao.getStatusList();
    }

    public ResponseMessage getReport(Integer serviceId, String newFromDate,String newToDate, String statusId, String courtId) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            List<ApplicationDetailDTO> applicationDetailDTOs = null;
            if (statusId == "0") {//if status is ALL
                statusId = null;
            }
            applicationDetailDTOs = reportsDao.getCertificateReport(serviceId, newFromDate, newToDate, statusId, courtId);
            if (applicationDetailDTOs != null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                responseMessage.setResponseDTO(applicationDetailDTOs);
            } else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("Result not found");
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getReportByCourt(Integer serviceId, String newFromDate,String newToDate, Integer courtId) {
        ResponseMessage responseMessage = new ResponseMessage();
       try {
           List<ApplicationDetailDTO> applicationDetailDTOs = null;
           applicationDetailDTOs = reportsDao.getReportByCourt(serviceId, newFromDate, newToDate, courtId);
           if (applicationDetailDTOs != null) {
               responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
               responseMessage.setResponseDTO(applicationDetailDTOs);
           } else {
               responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
               responseMessage.setResponseText("Result not found");
           }

           return responseMessage;
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }
    public ResponseMessage getReportByService(String newFromDate,String newToDate, Integer serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            List<ApplicationDetailDTO> applicationDetailDTOs = null;
            applicationDetailDTOs = reportsDao.getReportByService(newFromDate, newToDate, serviceId);
            if (applicationDetailDTOs != null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                responseMessage.setResponseDTO(applicationDetailDTOs);
            } else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("Result not found");
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
