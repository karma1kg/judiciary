ReportsDao.getStatusList = SELECT S.Status_Id AS valueInteger, S.Status_Name AS text FROM t_status_lookup S

ReportsDao.getCertificateReport = SELECT \
                                  a.NAME AS applicantName, \
                                  s.NAME AS spouseName, \
                                  a.CID AS cidNo, \
                                  s.CID AS spouseCidNo, \
                                  a.APPLICATION_NO AS applicationNo, \
                                  b.JUDGEMENT_DATE AS judgementDate, \
                                  b.JUDGEMENT_NO AS judgementNo, \
                                  b.LAWYER AS lawyer, \
                                  c.COURT_NAME AS courtName, \
                                  IF( b.STATUS_ID = '1','Submitted', \
                                    IF(b.STATUS_ID = '2','Claimed', \
                                      IF(b.STATUS_ID = '3','Verified', \
                                        IF(b.STATUS_ID = '4','Rejected', \
                                          IF(b.STATUS_ID = '5','Update and Printing', \
                                            IF(b.STATUS_ID = '6','Payment Cleared', \
                                              IF( b.STATUS_ID = '7','Update Claimed','Printed Application' \
                                  ))))))) AS statusName \
                                FROM \
                                  t_applicant_dtls a \
                                  LEFT JOIN t_spouse_dtls s \
                                    ON s.APPLICATION_NO = a.APPLICATION_NO \
                                  LEFT JOIN t_application_details b \
                                    ON b.APPLICATION_NO = a.APPLICATION_NO \
                                  LEFT JOIN t_court_master c \
                                    ON c.COURT_ID = b.COURT_ID \
                                WHERE b.COURT_ID = :courtId \
                                  AND b.SERVICE_SL_NO = :serviceId \
                                  AND (b.CREATED_DATE BETWEEN :fromDate AND :toDate) \
                                  AND IF('All' = :statusId,1 = 1, b.STATUS_ID = :statusId)

ReportsDao.getReportByCourt = SELECT \
                              c.COURT_NAME AS courtName, \
                              COUNT(b.APPLICATION_NO) AS totals \
                            FROM \
                              t_applicant_dtls a \
                              LEFT JOIN t_application_details b \
                                ON b.APPLICATION_NO = a.APPLICATION_NO \
                              LEFT JOIN t_court_master c \
                                ON c.COURT_ID = b.COURT_ID \
                              LEFT JOIN t_service_master d \
                                ON d.SERVICE_ID = b.SERVICE_SL_NO \
                            WHERE b.COURT_ID = :courtId \
                              AND (b.CREATED_DATE BETWEEN :fromDate AND :toDate) \
                              AND IF('ALL' = :serviceId, b.SERVICE_SL_NO <> '0',b.SERVICE_SL_NO = :serviceId) \
                            GROUP BY c.COURT_NAME

ReportsDao.getReportByService = SELECT \
                                d.SERVICE_NAME AS serviceName, \
                                COUNT(*) AS totals \
                              FROM \
                                t_applicant_dtls a \
                                LEFT JOIN t_application_details b \
                                  ON b.APPLICATION_NO = a.APPLICATION_NO \
                                LEFT JOIN t_court_master c \
                                  ON c.COURT_ID = b.COURT_ID \
                                LEFT JOIN t_service_master d \
                                  ON d.SERVICE_ID = b.SERVICE_SL_NO \
                              WHERE b.SERVICE_SL_NO = :serviceId \
                                AND (b.CREATED_DATE BETWEEN :fromDate \
                                  AND :toDate) \
                              GROUP BY d.SERVICE_NAME
