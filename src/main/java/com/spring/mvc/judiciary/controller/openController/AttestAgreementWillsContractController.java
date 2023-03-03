package com.spring.mvc.judiciary.controller.openController;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import com.spring.mvc.judiciary.dto.WitnessDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.service.openService.AttestAgreementWillsContractService;
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
import java.util.Date;

/**
 * Created by Sonam Tobgay on 2/29/2020.
 */
@Controller
@RequestMapping("/attestAgreementWillsContract")
public class AttestAgreementWillsContractController {
    @Autowired
    private AttestAgreementWillsContractService attestAgreementWillsContractService;

    @Autowired
    private CommonService commonService;
    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "511";
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "judiciary/attestAgreementWillsContract";
    }

    @ResponseBody
    @RequestMapping(value = "/checkForAlreadyExistApplicant", method = RequestMethod.GET)
    public ResponseMessage checkForAlreadyExistApplicant(String cidNo) {
        String serviceId = "511";
        responseMessage = commonService.checkForAlreadyExistApplicant(cidNo, serviceId);
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
    @RequestMapping(value = "/saveAttestAgreementWillsContract", method = RequestMethod.POST)
    public ResponseMessage saveAttestAgreementWillsContract(HttpServletRequest request, ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, WitnessDetailDTO witnessDetailDTO,
                                                            SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        String pattern = "yyyy-MM-dd";
        String patterns = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat(patterns);
        String date =simpleDateFormat.format(new Date());
        Integer globalServiceTypeId = ServiceTypeEnum.ATTEST_AGREEMENTS_WILLS_CONTRACTS_AND_TESTAMENTS.getServiceTypeId();
        BigInteger count = attestAgreementWillsContractService.getCount(date,applicationDetailDTO.getCourtId(),globalServiceTypeId);
        String serviceName=ServiceTypeEnum.ATTEST_AGREEMENTS_WILLS_CONTRACTS_AND_TESTAMENTS.getServiceName();
        Integer Dayhour= new DateTime().getHourOfDay();      // 7
        Integer DayMinute=(new DateTime().getMinuteOfHour());   // 19
        Integer DaySecond= (new DateTime().getSecondOfMinute()); // 16
        Integer holiday = Integer.valueOf((new DateTime()).getDayOfWeek());
        /*if( ((Dayhour<9) || (Dayhour>=17 && DayMinute>00 && DaySecond>00))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application is opened only during office hours which is between 09:00 AM to 5:00 pm");
        }

        else*/ if(count.intValue()>=7) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Application for "+serviceName+" reached maximum limit set by the system, please try again next day");
        }

        /*else if(!holiday.equals(6) ||!(holiday.equals(7))){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Applications for judiciary System are accepted only during working days, i.e from Monday to Friday. Please try again during office hours");
        }*/
        else {
            responseMessage = attestAgreementWillsContractService.saveAttestAgreementWillsContract(request, applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
        }
        return responseMessage;
    }
}
