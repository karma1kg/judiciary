package com.spring.mvc;

import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    @Autowired
    private CommonService commonService;
    /*for local use um-comment it*/

    /**
     * for first page load
     * @param model
     * @return index page
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String printWelcome1(ModelMap model) {
        String Service_Id = "501";
        model.addAttribute("RequiredDocsListMC", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "502";
        model.addAttribute("RequiredDocsListAP", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "503";
        model.addAttribute("RequiredDocsListAM", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "504";
        model.addAttribute("RequiredDocsListLD", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "505";
        model.addAttribute("RequiredDocsListSM", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "506";
        model.addAttribute("RequiredDocsListCT", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "507";
        model.addAttribute("RequiredDocsListAD", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "508";
        model.addAttribute("RequiredDocsListCA", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "509";
        model.addAttribute("RequiredDocsListKT", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "510";
        model.addAttribute("RequiredDocsListSA", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "511";
        model.addAttribute("RequiredDocsListAA", commonService.getRequiredDocumentList(Service_Id));
       Service_Id="512";
        model.addAttribute("RequiredDocListNMC", commonService.getRequiredDocumentList(Service_Id));
        Service_Id="513";
        model.addAttribute("RequiredDocListDA", commonService.getRequiredDocumentList(Service_Id));
        return "index";
    }

/*
    @RequestMapping( method = RequestMethod.GET)
    public String printIndex(ModelMap model) {
        return "index";
    }
*/

    /*for production use*/
   @RequestMapping(value = "public/index", method = {RequestMethod.GET, RequestMethod.HEAD})
      public String printWelcome(ModelMap model) {
        String Service_Id = "501";
        model.addAttribute("RequiredDocsListMC", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "502";
        model.addAttribute("RequiredDocsListAP", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "503";
        model.addAttribute("RequiredDocsListAM", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "504";
        model.addAttribute("RequiredDocsListLD", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "505";
        model.addAttribute("RequiredDocsListSM", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "506";
        model.addAttribute("RequiredDocsListCT", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "507";
        model.addAttribute("RequiredDocsListAD", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "508";
        model.addAttribute("RequiredDocsListCA", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "509";
        model.addAttribute("RequiredDocsListKT", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "510";
        model.addAttribute("RequiredDocsListSA", commonService.getRequiredDocumentList(Service_Id));
        Service_Id = "511";
        model.addAttribute("RequiredDocsListAA", commonService.getRequiredDocumentList(Service_Id));
        return "index";
    }

}
