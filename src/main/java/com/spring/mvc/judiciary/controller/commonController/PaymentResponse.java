package com.spring.mvc.judiciary.controller.commonController;

import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Deepak on 2/3/2021.
 */

/**
 * for online payment
 */
@Controller
@RequestMapping("/PaymentResponse")
public class PaymentResponse{
    @Autowired
    CommonService commonService;

    @RequestMapping(method = RequestMethod.POST)
    protected void PaymentResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationDetailDTO applicationDetailDTO=new ApplicationDetailDTO();
        try {
            applicationDetailDTO.setApplicationNo(request.getParameter("applicationNo"));
            applicationDetailDTO.setReceiptDateOnline(request.getParameter("paymentDate"));
            applicationDetailDTO.setReceiptNo(request.getParameter("txnId"));
            applicationDetailDTO.setReceiptAmount((int)Float.parseFloat(request.getParameter("txnAmount")));
            commonService.updatePaymentOnline(applicationDetailDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
