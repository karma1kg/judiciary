/*
package com.spring.mvc.judiciary.controller.commonController;

import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.TrackApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

*/
/**
 * Created by USER on 8/22/2019.
 *//*


*/
/**
 * to track application by users.
 *//*

@Controller
@RequestMapping("/trackApplication")
public class TrackApplicationLoginController {
    @Autowired
    private TrackApplicationService trackApplicationService;

    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        return "common/trackApplication";
    }

    @RequestMapping(value = "trackApplicationMC", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexes(ModelMap model)
    {
        return "common/trackApplicationStatus";
    }
    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailMC", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailMC(String applicationNo) {
        String serviceId="501";
        responseMessage = trackApplicationService.getTrackApplicationDetailMC(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAP", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAP(ModelMap model) {
        return "common/trackApplicationStatusAP";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAP", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAP(String applicationNo) {
        String serviceId="502";
        responseMessage = trackApplicationService.getTrackApplicationDetailAP(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAM", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAM(Model model){
        return "common/trackApplicationStatusAM";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAM", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAM(String applicationNo) {
        String serviceId="503";
        responseMessage = trackApplicationService.getTrackApplicationDetailAM(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationLD", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexLD(Model model){
        return "common/trackApplicationLD";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailLD", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailLD(String applicationNo) {
        String serviceId="504";
        responseMessage = trackApplicationService.getTrackApplicationDetailLD(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationSM", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexSM(Model model){
        return "common/trackApplicationSM";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailSM", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailSM(String applicationNo) {
        String serviceId="505";
        responseMessage = trackApplicationService.getTrackApplicationDetailSM(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationCD", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexCD(Model model){
        return "common/trackApplicationCD";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCD", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCD(String applicationNo) {
        String serviceId="506";
        responseMessage = trackApplicationService.getTrackApplicationDetailCD(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAD", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAD(Model model){
        return "common/trackApplicationAD";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAD", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAD(String applicationNo) {
        String serviceId="507";
        responseMessage = trackApplicationService.getTrackApplicationDetailAD(applicationNo, serviceId);
        return responseMessage;
    }
    @RequestMapping(value = "trackApplicationCA", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexCA(Model model){
        return "common/trackApplicationCA";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCA", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCA(String applicationNo) {
        String serviceId="508";
        responseMessage = trackApplicationService.getTrackApplicationDetailCA(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationKT", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexKT(Model model){
        return "common/trackApplicationKT";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailKT", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailKT(String applicationNo) {
        String serviceId="509";
        responseMessage = trackApplicationService.getTrackApplicationDetailKT(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationCT", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexCT(Model model){
        return "common/trackApplicationCT";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCT", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCT(String applicationNo) {
        String serviceId="510";
        responseMessage = trackApplicationService.getTrackApplicationDetailCT(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAA", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAA(Model model){
        return "common/trackApplicationAA";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAA", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAA(String applicationNo) {
        String serviceId="511";
        responseMessage = trackApplicationService.getTrackApplicationDetailAA(applicationNo, serviceId);
        return responseMessage;
    }
 */
/*   @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCD", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCD(String applicationNo) {
        String serviceId="506";
        responseMessage = trackApplicationService.getTrackApplicationDetailCD(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAD", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAD(Model model){
        return "common/trackApplicationAD";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAD", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAD(String applicationNo) {
        String serviceId="507";
        responseMessage = trackApplicationService.getTrackApplicationDetailAD(applicationNo, serviceId);
        return responseMessage;
    }
    @RequestMapping(value = "trackApplicationCA", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexCA(Model model){
        return "common/trackApplicationCA";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCA", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCA(String applicationNo) {
        String serviceId="508";
        responseMessage = trackApplicationService.getTrackApplicationDetailCA(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationKT", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexKT(Model model){
        return "common/trackApplicationKT";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailKT", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailKT(String applicationNo) {
        String serviceId="509";
        responseMessage = trackApplicationService.getTrackApplicationDetailKT(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationCT", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexCT(Model model){
        return "common/trackApplicationCT";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailCT", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailCT(String applicationNo) {
        String serviceId="510";
        responseMessage = trackApplicationService.getTrackApplicationDetailCT(applicationNo, serviceId);
        return responseMessage;
    }

    @RequestMapping(value = "trackApplicationAA", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String indexAA(Model model){
        return "common/trackApplicationAA";
    }

    @ResponseBody
    @RequestMapping(value = "/getTrackApplicationDetailAA", method = RequestMethod.GET)
    public ResponseMessage getTrackApplicationDetailAA(String applicationNo) {
        String serviceId="511";
        responseMessage = trackApplicationService.getTrackApplicationDetailAA(applicationNo, serviceId);
        return responseMessage;
    }
*//*

}
*/
