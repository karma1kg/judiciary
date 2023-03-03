AffirmationMarriageCertificateDao.getDuplicateApplicationNo = SELECT A.APPLICATION_NO FROM t_application_details A \
                                                              INNER JOIN	t_applicant_dtls B ON A.APPLICATION_NO = B.APPLICATION_NO \
                                                              WHERE B.CID = :cidNo AND A.SERVICE_SL_NO = :globalServiceTypeId AND A.PRINT_STATUS ='N' LIMIT 1
