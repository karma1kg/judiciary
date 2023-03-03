package com.spring.mvc.judiciary.controller.icsController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.icsService.NewMarriageCertificateService;
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
import java.util.Date;

/**
 * Created by kg on 19/08/2022.
 */

/**
 * for new mc
 */
@Controller
@RequestMapping("/newMarriageCertificate")
public class NewMarriageCertificateController {
    //region private variables
    @Autowired
    private NewMarriageCertificateService newMarriageCertificateService;
    @Autowired
    private CommonService commonService;
    private ResponseMessage responseMessage;
    //endregion

    //region public methods

    /**
     * index method for Issuance Of Marriage Certificate Registration Form
     *
     * @param model -- ModelMap
     * @return -- String
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "512";
        model.addAttribute("religion_list", commonService.getAllReligion());
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "icsApplication/newMarriageCertificate";
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "512";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo,serviceId);
        return responseMessage;
    }
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistSpouse(String cidNo) {
        String serviceId = "512";
        responseMessage = commonService.checkForAlreadyExistSpouse(cidNo,serviceId);
        return responseMessage;
    }

    //dont check if its divorced
    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedApplicant(String cidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO, ApplicationDetailDTO applicationDetailDTO) {
        String serviceId = "512";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.getCidDetails(request,cidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getSpouseCid();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        // ApplicationDetailDTO applicationDetailDTO1=commonService.getJudgementNumber(request,cidNo,applicationDetailDTO);
        responseMessage = commonService.checkForAlreadyMarriedApplicants(cidNo, serviceId,spouseCid,judgementNo);
        return responseMessage;
    }

    /**
     * second or 3rd marriage allows only after 60 days of divorce, itc checks marriage and divorce for 3 times each
    // * @param cidNo
     * @param request
     * @param applicantDetailDTO
     * @return response message
     */
    @ResponseBody
    @RequestMapping(value = "/checkForMcApplied3Times", method = RequestMethod.GET)
    public ResponseMessage checkForMcApplied3Times(String cidNo, HttpServletRequest request, ApplicantDetailDTO applicantDetailDTO){
        String serviceId="512";
        ApplicantDetailDTO applicantDetailDTO1=new ApplicantDetailDTO();
        ApplicationDetailDTO applicationDetailDTO1=new ApplicationDetailDTO();
        applicantDetailDTO1=commonService.getCidDetails(request,cidNo,applicantDetailDTO,serviceId);
       // String statusId=commonService.getStatusId(cidNo);
        //String marital_status=commonService.marital_status(cidNo);
        // applicationDetailDTO1.getStatusId();
       //responseMessage = commonService.getCreatedDate(cidNo,serviceId);
        responseMessage=commonService.checkForMcApplied3Times(cidNo,serviceId);
        return responseMessage;
    }



    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyMarriedSpouse", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyMarriedSpouse(String spouseCidNo,HttpServletRequest request,ApplicantDetailDTO applicantDetailDTO) {
        String serviceId = "512";
        ApplicantDetailDTO applicantDetailDTO1 = new ApplicantDetailDTO();
        applicantDetailDTO1=commonService.get_CidDetails(request,spouseCidNo,applicantDetailDTO,serviceId);
        String spouseCid = applicantDetailDTO1.getCidNo();
        String judgementNo= applicantDetailDTO1.getJudgementNo();
        responseMessage = commonService.checkForAlreadyMarriedSpouse(spouseCidNo,serviceId,spouseCid,judgementNo);
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


   /* @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseMessage getCitizenDetails(String cidNo) {
        responseMessage = commonService.getCitizenDetails(cidNo);
        return responseMessage;
    }*/



    @ResponseBody
    @RequestMapping(value = "/savenewMarriageCertificate", method = RequestMethod.POST)
    public ResponseMessage saveNewMarriageCertificate(HttpServletRequest request,
                                                   ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                   WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO)throws Exception{
        String pattern = "yyyy-MM-dd";
        String patterns = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(patterns);
        String date =simpleDateFormat.format(new Date());
        Integer holiday=new DateTime().getDayOfWeek();
        Integer globalServiceTypeId = ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceTypeId();
        String serviceName= ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceName();
        BigInteger count = newMarriageCertificateService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
        Integer Dayhour= new DateTime().getHourOfDay    ();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
         if(count.intValue()>=10) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+serviceName+" reached maximum limit set by the system, please try again next day");
        }
        /*else if(holiday==6 ||holiday==7){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
        }*/
        else {
            responseMessage = newMarriageCertificateService.saveMarriageCertificate(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        }
        return responseMessage;
    }
    //endregion


}
