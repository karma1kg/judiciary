NotaryTaskListDao.getNotaryTaskList = SELECT \
                                    A.SERVICE_SL_NO AS serviceSlNo \
                                    ,A.APPLICATION_NO AS applicationNo \
                                    ,S.SERVICE_NAME AS serviceName \
                                    ,P.CID AS cidNo \
                                    ,P.NAME AS applicantName \
                                    ,P.MOBILE_NO AS mobileNo \
                                    ,A.STATUS_ID AS statusId \
                                    ,A.CREATED_DATE AS createdDate \
                                    FROM t_application_details A \
                                    LEFT JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                    LEFT JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                    WHERE A.STATUS_ID =1 AND A.COURT_ID =:courtId AND (CASE WHEN :serviceId='ALL' THEN 1=1 ELSE A.SERVICE_SL_NO=:serviceId END)
/*SELECT \
                                    A.SERVICE_SL_NO AS serviceSlNo \
                                    ,A.APPLICATION_NO AS applicationNo \
                                    ,S.SERVICE_NAME AS serviceName \
                                    ,P.CID AS cidNo \
                                    ,P.NAME AS applicantName \
                                    ,P.MOBILE_NO AS mobileNo \
                                    ,A.STATUS_ID AS statusId \
                                    ,A.CREATED_DATE AS createdDate \
                                    FROM t_application_details A \
                                    LEFT JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                    LEFT JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                    WHERE A.STATUS_ID =1 AND A.COURT_ID =:courtId*/


NotaryTaskListDao.getClaimedTaskList = SELECT DISTINCT \
                                        A.APPLICATION_NO AS applicationNo \
                                        ,A.SERVICE_SL_NO AS serviceSlNo \
                                        ,S.SERVICE_NAME AS serviceName \
                                        ,P.CID AS cidNo \
                                        ,P.NAME AS applicantName \
                                        ,P.MOBILE_NO AS mobileNo \
                                        ,A.STATUS_ID AS statusId \
                                        ,A.CREATED_DATE AS createdDate \
                                        FROM t_application_details A \
                                        INNER JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                        INNER JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                        INNER JOIN t_task_dtls T ON T.Application_Id = A.APPLICATION_NO \
                                        WHERE A.STATUS_ID = 2 AND T.Owner =:owner AND (CASE WHEN :serviceId='ALL' THEN 1=1 ELSE A.SERVICE_SL_NO=:serviceId END)

NotaryTaskListDao.getNotaryTaskListByServiceId =SELECT \
                                               A.SERVICE_SL_NO AS serviceSlNo \
                                              ,A.APPLICATION_NO AS applicationNo \
                                              ,S.SERVICE_NAME AS serviceName \
                                              ,P.CID AS cidNo \
                                              ,P.MOBILE_NO AS mobileNo \
                                              ,A.STATUS_ID AS statusId \
                                              ,A.CREATED_DATE AS createdDate \
                                              FROM t_application_details A \
                                              LEFT JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                              LEFT JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                              WHERE A.STATUS_ID =1 AND a.COURT_ID =:courtId AND A.SERVICE_SL_NO = :SERVICE_ID


NotaryTaskListDao.getClaimedTaskListByServiceId = SELECT DISTINCT \
                                                 A.APPLICATION_NO AS applicationNo \
                                                ,A.SERVICE_SL_NO AS serviceSlNo \
                                                ,S.SERVICE_NAME AS serviceName \
                                                ,P.CID AS cidNo \
                                                ,P.MOBILE_NO AS mobileNo \
                                                ,A.STATUS_ID AS statusId \
                                                ,A.CREATED_DATE AS createdDate \
                                                FROM t_application_details A \
                                                INNER JOIN t_applicant_dtls P ON A.APPLICATION_NO = P.APPLICATION_NO \
                                                INNER JOIN t_service_master S ON A.SERVICE_SL_NO = S.SERVICE_ID \
                                                INNER JOIN t_task_dtls T ON T.Application_Id = A.APPLICATION_NO \
                                                WHERE A.STATUS_ID = 2 AND T.Owner =:owner AND a.SERVICE_SL_NO = :serviceId
