package com.spring.mvc.judiciary.controller.commonController;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dto.PaymentDetailDTO;
import com.spring.mvc.judiciary.service.commonService.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sonam Tobgay on 9/8/2019.
 */

/**
 * for update of payment
 */
@Controller
@RequestMapping(value = "/paymentDetail")
public class PaymentController {

    @Autowired
    private PaymentDetailService paymentDetailService;
    ResponseMessage responseMessage;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(ModelMap model,@RequestParam("serviceId") String serviceId) {
        return "common/paymentDetail";
    }

    /**
     * request payment requirements
     * @param request courdId
     * @param serviceId
     * @return payment lists
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getPaymentList", method = RequestMethod.GET)
    public ResponseMessage getPaymentList(HttpServletRequest request, String serviceId)throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        String courtId = userBean.getJurisdictions()[0].getLocationID();
        //String serviceId = request.getParameter("serviceId");
        responseMessage = paymentDetailService.getPaymentList(courtId,serviceId);
        return responseMessage;
    }

    /**
     * update of payment
     * @param request
     * @param response
     * @param paymentDetailDTO
     * @return response message of updated payment
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updatePaymentDetail", method = RequestMethod.POST)
    public ResponseMessage updatePaymentDetail(HttpServletRequest request, HttpServletResponse response,
                                               PaymentDetailDTO paymentDetailDTO) throws Exception {
        UserRolePrivilegeDto userBean = (UserRolePrivilegeDto) request.getSession().getAttribute("UserRolePrivilege");
        responseMessage = paymentDetailService.updatePaymentDetail(userBean, paymentDetailDTO);
        return responseMessage;
    }
}
