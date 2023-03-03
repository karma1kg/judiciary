PaymentDetailDao.getPaymentList =  SELECT \
                                  S.SERVICE_FEE AS receiptAmount, \
                                  A.APPLICATION_NO AS applicationNo, \
                                  A.SERVICE_SL_NO AS serviceSlNo, \
                                  S.SERVICE_NAME AS serviceName, \
                                  B.NAME AS applicantName, \
                                  B.CID AS cidNo, \
                                  H.COURT_NAME AS courtName, \
                                  A.STATUS_ID AS statusId \
                                FROM \
                                  t_application_details A \
                                  LEFT JOIN t_applicant_dtls B \
                                    ON A.APPLICATION_NO = B.APPLICATION_NO \
                                  LEFT JOIN t_service_master S \
                                    ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                  LEFT JOIN t_court_master H \
                                    ON A.COURT_ID = H.COURT_ID \
                                WHERE A.COURT_ID = :courtId \
                                AND A.SERVICE_SL_NO = :serviceId \
                                AND A.STATUS_ID = '3' \
                                AND A.PAYMENT_CLEARED = 'N'

PaymentDetailDao.updatePaymentDetailOffline  = UPDATE \
                                              t_application_details \
                                            SET  \
                                              RECEIPT_NO = :txnId , \
                                              RECEIPT_DATE = :paymentDate, \
                                              RECEIPT_AMOUNT = :txnAmount, \
                                              PRINT_STATUS = :paymentType, \
                                              PAYMENT_CLEARED = :isPayment, \
                                              STATUS_ID = :status \
                                            WHERE APPLICATION_NO =:applicationNo