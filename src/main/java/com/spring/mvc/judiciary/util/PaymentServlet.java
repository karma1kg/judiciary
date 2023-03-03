package com.spring.mvc.judiciary.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sonam Tobgay on 3/29/2021.
 */
public class PaymentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicationNo = request.getParameter("applicationNo");
        String paymentDate = request.getParameter("paymentDate");
        String txnId = request.getParameter("txnId");
        String txnAmount = request.getParameter("txnAmount");
        try {
            request.getRequestDispatcher("/PaymentResponse?application="+applicationNo+"&paymentDate="+paymentDate+"&txnId="+txnId+"&txnAmount="+txnAmount).forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
