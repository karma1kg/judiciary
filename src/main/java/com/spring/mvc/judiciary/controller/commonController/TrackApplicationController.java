package com.spring.mvc.judiciary.controller.commonController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import com.spring.mvc.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.mvc.judiciary.service.commonService.TrackApplicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * for tracking current status of application
 */
@Controller
@RequestMapping({ "/trackApplication" })
public class TrackApplicationController
{
    @Autowired
    private TrackApplicationService trackApplicationService;
    ResponseMessage responseMessage;

    @RequestMapping(method = { RequestMethod.GET, RequestMethod.HEAD })
    public String index(final ModelMap model) {
        return "common/trackApplication";
    }

    /**
     * for tracking of mc status
     * @param model
     * @return mc status page
     */
    @RequestMapping(value = { "trackApplicationMC" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexes(final ModelMap model) {
        return "common/trackApplicationStatus";
    }

    /**
     * to fetch mc status
     * @param applicationNo
     * @return mc status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailMC" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailMC(final String applicationNo) {
        final String serviceId = "501";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailMC(applicationNo, serviceId);
    }

    /**
     * to track Authentication of personal details
     * @param model
     * @return AP (authentication of personal details) view status page
     */
    @RequestMapping(value = { "trackApplicationAP" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexAP(final ModelMap model) {
        return "common/trackApplicationStatusAP";
    }
    /**
     * to fetch AP status
     * @param applicationNo
     * @return AP status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailAP" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailAP(final String applicationNo) {
        final String serviceId = "502";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailAP(applicationNo, serviceId);
    }
    /**
     * to track Affirmation of MC
     * @param model
     * @return AM (Affirmation of MC) view status page
     */
    @RequestMapping(value = { "trackApplicationAM" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexAM(final Model model) {
        return "common/trackApplicationStatusAM";
    }
    /**
     * to fetch mc status
     * @param applicationNo
     * @return mc status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailAM" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailAM(final String applicationNo) {
        final String serviceId = "503";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailAM(applicationNo, serviceId);
    }
/* request and return lost document status*/
    @RequestMapping(value = { "trackApplicationLD" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexLD(final Model model) {
        return "common/trackApplicationLD";
    }
    /**
     * to fetch lost document status
     * @param applicationNo
     * @return lost document status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailLD" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailLD(final String applicationNo) {
        final String serviceId = "504";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailLD(applicationNo, serviceId);
    }
/* request and return single and marital status*/
    @RequestMapping(value = { "trackApplicationSM" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexSM(final Model model) {
        return "common/trackApplicationSM";
    }
    /**
     * to fetch Single or marital status
     * @param applicationNo
     * @return Single or marital status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailSM" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailSM(final String applicationNo) {
        final String serviceId = "505";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailSM(applicationNo, serviceId);
    }
/* request and return child travel document status*/
    @RequestMapping(value = { "trackApplicationCD" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexCD(final Model model) {
        return "common/trackApplicationCD";
    }
    /**
     * to fetch Child travel status
     * @param applicationNo
     * @return child travel status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailCD" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailCD(final String applicationNo) {
        final String serviceId = "506";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailCD(applicationNo, serviceId);
    }
/* request and return attestation of documents*/
    @RequestMapping(value = { "trackApplicationAD" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexAD(final Model model) {
        return "common/trackApplicationAD";
    }

    /**
     * to fetch attestation of documents status
     * @param applicationNo
     * @return attestation of documents status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailAD" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailAD(final String applicationNo) {
        final String serviceId = "507";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailAD(applicationNo, serviceId);
    }
   /* request and return child adoption view status */
    @RequestMapping(value = { "trackApplicationCA" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexCA(final Model model) {
        return "common/trackApplicationCA";
    }
    /**
     * to fetch child adoption status
     * @param applicationNo
     * @return child adoption status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailCA" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailCA(final String applicationNo) {
        final String serviceId = "508";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailCA(applicationNo, serviceId);
    }
/*request and return kidney transplant view status*/
    @RequestMapping(value = { "trackApplicationKT" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexKT(final Model model) {
        return "common/trackApplicationKT";
    }
    /**
     * to fetch kideney transplant status
     * @param applicationNo
     * @return kidney transplant status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailKT" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailKT(final String applicationNo) {
        final String serviceId = "509";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailKT(applicationNo, serviceId);
    }
/* request and return closing and transfer of shares*/
    @RequestMapping(value = { "trackApplicationCT" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexCT(final Model model) {
        return "common/trackApplicationCT";
    }
    /**
     * to fetch closing and transfer of shares status
     * @param applicationNo
     * @return closing and transfer of shares status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailCT" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailCT(final String applicationNo) {
        final String serviceId = "510";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailCT(applicationNo, serviceId);
    }
/*returns and request Attest Agreements,Wills, contracts and Testaments view status page */
    @RequestMapping(value = { "trackApplicationAA" }, method = { RequestMethod.GET, RequestMethod.HEAD })
    public String indexAA(final Model model) {
        return "common/trackApplicationAA";
    }
    /**
     * to fetch Attest Agreements,Wills, contracts and Testaments status
     * @param applicationNo
     * @return Attest Agreements,Wills, contracts and Testaments status
     */
    @ResponseBody
    @RequestMapping(value = { "/getTrackApplicationDetailAA" }, method = { RequestMethod.GET })
    public ResponseMessage getTrackApplicationDetailAA(final String applicationNo) {
        final String serviceId = "511";
        return this.responseMessage = this.trackApplicationService.getTrackApplicationDetailAA(applicationNo, serviceId);
    }
}