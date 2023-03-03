package com.spring.mvc.judiciary.controller.openController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.openService.ChildAdoptionService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/20/2020.
 */
@Controller
@RequestMapping("/childAdoption")
public class ChildAdoptionController {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @Autowired
    private ChildAdoptionService childAdoptionService;

    @Autowired
    private CommonService commonService;
    private ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "508";
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "judiciary/childAdoption";
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "508";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistSpouse(String cidNo) {
        String serviceId = "508";
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
    @RequestMapping(value = "/saveChildAdoption", method = RequestMethod.POST)
    public ResponseMessage saveChildAdoption(HttpServletRequest request,ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, WitnessDetailDTO witnessDetailDTO,
                                                   SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        String pattern = "yyyy-MM-dd";
        String patterns = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(patterns);
        String date =simpleDateFormat.format(new Date());
        Integer globalServiceTypeId = ServiceTypeEnum.CHILD_ADOPTION.getServiceTypeId();
        String serviceName=  ServiceTypeEnum.CHILD_ADOPTION.getServiceName();
        BigInteger count = childAdoptionService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
        Integer Dayhour= new DateTime().getHourOfDay();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
        Integer holiday = Integer.valueOf((new DateTime()).getDayOfWeek());
       /* if( ((Dayhour<9) || (Dayhour>=17 && DayMinute>00 && DaySecond>00))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application is opened only during office hours which is between 09:00 AM to 5:00 pm");
        }*/
         if(count.intValue()>=5) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+serviceName+" reached maximum limit set by the system, please try again next day");
        }
        /* else if(!holiday.equals(6) ||!(holiday.equals(7))){
             responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
             responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
         }*/
        responseMessage = childAdoptionService.saveChildAdoption(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        return responseMessage;
    }
}
