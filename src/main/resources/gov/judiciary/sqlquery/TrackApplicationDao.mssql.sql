TrackApplicationDao.getTrackApplicationDetail = SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailMC = SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailAP= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailAM= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailSM= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1
TrackApplicationDao.getTrackApplicationDetailLD= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

 TrackApplicationDao.getTrackApplicationDetailCD= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailAD= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1
TrackApplicationDao.getTrackApplicationDetailCA= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1

TrackApplicationDao.getTrackApplicationDetailKT= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1
 TrackApplicationDao.getTrackApplicationDetailCT= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1
TrackApplicationDao.getTrackApplicationDetailAA= SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate, \
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                LEFT JOIN t_spouse_dtls d ON a.APPLICATION_NO = d.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo AND a.SERVICE_SL_NO=:serviceId \
                                                ORDER BY a.CREATED_DATE LIMIT 1


                                             /*  SELECT \
                                                m.SERVICE_NAME AS serviceName , \
                                                s.STATUS_NAME AS statusName, \
                                                a.CREATED_DATE AS createdDate,\
                                                c.COURT_NAME AS courtName, \
                                                DATE_FORMAT(IF(a.DATE_OF_APPOINTMENT IS NULL, '-', a.DATE_OF_APPOINTMENT),'%d %M, %Y') AS hospitalName, \
                                                IF(a.TIME_OF_APPOINTMENT IS NULL, '-',a.TIME_OF_APPOINTMENT) AS appoinmentTime \
                                                FROM t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                LEFT JOIN t_status_lookup s ON a.STATUS_ID = s.STATUS_ID \
                                                LEFT JOIN t_service_master m ON a.SERVICE_SL_NO = m.SERVICE_ID \
                                                LEFT JOIN t_court_master c ON a.COURT_ID = c.COURT_ID \
                                                WHERE a.APPLICATION_NO = b.APPLICATION_NO AND \
                                                a.APPLICATION_NO =:applicationNo OR b.CID =:cidNo LIMIT 1 \*/
