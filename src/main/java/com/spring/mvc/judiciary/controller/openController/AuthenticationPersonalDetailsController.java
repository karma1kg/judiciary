package com.spring.mvc.judiciary.controller.openController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.openService.AuthenticationPersonalDetailsService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by N-Zepa on 25-Jul-19.
 */
@Controller
@RequestMapping("/authenticationPersonalDetails")
public class AuthenticationPersonalDetailsController {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    //region private variables
    @Autowired
    private AuthenticationPersonalDetailsService authenticationPersonalDetailsService;

    @Autowired
    private CommonService commonService;
    private ResponseMessage responseMessage;
    //endregion

    //region public methods

    /**
     * index method
     *
     * @param model -- ModelMap
     * @return --String
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "502";
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("auth_type", commonService.getAuthType());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        model.addAttribute("dzongkhagList", commonService.getDzongkhagList());
        return "judiciary/authenticationPersonalDetails";
    }

    @ResponseBody
    @RequestMapping(value = "/getGewogList", method = RequestMethod.GET)
    public List<DropdownDTO> getGewogList(Integer dzoId) {
        List<DropdownDTO> dropdownDTOs = commonService.getGewogListName(dzoId);
        return dropdownDTOs;
    }

    @ResponseBody
    @RequestMapping(value = "/getVillageList", method = RequestMethod.GET)
    public List<DropdownDTO> getVillageList(Integer gewogId) {
        List<DropdownDTO> dropdownDTOs = commonService.getVillageListName(gewogId);
        return dropdownDTOs;
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "502";
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

    /**
     * save method
     *
     * @param applicationDetailDTO -- ApplicationDetailDTO
     * @return -- ResponseMessage
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/saveAuthenticationPersonalDetails", method = RequestMethod.POST)
    public ResponseMessage saveIssueDuplicateCertificate(HttpServletRequest request,ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, WitnessDetailDTO witnessDetailDTO,
                                                         SpouseDetailsDTO spouseDetailsDTO) throws Exception{
        String pattern = "yyyy-MM-dd";
        String patterns = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(patterns);
        String date =simpleDateFormat.format(new Date());
        Integer globalServiceTypeId = ServiceTypeEnum.AUTHENTICATION_PERSONAL_DETAILS.getServiceTypeId();
        String serviceName= ServiceTypeEnum.AUTHENTICATION_PERSONAL_DETAILS.getServiceName();
        BigInteger count = authenticationPersonalDetailsService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
        Integer Dayhour= new DateTime().getHourOfDay();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
        Integer holiday = Integer.valueOf((new DateTime()).getDayOfWeek());
      /*  if( ((Dayhour<9) || (Dayhour>=17 && DayMinute>00 && DaySecond>00))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application is opened only during office hours which is between 09:00 AM to 5:00 pm");
        }
*/
         if(count.intValue()>=5) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+serviceName+" reached maximum limit set by the system, please try again next day");
        }
        /* else if(!holiday.equals(6) ||!(holiday.equals(7))){
             responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
             responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
         }*/
        else {
            responseMessage = authenticationPersonalDetailsService.saveAuthenticationPersonalDetails(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        } return responseMessage;
    }
    //endregion
}
