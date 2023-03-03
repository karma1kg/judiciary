package com.spring.mvc.judiciary.service.commonService;

import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.PaymentDetailDao;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.PaymentDetailDTO;
import com.spring.mvc.judiciary.entity.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by USER on 9/8/2019.
 */
@Service
public class PaymentDetailService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private PaymentDetailDao paymentDetailDao;

    public ResponseMessage getPaymentList(String courtId, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> documentList = paymentDetailDao.getPaymentList(courtId, serviceId);
        if (documentList != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(documentList);
        }
        return responseMessage;
    }

    public ResponseMessage updatePaymentDetail(UserRolePrivilegeDto userBean, PaymentDetailDTO paymentDetailDTO) {
        ResponseMessage responseMessage;
        responseMessage = commonService.updatePaymentDetail(userBean, paymentDetailDTO);
        if (responseMessage.getResponseStatus() == SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()) {
           // paymentDetailDao.updatePaymentDetail(paymentDetailDTO);
            PaymentDetail paymentDetail = convertPaymentDTOtoEntity(paymentDetailDTO);
            paymentDetailDao.savePaymentDetail(paymentDetail);
            responseMessage.setResponseText("Updated Successfully.");
        }
        return responseMessage;
    }

    private PaymentDetail convertPaymentDTOtoEntity(PaymentDetailDTO paymentDetailDTO) {
        String serviceId = paymentDetailDTO.getApplicationNo().substring(0,3);
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setApplicationNo(paymentDetailDTO.getApplicationNo());
        paymentDetail.setAmountCharge(paymentDetailDTO.getReceiptAmount());
        paymentDetail.setBankId(paymentDetailDTO.getBankId());
        paymentDetail.setDepositDate(paymentDetailDTO.getDepositDate());
        paymentDetail.setIsPaid(paymentDetailDTO.getIsPaid());
        paymentDetail.setPaymentType(paymentDetailDTO.getPaymentType());
        paymentDetail.setReceiptNo(paymentDetailDTO.getReceiptNo());
        paymentDetail.setServiceNo(paymentDetailDTO.getServiceNo());
        paymentDetail.setVoucherNo(paymentDetailDTO.getReceiptNo());
        paymentDetail.setIsPaid("Y");
        paymentDetail.setServiceNo(Integer.valueOf(serviceId));
        return paymentDetail;
    }
}
