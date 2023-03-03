package com.spring.mvc.judiciary.controller.commonController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by kg on 27/07/2022.
 */

/**
 * for sso logout
 */
@Controller
@RequestMapping("/sso")
public class SsoController {
    /**
     * sso logout url
     * @param request
     * @param session
     * @return invalidate session and returns sso login page
     */
    @RequestMapping(value = "/oidclogout", method = RequestMethod.GET)
    public String oidcLogout(HttpServletRequest request, HttpSession session){
        session.invalidate();
        String redirectUrl = request.getScheme() + "://www.citizenservices.gov.bt/";
        return "redirect:" + redirectUrl;
    }
}
