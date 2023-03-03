package com.spring.mvc.judiciary.controller.openController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.openService.ClosingTransferAccountsService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/27/2020.
 */
@Controller
@RequestMapping("/closingTransferAccounts")
public class ClosingTransferAccountsController {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @Autowired
    private ClosingTransferAccountsService closingTransferAccountsService;

    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;
    ArrayList<String> contactNo = new ArrayList<String>();
    String[] contactNums;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "510";
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "judiciary/closingTransferAccounts";
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "510";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }

    /**
     * to get citizen name by cid no.
     *
     * @param cidNo --String
     * @return --ResponseMessage
     */
    @ResponseBody
    @RequestMapping(value = "/getCitizenDetails", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo) {
        responseMessage = commonService.getCitizenDetails(cidNo);
        return responseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/saveClosingTransferAccounts", method = RequestMethod.POST)
    public ResponseMessage saveClosingTransferAccounts(HttpServletRequest request,
                                            ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                            WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws Exception {
        String pattern = "yyyy-MM-dd";
        String patterns = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(patterns);
        String date =simpleDateFormat.format(new Date());
        Integer globalServiceTypeId = ServiceTypeEnum.CLOSING_AND_TRANSFER_OF_SHARES_AND_ACCOUNTS.getServiceTypeId();
        String seviceName= ServiceTypeEnum.CLOSING_AND_TRANSFER_OF_SHARES_AND_ACCOUNTS.getServiceName();
        BigInteger count = closingTransferAccountsService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
        Integer Dayhour= new DateTime().getHourOfDay();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
        Integer holiday = Integer.valueOf((new DateTime()).getDayOfWeek());
        /*if( ((Dayhour<9) || (Dayhour>=17 && DayMinute>00 && DaySecond>00))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application is opened only during office hours which is between 09:00 AM to 5:00 pm");
        }*/
         if(count.intValue()>=5) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+seviceName+" reached maximum limit set by the system, please try again next day");
        }
        /* else if(!holiday.equals(6) ||!(holiday.equals(7))){
             responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
             responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
         }*/
        else {
            responseMessage = closingTransferAccountsService.saveClosingTransferAccounts(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        }
            return responseMessage;
    }
}
