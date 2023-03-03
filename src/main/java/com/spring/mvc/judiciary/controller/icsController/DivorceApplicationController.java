package com.spring.mvc.judiciary.controller.icsController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.icsService.DivorceApplicationService;
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

/*Created by kg on 04/08/2022.*/

/**
 * For divorce application
 */

@Controller
@RequestMapping("/divorceApplication")
public class DivorceApplicationController {
    //declare private variables
    @Autowired
    private DivorceApplicationService divorceApplicationService;
    @Autowired
    private CommonService commonService;
    private ResponseMessage responseMessage;
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    Integer currentDate=calendar.get(Calendar.DATE);
    Date todayDate=calendar.getTime();

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "513";
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        model.addAttribute("applicant",commonService.getApplicantName());
       // model.addAttribute("spouseName",commonService.getSpouseName());
        return "icsApplication/divorceApplication";
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "513";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistSpouse(String cidNo) {
        String serviceId = "513";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedApplicant(String cidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO) {
        String serviceId = "513";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.getCidDetails(request,cidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getSpouseCid();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        responseMessage = commonService.checkForAlreadyMarriedApplicant(cidNo, serviceId,spouseCid,judgementNo);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedSpouse(String spouseCidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO) {
        String serviceId = "513";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.get_CidDetails(request,spouseCidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getCidNo();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        responseMessage = commonService.checkForAlreadyMarriedSpouse(spouseCidNo,serviceId,spouseCid,judgementNo);
        return responseMessage;
    }

    /*@ResponseBody
    @RequestMapping(value = "/getDivorceStatus", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo, HttpServletRequest httpServletRequest, Model model) {
       responseMessage=commonService.getDivorceStatus(cidNo);
        return responseMessage;
    }*/



   /* @ResponseBody
    @RequestMapping(value = "/getDivorceDetails", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo, HttpServletRequest httpServletRequest, Model model) {
   ApplicantDetailDTO applicantDetailDTO=new ApplicantDetailDTO();
        responseMessage = commonService.getDivorceDetails(cidNo);
        return responseMessage;
    }*/


    /**
     * for fetch of citizen details
     * @param cidNo
     * @return citizen details from dcrc api
     */
    @ResponseBody
    @RequestMapping(value = "/getCitizenDetails", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo) {
        responseMessage = commonService.getCitizenDetails(cidNo);
        return responseMessage;
    }

    /*@ResponseBody
    @RequestMapping(value = "/getDivorceDetailsWithSpouse", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetailsWithSpouse(String cidNo, HttpServletRequest httpServletRequest, Model model) {
        ApplicantDetailDTO applicantDetailDTO=new ApplicantDetailDTO();
        responseMessage = commonService.getDivorceDetailsWithSpouse(cidNo);
        return responseMessage;
    }*/

    @ResponseBody
    @RequestMapping(value = "/saveDivorceApplication", method = RequestMethod.POST)
    public ResponseMessage saveAffirmationMarriageCertificate(HttpServletRequest request,
                                                              ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                              WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws Exception {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        Integer holiday=new DateTime().getDayOfWeek();
        Integer Dayhour= new DateTime().getHourOfDay();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
        Integer globalServiceTypeId = ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceTypeId();
        String serviceName = ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceName();
        System.out.println(Dayhour);
        System.out.println(DayMinute);
        System.out.println(DaySecond);
        BigInteger count=divorceApplicationService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
/*
 if( ((Dayhour<9) || (Dayhour>=17 && DayMinute>00 && DaySecond>00))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application is opened only during office hours which is between 09:00 AM to 5:00 pm");
        }
*/

         if(count.intValue()>=20) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+serviceName+" reached maximum limit set by the system, please try again next day");
        }
/*else if(holiday==6 ||holiday==7){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
        }*/

        else {
            responseMessage = divorceApplicationService.saveDivorceApplication(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        }
        return responseMessage;
    }

}
