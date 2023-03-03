PrintCertificateDao.getCertificateList = SELECT \
                                        a.APPLICATION_NO AS applicationNo, \
                                        c.NAME AS fullName, \
                                        c.CID AS cidNo, \
                                        c.MOBILE_NO AS mobileNo, \
                                        d.COURT_NAME AS courtName \
                                        FROM t_application_details a \
                                        LEFT JOIN t_status_lookup b ON b.Status_Id = a.STATUS_ID  \
                                        LEFT JOIN t_applicant_dtls c ON c.APPLICATION_NO = a.APPLICATION_NO  \
                                        LEFT JOIN t_court_master d ON a.COURT_ID = d.COURT_ID  \
                                        LEFT JOIN t_task_dtls e ON e.Application_Id = a.APPLICATION_NO \
                                        WHERE a.SERVICE_SL_NO =:serviceId AND a.STATUS_ID = '5' \
                                        AND a.PRINT_STATUS = 'N' AND a.COURT_ID =:courtId \
                                        GROUP BY a.APPLICATION_NO

PrintCertificateDao.getCertificateListMC = SELECT \
                                        a.APPLICATION_NO AS applicationNo, \
                                        c.NAME AS fullName, \
                                        c.CID AS cidNo, \
                                        c.MOBILE_NO AS mobileNo, \
                                        d.COURT_NAME AS courtName \
                                        FROM t_application_details a \
                                        LEFT JOIN t_status_lookup b ON b.Status_Id = a.STATUS_ID  \
                                        LEFT JOIN t_applicant_dtls c ON c.APPLICATION_NO = a.APPLICATION_NO  \
                                        LEFT JOIN t_court_master d ON a.COURT_ID = d.COURT_ID  \
                                        LEFT JOIN t_task_dtls e ON e.Application_Id = a.APPLICATION_NO \
                                        WHERE a.SERVICE_SL_NO =:serviceId AND a.STATUS_ID = '5' \
                                        AND a.PRINT_STATUS = 'N' AND a.PAYMENT_CLEARED = 'Y' AND a.COURT_ID =:courtId \
                                        GROUP BY a.APPLICATION_NO

PrintCertificateDao.getPrintApplicationDetailMC = SELECT \
                                                a.APPLICATION_NO AS applicationNo, \
                                                a.SERVICE_SL_NO AS serviceSlNo, \
                                                a.MC_NO AS mcNo, \
                                                a.REASON AS reason, \
                                                a.CASE_NO AS caseNo, \
                                                a.JUDGEMENT_NO AS judgementNo, \
                                                a.JUDGEMENT_DATE AS judgementDate, \
                                                a.LAWYER AS lawyer, \
                                                b.NAME AS fullName, \
                                                b.CID AS cidNo \
                                                FROM \
                                                t_application_details a \
                                                LEFT JOIN t_applicant_dtls b ON a.APPLICATION_NO = b.APPLICATION_NO \
                                                WHERE a.APPLICATION_NO = :applicationNo

PrintCertificateDao.getHusbandDetail = SELECT \
                                      APPLICATION_NO AS applicationNo, \
                                      H_CID AS cidNo, \
                                      H_NAME AS applicantName, \
                                      H_DOB AS applicantDobBh, \
                                      H_GENDER AS gender, \
                                      H_FATHERS_NAME AS fatherName, \
                                      H_MOTHERS_NAME AS motherName, \
                                      H_THARM_NO AS tharmNo, \
                                      H_HOUSE_NO AS houseNo, \
                                      H_DZONGKHAG_NAME AS dzongkhagNameBh, \
                                      H_GEWOG_NAME AS gewogNameBh, \
                                      H_VILLAGE_NAME AS villageNameBh, \
                                      H_NATIONALITY AS nationality, \
                                      H_ADDRESS AS address, \
                                      CENSUS_NO AS censusFormNo, \
                                      APPLICATION_NO_DZO AS applicationIdDzo, \
                                      JUDGEMENT_NO_DZO AS judgementNoDzo, \
                                      JUDGEMENT_DATE_DZO AS dateDzo, \
                                      LUNAR_DATE AS lunarDateDzo, \
                                      LAWYER AS lawyerDzo \
                                      FROM t_mc_husbands_details WHERE APPLICATION_NO = :applicationNo

PrintCertificateDao.getWifeDetail = SELECT \
                                    APPLICATION_NO AS applicationNo, \
                                    W_CID AS spouseCidNo, \
                                    W_NAME AS spouseName, \
                                    W_DOB AS spouseApplicantDobBh, \
                                    W_GENDER AS spouseGender, \
                                    W_FATHERS_NAME AS spouseFathersName, \
                                    W_MOTHERS_NAME AS spouseMothersName, \
                                    W_THARM_NO AS spouseTharmNo, \
                                    W_HOUSE_NO AS spouseHouseNo, \
                                    W_DZONGKHAG_NAME AS spouseDzongkhagNameBh, \
                                    W_GEWOG_NAME AS spouseGewogNameBh, \
                                    W_VILLAGE_NAME AS spouseVillageNameBh, \
                                    W_NATIONALITY AS spouseNationality, \
                                    CENSUS_NO AS censusFormNo, \
                                    APPLICATION_NO_DZO AS applicationIdDzo, \
                                    JUDGEMENT_NO_DZO AS judgementNoDzo, \
                                    JUDGEMENT_DATE_DZO AS dateDzo, \
                                    LUNAR_DATE AS lunarDateDzo, \
                                    LAWYER AS lawyerDzo \
                                  FROM t_mc_wifes_details WHERE APPLICATION_NO = :applicationNo