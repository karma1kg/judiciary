package com.spring.mvc.judiciary.dao;

import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.PaymentDetailDTO;
import com.spring.mvc.judiciary.entity.PaymentDetail;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by USER on 9/8/2019.
 */
@Repository
public class PaymentDetailDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<ApplicationDetailDTO> getPaymentList(String courtId, String serviceId) {
        String sqlQuery = properties.getProperty("PaymentDetailDao.getPaymentList");
        Query hQuery = hibernateQuery(sqlQuery, ApplicationDetailDTO.class);
        hQuery.setParameter("courtId", courtId)
             .setParameter("serviceId", serviceId);
        return hQuery.list().isEmpty() ? null : hQuery.list();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePaymentDetail(PaymentDetailDTO paymentDetailDTO) {
        String txnId = paymentDetailDTO.getReceiptNo();
        String applicationNo = paymentDetailDTO.getApplicationNo();
        String paymentType = paymentDetailDTO.getPaymentType();
        String paymentDate = formatDate(paymentDetailDTO.getDepositDate());
        Integer txnAmount = paymentDetailDTO.getReceiptAmount();
        String isPayment = "Y";
        Integer status = 6;
        String sqlQuery = properties.getProperty("PaymentDetailDao.updatePaymentDetailOffline");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("txnId", txnId)
                .setParameter("paymentDate", paymentDate)
                .setParameter("txnAmount", txnAmount)
                .setParameter("paymentType", paymentType)
                .setParameter("isPayment", isPayment)
                .setParameter("status", status)
                .setParameter("applicationNo", applicationNo);
        hQuery.executeUpdate();
    }

    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void savePaymentDetail(PaymentDetail paymentDetail) {
        try {
            getReportingSession().saveOrUpdate(paymentDetail);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String formatDate(Date paymentDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(paymentDate);
        return date;
    }
}
