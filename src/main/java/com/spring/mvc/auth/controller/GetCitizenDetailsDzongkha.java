package com.spring.mvc.auth.controller;


import com.spring.mvc.judiciary.dto.CitizenDetailDTO;
import com.spring.mvc.judiciary.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

/**
 * get citizen details in dzongkha
 */
@Controller
@RequestMapping(value = "/getCitizenDetailsDzongkha")
public class GetCitizenDetailsDzongkha {
    @Autowired
    private APIService api;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public CitizenDetailDTO citizenRedirect(HttpServletRequest servletRequest) throws ServletException, IOException, ParseException {
        /*ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String dataHubEndPointUrl = resourceBundle1.getString("getCitizenDetailsDzongkha.endPointURL");
        String cidNo = servletRequest.getParameter("applicantCid");

        Token token = api.getApplicationToken();
        CitizenDetailDTO citizenDetailDTO = new CitizenDetailDTO();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token.getAccess_token());
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<CitizenDetailDTO> response = restTemplate.exchange(dataHubEndPointUrl+cidNo, HttpMethod.GET, request, CitizenDetailDTO.class);
        citizenDetailDTO.setApplicantName(response.getBody().getApplicantName());
        citizenDetailDTO.setApplicantDob(response.getBody().getApplicantDob());
        citizenDetailDTO.setGender(response.getBody().getGender());
        citizenDetailDTO.setCidNo(response.getBody().getCidNo());
        citizenDetailDTO.setHouseNo(response.getBody().getHouseNo());
        citizenDetailDTO.setTharmNo(response.getBody().getTharmNo());
        citizenDetailDTO.setFatherName(response.getBody().getFatherName());
        citizenDetailDTO.setMotherName(response.getBody().getMotherName());
        return citizenDetailDTO;*/
        return  null;
    }
}




