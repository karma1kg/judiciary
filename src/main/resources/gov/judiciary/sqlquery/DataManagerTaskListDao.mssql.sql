DataManagerTaskListDao.getDataManagerTaskList =SELECT \
                                              A.SERVICE_SL_NO AS serviceSlNo \
                                              ,A.APPLICATION_NO AS applicationNo \
                                              ,S.SERVICE_NAME AS serviceName \
                                              ,P.CID AS cidNo \
                                              ,P.NAME AS applicantName \
                                              ,P.MOBILE_NO AS mobileNo \
                                              ,A.STATUS_ID AS statusId \
                                              ,A.CREATED_DATE AS createdDate \
                                              ,D.PAYMENT_TYPE AS statusName  \
                                              FROM t_application_details A \
                                              LEFT JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                              LEFT JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                              LEFT JOIN t_app_payment_details D ON A.APPLICATION_NO = D.APPLICATION_NO \
                                              WHERE A.STATUS_ID ='6' AND a.COURT_ID =:courtId AND (CASE WHEN :serviceId='ALL' THEN 1=1 ELSE A.SERVICE_SL_NO=:serviceId END)

DataManagerTaskListDao.getUpdateClaimedTaskList = SELECT DISTINCT \
                                        A.APPLICATION_NO AS applicationNo \
                                        ,A.SERVICE_SL_NO AS serviceSlNo \
                                        ,S.SERVICE_NAME AS serviceName \
                                        ,P.CID AS cidNo \
                                        ,P.NAME AS applicantName \
                                        ,P.MOBILE_NO AS mobileNo \
                                        ,A.STATUS_ID AS statusId \
                                        ,A.CREATED_DATE AS createdDate \
                                        ,D.PAYMENT_TYPE AS statusName  \
                                        FROM t_application_details A \
                                        INNER JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                        INNER JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                        INNER JOIN t_task_dtls T ON T.Application_Id = A.APPLICATION_NO \
                                         LEFT JOIN t_app_payment_details D ON A.APPLICATION_NO = D.APPLICATION_NO \
                                        WHERE A.STATUS_ID = '7' AND T.Owner =:owner AND (CASE WHEN :serviceId='ALL' THEN 1=1 ELSE A.SERVICE_SL_NO=:serviceId END)
