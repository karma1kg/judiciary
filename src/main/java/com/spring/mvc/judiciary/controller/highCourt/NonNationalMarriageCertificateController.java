package com.spring.mvc.judiciary.controller.highCourt;

import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sonam Tobgay on 4/1/2020.
 */
@Controller
@RequestMapping("/nonNationalMarriageCertificate")
public class NonNationalMarriageCertificateController {

    @Autowired
    private CommonService commonService;
    private ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model) {
        String Service_Id = "512";
        model.addAttribute("religion_list", commonService.getAllReligion());
        model.addAttribute("court_list", commonService.getAllCourt());
        model.addAttribute("country_list", commonService.getAllCountry());
        model.addAttribute("RequiredDocsList", commonService.getRequiredDocumentList(Service_Id));
        return "highCourt/nonNationalMarriageCertificate";
    }
}
