CommonDao.getAllCourt = SELECT C.COURT_ID AS valueInteger, C.COURT_NAME AS text FROM t_court_master C WHERE C.IS_ACTIVE ='Y'

CommonDao.getDzongkhagList = SELECT Dzongkhag_Serial_No AS valueInteger, Dzongkhag_Name AS text FROM t_dzongkhag_lookup

CommonDao.getGewogList = SELECT Gewog_Serial_No AS valueInteger, Gewog_Name AS text FROM t_gewog_lookup

CommonDao.getVillageList = SELECT Village_Serial_No AS valueInteger, Village_Name AS text FROM t_village_lookup

CommonDao.getGewogListName = SELECT Gewog_Serial_No AS valueInteger, Gewog_Name AS text FROM t_gewog_lookup WHERE Dzongkhag_Serial_No = :dzoId

CommonDao.getVillageListName = SELECT Village_Serial_No AS valueInteger, Village_Name AS text FROM t_village_lookup WHERE Gewog_Serial_No = :gewogId

CommonDao.getAllCourtOffline = SELECT C.COURT_ID AS valueInteger, C.COURT_NAME AS text FROM t_court_master C WHERE C.IS_ACTIVE ='Y' AND C.COURT_ID = :courtId

CommonDao.getAuthType = SELECT C.Id AS valueInteger, C.Type_Name AS text FROM t_authentication_type_master C WHERE C.IS_ACTIVE ='Y'

CommonDao.getAllCountry = SELECT C.Country_Id AS valueInteger, C.Country_Name AS text FROM t_country_master C WHERE C.status ='Y'

CommonDao.getRequiredDocumentList = SELECT RD.Service_Id AS valueInteger, RD.Documents_dtls AS text FROM t_requried_document_dtls RD WHERE RD.Service_Id = :Service_Id

CommonDao.getAllReligion = SELECT R.Religion_Id AS valueInteger, R.Religion_Desc AS text FROM t_religion_master R WHERE Is_Active ='Y'

CommonDao.getRelationshiptList = SELECT R.RELATIONSHIP_ID AS valueInteger, R.RELATIONSHIP_NAME AS text FROM t_relationship_master R

CommonDao.getCourtName = SELECT COURT_NAME FROM t_court_master WHERE IS_ACTIVE = 'Y' AND COURT_ID = :courtId \

CommonDao.getServiceName = SELECT SERVICE_ID AS valueInteger, SERVICE_NAME AS text FROM t_service_master WHERE IS_ACTIVE = 'Y'

CommonDao.getServiceNamePrint = SELECT SERVICE_ID AS valueInteger, SERVICE_NAME AS text FROM t_service_master WHERE IS_ACTIVE = 'Y' AND IS_PRINT = 'Y'


CommonDao.getDocumentId = SELECT Document_Id FROM t_document_dtls D ORDER BY D.Document_Id DESC LIMIT 1

CommonDao.documentList = SELECT D.document_id AS valueInteger, D.document_name AS text FROM t_document_type D

CommonDao.getApplicationSerial = SELECT RIGHT(A.APPLICATION_NO,5) FROM t_application_details A \
                  WHERE LEFT(A.APPLICATION_NO,3) =:globalServiceTypeId \
                  AND SUBSTR(A.APPLICATION_NO,5,2) =:applicationYear \
                  AND SUBSTR(A.APPLICATION_NO,7,2) =:applicationMonth \
                  AND SUBSTR(A.APPLICATION_NO,9,2) =:applicationDay \
                  AND SUBSTR(A.APPLICATION_NO,11,2) =:applicationType \
                  ORDER BY A.APPLICATION_NO DESC LIMIT 1


CommonDao.getChargeByDocumentId = SELECT C.CHARGE_AMOUNT FROM t_service_charge C \
                  WHERE (:documentId IS NULL OR C.DOCUMENT_ID =:documentId) AND C.SERVICE_SL_NO =:serviceId LIMIT 1

CommonDao.getWorkInstanceSerial = SELECT W.Workflow_instance_Id FROM t_workflow_dtls W ORDER BY W.Workflow_instance_Id DESC LIMIT 1

--CommonDao.getWorkInstanceSerial = SELECT CAST(RIGHT(W.Workflow_instance_Id,8) AS INT) FROM t_workflow_dtls W ORDER BY W.Workflow_instance_Id DESC LIMIT 1

CommonDao.getTaskInstanceSerial =  SELECT T.Task_instance_Id FROM t_task_dtls T ORDER BY T.Task_instance_Id DESC LIMIT 1

--CommonDao.getTaskInstanceSerial = SELECT CAST(RIGHT(T.Task_instance_Id,8) AS INT) FROM t_task_dtls T ORDER BY T.Task_instance_Id DESC LIMIT 1

CommonDao.getLastPaymentDetailId = SELECT D.PAYMENT_DETAIL_ID FROM t_app_payment_details D ORDER BY D.PAYMENT_DETAIL_ID DESC LIMIT 1

CommonDao.getApplicationDetail = SELECT DISTINCT \
                                a.APPLICATION_NO AS applicationNo, \
                                a.SERVICE_SL_NO AS serviceSlNo, \
                                a.LETTER_NO AS letterNo,  \
                                a.LETTER_DATE AS letterDate, \
                                a.INCORRECT_TYPE AS incorrectType, \
                                a.INCORRECT_NAME AS incorrectName, \
                                a.INCORRECT_DOB AS incorrectDate, \
                                a.INCORRECT_CID AS incorrectCidNo, \
                                a.INCORRECT_DZONGKHAG_ID AS incorrectDzongkhagName, \
                                a.INCORRECT_GEWOG_ID AS incorrectGewogName, \
                                a.INCORRECT_VILLAGE_ID AS incorrectVillageName, \
                                a.INCORRECT_OTHERS AS incorrectOthers, \
                                a.MC_NO AS mcNo, \
                                a.CMC_NO AS cmcNo, \
                                a.HOSPITAL_NAME AS hospitalName, \
                                a.RELATIONSHIP AS relationship, \
                                a.DOC_NAME AS docName, \
                                a.LOST_DOC_TYPE AS lostDocType, \
                                a.COURT_ID AS courtId,  \
                                a.DATE_OF_APPOINTMENT AS appoinmentDate, \
                                a.TIME_OF_APPOINTMENT AS appoinmentTime, \
                                a.STATUS_ID AS statusId, \
                                a.REASON AS reason, \
                                a.CREATED_BY AS createdBy, \
                                a.CREATED_DATE AS createdDate, \
                                a.CASE_NO caseNo, \
                                a.JUDGEMENT_NO AS judgementNo, \
                                a.JUDGEMENT_DATE AS judgementDate,  \
                                a.CLERK AS clerk, \
                                a.LAWYER AS lawyer, \
                                a.RECEIPT_NO AS receiptNo,\
                                a.RECEIPT_DATE AS receiptDate, \
                                a.RECEIPT_AMOUNT AS receiptAmount, \
                                a.UPDATE_BY AS updatedBy, \
                                a.PRINT_STATUS AS printStatus, \
                                a.PAYMENT_CLEARED AS paymentCleared, \
                                a.REMARKS AS remarks, \
                                a.EXAM_YEAR AS examYear, \
                                a.KUENSEL_DATE AS kuenselDate, \
                                a.INDEX_NO AS indexNo, \
                                a.CLASS_TYPE AS classType, \
                                a.TRAVEL_REASON AS travelReason, \
                                a.CHILD_PASSPORT_NO AS childPassportNo, \
                                a.APP_PASSPORT_NO AS appPassportNo, \
                                a.REG_NO AS regNo, \
                                a.KUENSEL_DATE AS regDate, \
                                a.IS_CHILD AS serviceName, \
                                a.applicationYear \
                                FROM \
                                t_application_details a \
                                WHERE a.APPLICATION_NO =:applicationNo

CommonDao.getApplicantDetail = SELECT \
                              a.APPLICATION_NO AS applicationNo, \
                              a.CID AS cidNo, \
                              a.NAME AS applicantName, \
                              DATE_FORMAT(a.DOB, '%d-%m-%Y') AS applicantDobBh, \
                              a.GENDER AS gender, \
                               a.applicationYear, \
                              a.MOBILE_NO AS mobileNo, \
                              a.EMAIL_ID AS email, \
                              a.FATHER_NAME AS fatherName, \
                              a.MOTHER_NAME AS motherName, \
                              a.THARM_NO AS tharmNo, \
                              b.Dzongkhag_Name_Bh AS dzongkhagNameBh , \
                              c.Gewog_Name_Bh AS gewogNameBh, \
                              d.Village_Name_Bh AS villageNameBh, \
                              ADDRESS AS address, \
                              e.Religion_Desc_Bh AS religion, \
                              a.NATIONALITY AS nationality, \
                               a.HOUSE_NO AS houseNo \
                              FROM \
                              t_applicant_dtls a \
                              LEFT JOIN t_dzongkhag_lookup b ON a.DZONGKHAG_ID = b.Dzongkhag_Id \
                              LEFT JOIN t_gewog_lookup c ON a.GEWOG_ID = c.Gewog_Serial_No \
                              LEFT JOIN t_village_lookup d ON a.VILLAGE_ID = d.Village_Serial_No \
                              LEFT JOIN t_religion_master e ON a.Religion = e.Religion_Id \
                              WHERE a.APPLICATION_NO =:applicationNo

CommonDao.getSpouseDetail = SELECT a.APPLICATION_NO AS applicationNo, \
a.NAME AS spouseName, \
a.CID AS spouseCidNo, \
a.SRP_No AS srpNo, \
DATE_FORMAT(a.DOB, '%d-%m-%Y') AS spouseApplicantDobBh, \
a.FATHERS_NAME AS spouseFathersName, \
a.MOTHERS_NAME AS spouseMothersName, \
a.GENDER AS spouseGender, \
a.THARM_NO AS spouseTharmNo, \
a.HOUSE_NO AS spouseHouseNo, \
b.Dzongkhag_Name_Bh AS spouseDzongkhagNameBh, \
c.Gewog_Name_Bh AS spouseGewogNameBh, \
d.Village_Name_Bh AS spouseVillageNameBh, \
a.NATIONALITY AS spouseNationality, \
e.Religion_Desc_Bh AS spouseReligionBh \
FROM t_spouse_dtls a \
LEFT JOIN t_village_lookup d ON a.VILLAGE_ID = d.Village_Serial_No \
LEFT JOIN t_gewog_lookup c ON d.Gewog_Serial_No =c.Gewog_Serial_No \
LEFT JOIN t_dzongkhag_lookup b ON c.Dzongkhag_Serial_No = b.Dzongkhag_Id  \
LEFT JOIN t_religion_master e ON a.Religion = e.Religion_Id \
WHERE a.APPLICATION_NO =  :applicationNo

CommonDao.getChildMCDetail = SELECT \
                            APPLICATION_NO AS applicationNo, \
                            NAME AS childName, \
                            DoB AS childDoB, \
                            GENDER AS childGender \
                          FROM \
                            t_child_details_mc \
                          WHERE APPLICATION_NO = :applicationNo

CommonDao.getChildTravelDetail = SELECT \
                                a.Name AS childName, \
                                a.DoB AS childDob, \
                                a.Gender AS childGender, \
                                a.Travel_Place AS travelPlace, \
                                a.A_Relationship AS relationship, \
                                a.Father_Cid AS orgFatherCid, \
                                a.Father_Name AS orgFatherName, \
                                a.Mother_Cid AS orgMotherCid, \
                                a.Mother_Name AS orgMotherName  \
                                FROM \
                                t_child_details a  \
                                WHERE a.Application_No =:applicationNo

CommonDao.getWitnessDetail = SELECT APPL_ID AS applicationNo, \
                            CID AS witness1CidNo, \
                            NAME AS witness1Name \
                            FROM t_witness_details \
                            WHERE WITHESS_TYPE_ID ='1' AND APPL_ID = :applicationNo

CommonDao.getWitnessDetail2 = SELECT APPL_ID AS applicationNo, \
                            CID AS witness2CidNo, \
                            NAME AS witness2Name \
                            FROM t_witness_details \
                            WHERE WITHESS_TYPE_ID ='2' AND APPL_ID = :applicationNo

CommonDao.getDonorDetail = SELECT \
                          CID AS donorCid, \
                          NAME AS donorName, \
                          GENDER AS donorGender, \
                          DONOR_DEP_RELATIONSHIP AS donorDepRelationship \
                          FROM \
                          t_donor_details \
                          WHERE APPL_ID = :applicationNo

CommonDao.getDonorDepDetail = SELECT \
                              CID AS donorDepCid, \
                              NAME AS donorDepName, \
                              GENDER AS donorDepGender, \
                              RELATIONSHIP AS depRelationship \
                              FROM \
                              t_dependent_table  \
                              WHERE APPL_ID = :applicationNo

CommonDao.getOrgFatherDetail = SELECT  Father_Cid AS orgFatherCid, Father_Name AS orgFatherName FROM  t_child_details WHERE Application_No = :applicationNo

CommonDao.getOrgMotherDetail = SELECT Mother_Cid AS orgMotherCid, Mother_Name AS orgMotherName FROM t_child_details WHERE Application_No = :applicationNo

CommonDao.getPatientDetail = SELECT \
                            CID AS patientCid, \
                            NAME AS patientName, \
                            GENDER AS patientGender, \
                            PATIENT_DONOR_RELATIONSHIP AS patientDonorRelationship \
                            FROM \
                            t_patient_details \
                            WHERE APPL_ID =:applicationNo

CommonDao.getTransferorDetail = SELECT \
                                a.CID AS transferorApplicantCid, \
                                a.NAME AS transferorApplicantName, \
                                a.GENDER AS transferorGender, \
                                a.DOB AS transferorApplicantDob, \
                                a.BANK_NAME AS bankName, \
                                a.ACCOUNT_NO AS accNo \
                                FROM \
                                t_transferor_details a \
                                WHERE a.APPLICATION_NO = :applicationNo

CommonDao.getDocumentDetails = SELECT \
                              a.Document_Id AS documentId, \
                              a.Document_Name AS documentName, \
                              a.Upload_URL AS uploadUrl \
                              FROM \
                              t_document_dtls a  \
                              WHERE  \
                              a.Application_Number= :applicationNo

CommonDao.getAttachedFiles = SELECT \
                              a.Document_Id AS documentId, \
                              a.Document_Name AS documentName, \
                              a.Upload_URL AS uploadUrl \
                              FROM \
                              t_document_dtls a  \
                              WHERE  \
                              a.Application_Number= :applicationNo

CommonDao.downloadFile = SELECT D.Document_Id AS documentId \
                        ,D.Application_Number  AS applicationNo \
                        ,D.Document_Name AS documentName \
                        ,D.Upload_URL AS uploadUrl FROM t_document_dtls D \
                        WHERE D.Document_Id =:documentId


CommonDao.getRejectReasons = SELECT R.REJECT_REASON_ID AS valueInteger, R.REASON AS text FROM t_reject_reasons R WHERE R.IS_ACTIVE ='Y'

CommonDao.getRejectReasonByRejectReasonId = SELECT R.REASON FROM t_reject_reasons R WHERE R.REJECT_REASON_ID =:rejectReasonId
CommonDao.getRejectReasonOthersById= SELECT R.REASON FROM t_reject_others R WHERE R.REJECT_REASON_ID =:rejectReasonId

CommonDao.getCourtId = SELECT Location_id AS courtId FROM t_user_details WHERE User_id = :username

CommonDao.updateAppoinmentDate = UPDATE t_application_details SET DATE_OF_APPOINTMENT = :appoinmentDate, TIME_OF_APPOINTMENT = :appoinmentTime WHERE APPLICATION_NO = :applicationNo

CommonDao.updatePaymentOnline = UPDATE \
                              t_application_details \
                            SET  \
                              RECEIPT_NO = :txnId , \
                              RECEIPT_DATE = :paymentDate, \
                              RECEIPT_AMOUNT = :txnAmount, \
                              PRINT_STATUS = 'O', \
                              PAYMENT_CLEARED = 'Y', \
                              STATUS_ID = '6' \
                            WHERE APPLICATION_NO =:applicationNo

CommonDao.updateWorkFlowPayment = UPDATE t_workflow_dtls SET Application_Status = '6' WHERE Application_Id =:applicationNo

CommonDao.updateTaskFlowPayment = UPDATE t_task_dtls SET Application_Status = '6' WHERE Application_Id =:applicationNo

CommonDao.getPaymentDetails = SELECT \
                            APPLICATION_FEE AS applicationFees, \
                            ACCOUNT_HEAD_CODE AS accountHeadCode, \
                            SERVICE_NAME AS serviceName \
                          FROM \
                            t_service_master  \
                          WHERE SERVICE_ID = :serviceId

CommonDao.getAgencyCode = SELECT AGENCY_CODE AS agencyCode FROM t_court_master WHERE COURT_ID = :courtId

CommonDao.checkForAlreadyExistApplicant = SELECT \
                                        COUNT(a.CID) AS indexNo \
                                      FROM \
                                        t_applicant_dtls a \
                                        LEFT JOIN t_application_details b \
                                          ON a.APPLICATION_NO = b.APPLICATION_NO \
                                      WHERE a.CID = :cidNo \
                                        AND b.SERVICE_SL_NO = :serviceId \
                                        AND (b.STATUS_ID = '1' \
                                        OR b.STATUS_ID = '2')

CommonDao.checkPreviousJudgementNo = SELECT COUNT(JUDGEMENT_NO) AS indexNo FROM t_application_details WHERE JUDGEMENT_NO = :judgementNo AND SERVICE_SL_NO = :serviceId AND COURT_ID = :courtId AND applicationYear= :applicationYear

CommonDao.checkPreviousRegistrationNo = SELECT COUNT(REG_NO) AS examYear FROM t_application_details WHERE REG_NO = :regNo AND SERVICE_SL_NO = :serviceId AND COURT_ID = :courtId AND applicationYear = :applicationYear

CommonDao.checkForAlreadyExistSpouse = SELECT \
                                        COUNT(a.CID) AS indexNo \
                                      FROM \
                                        t_spouse_dtls a \
                                        LEFT JOIN t_application_details b \
                                          ON a.APPLICATION_NO = b.APPLICATION_NO \
                                      WHERE a.CID = :cidNo \
                                        AND b.SERVICE_SL_NO = :serviceId \
                                        AND (b.STATUS_ID = '1' \
                                        OR b.STATUS_ID = '2')

CommonDao.checkForAlreadyMarriedApplicant=  SELECT \
                                        COUNT(a.CID) AS indexNo \
                                      FROM \
                                       t_applicant_dtls a \
                                        LEFT JOIN t_application_details b \
                                          ON a.APPLICATION_NO = b.APPLICATION_NO \
                                      WHERE a.CID = :cidNo \
                                        AND b.SERVICE_SL_NO = :serviceId \
                                        AND (b.STATUS_ID = '5')

CommonDao.get_cidDetails= SELECT \
  b.CID SpouseCid, \
  b.NAME SpouseName, \
  a.APPLICATION_NO applicationNo, \
  a.CID cidNo, \
  a.NAME applicantName, \
  c.STATUS_ID statusId, \
  c.SERVICE_SL_NO serviceSlNo, \
  c.JUDGEMENT_NO judgementNo \
FROM \
t_spouse_dtls b \
  LEFT JOIN t_applicant_dtls a \
 ON b.APPLICATION_NO = a.APPLICATION_NO \
LEFT JOIN t_application_details c \
ON b.APPLICATION_NO=c.APPLICATION_NO \
WHERE b.CID= :cidNo \
AND c.STATUS_ID='5' \
AND c.SERVICE_SL_NO= :serviceId

  CommonDao.getcidDetails= SELECT \
  a.APPLICATION_NO applicationNo, \
  a.CID cidNo, \
  a.NAME applicantName, \
  b.CID SpouseCid, \
  b.NAME SpouseName, \
  c.STATUS_ID statusId, \
  c.SERVICE_SL_NO serviceSlNo, \
  c.JUDGEMENT_NO judgementNo \
FROM \
  t_applicant_dtls a \
  LEFT JOIN t_spouse_dtls b \
 ON a.APPLICATION_NO = b.APPLICATION_NO \
LEFT JOIN t_application_details c \
ON a.APPLICATION_NO=c.APPLICATION_NO \
WHERE a.CID= :cidNo \
AND c.STATUS_ID='5' \
AND c.SERVICE_SL_NO= :serviceId


CommonDao.getJudgementNumber= SELECT \
  a.APPLICATION_NO applicationNo, \
  a.CID cidNo, \
  c.STATUS_ID statusId, \
  c.JUDGEMENT_NO judgementNo \
FROM \
  t_applicant_dtls a \
LEFT JOIN t_application_details c \
ON a.APPLICATION_NO=c.APPLICATION_NO \
WHERE a.CID= :cidNo \
AND c.JUDGEMENT_NO= :judgementNo \
AND c.STATUS_ID='5'

CommonDao.checkForAlreadyMarriedSpouse= SELECT \
                                        COUNT(a.CID) AS indexNo \
                                      FROM \
                                        t_spouse_dtls a \
                                        LEFT JOIN t_application_details b \
                                          ON a.APPLICATION_NO = b.APPLICATION_NO \
                                      WHERE a.CID = :cidNo \
                                        AND b.SERVICE_SL_NO = :serviceId \
                                        AND (b.STATUS_ID = '5')

CommonDao.getServiceNameCheck = SELECT SERVICE_ID AS valueInteger, \
                                SERVICE_NAME AS text \
                                FROM t_service_master \
                                WHERE SERVICE_ID = :serviceId

CommonDao.checkForAlreadyAssigned = SELECT \
                                    COUNT(*) AS indexNo \
                                  FROM \
                                    t_application_details a \
                                  WHERE a.DATE_OF_APPOINTMENT = :appoinmentDate \
                                    AND a.TIME_OF_APPOINTMENT = :appoinmentTime

CommonDao.getApplicationCount =  SELECT \
                                COUNT(a.APPLICATION_NO) AS documentId \
                              FROM \
                                t_application_details a \
                              WHERE a.SERVICE_SL_NO = :serviceId \
                                AND a.COURT_ID = :courtId \
                                AND a.STATUS_ID =1

CommonDao.getApplicationCountVerified =  SELECT \
                                COUNT(a.APPLICATION_NO) AS documentId \
                              FROM \
                                t_application_details a \
                              WHERE a.SERVICE_SL_NO = :serviceId \
                                AND a.COURT_ID = :courtId \
                                AND a.STATUS_ID =6

CommonDao.getCourtPhoneNo = SELECT CONTACT_NO AS phoneNo FROM t_court_master WHERE COURT_ID = :courtId

CommonDao.getGroupTaskSubmitted = SELECT COUNT(a.APPLICATION_NO) AS groupTaskCount FROM t_application_details a WHERE a.COURT_ID = :courtId AND a.STATUS_ID =1

CommonDao.getMyTaskSubmitted = SELECT COUNT(a.APPLICATION_NO) AS myTaskCount FROM t_application_details a WHERE a.COURT_ID = :courtId AND a.STATUS_ID =2

CommonDao.getGroupTaskVerified = SELECT COUNT(a.APPLICATION_NO) AS groupTaskCount FROM t_application_details a WHERE a.COURT_ID = :courtId AND a.STATUS_ID =6

CommonDao.getMyTaskVerified = SELECT COUNT(a.APPLICATION_NO) AS myTaskCount FROM t_application_details a WHERE a.COURT_ID = :courtId AND a.STATUS_ID =7

CommonDao.getUpdatePaymentCount = SELECT COUNT(a.APPLICATION_NO) AS lostDocType FROM t_application_details a WHERE a.COURT_ID = :courtId AND a.STATUS_ID =3

CommonDao.getCount=SELECT COUNT(*) FROM t_application_details t WHERE t.CREATED_DATE=? AND t.COURT_ID=? AND t.SERVICE_SL_NO=?
--DATE_FORMAT(t.CREATED_DATE,"%Y-%m-%d")=? SELECT COUNT(*) FROM t_application_details t WHERE t.CREATED_DATE=? AND t.COURT_ID=?
CommonDao.getRejectOthers=SELECT R.REJECT_REASON_ID AS valueInteger, R.REASON AS text FROM t_reject_others R WHERE R.IS_ACTIVE ='Y'

CommonDao.getRejectAttest=SELECT R.REJECT_REASON_ID AS valueInteger, R.REASON AS text FROM t_rejectattestation R WHERE R.IS_ACTIVE ='Y'

CommonDao.getDivorceDetails= SELECT \
    a.NAME AS applicantName, \
  a.CID AS cidNo, \
  a.applicationYear AS applicationYear, \
  b.CID AS SpouseCid, \
  b.NAME AS SpouseName, \
  a.GENDER AS gender, \
  b.GENDER AS spouseGender, \
  a.applicant AS applicant \
FROM \
  t_applicant_dtls a \
  LEFT JOIN t_spouse_dtls b \
  ON a.APPLICATION_NO=b.APPLICATION_NO \
  WHERE a.marital_Status='2' AND (a.CID= :cidNo OR b.CID= :scidNo) AND a.applicant='YES'

CommonDao.getApplicantName= SELECT a.CID, a.APPLICATION_NO, a.NAME FROM t_applicant_dtls a \
LEFT JOIN t_spouse_dtls b \
ON a.APPLICATION_NO=b.APPLICATION_NO

CommonDao.getDivorceDetailsWithSpouse= SELECT \
    b.NAME AS applicantName, \
  b.CID AS cidNo, \
  b.applicationYear AS applicationYear, \
  a.CID AS SpouseCid, \
  a.NAME AS SpouseName, \
  b.GENDER AS gender, \
  a.GENDER AS spouseGender, \
  b.applicant AS applicant \
FROM \
  t_spouse_dtls a \
  LEFT JOIN t_applicant_dtls b \
  ON a.APPLICATION_NO=b.APPLICATION_NO \
  WHERE b.marital_Status='2' AND (b.CID= :cidNo OR a.CID= :scidNo) AND b.applicant='YES'

CommonDao.getCountMc= SELECT COUNT(*) FROM t_applicant_dtls a \
LEFT JOIN t_application_details b \
ON a.APPLICATION_NO=b.APPLICATION_NO \
 WHERE a.CID=a.CID AND a.CID=? AND b.SERVICE_SL_NO=? \
 AND b.STATUS_ID=? GROUP BY a.CID


CommonDao.getMCStatus=SELECT a.STATUS_ID FROM t_application_details a \
LEFT JOIN t_applicant_dtls b \
ON a.APPLICATION_NO=b.APPLICATION_NO  \
WHERE b.CID=? LIMIT 1

CommonDao.getDivorceStatus= SELECT a.APPLICATION_NO AS applicationNo,b.CREATED_DATE AS createdDate FROM t_applicant_dtls a \
LEFT JOIN t_application_details b \
ON a.APPLICATION_NO=b.APPLICATION_NO \
 WHERE a.CID=? AND a.Marital_Status='3' AND b.SERVICE_SL_NO=? ORDER BY a.APPLICATION_NO DESC

CommonDao.getMaritalStatusDivorced= SELECT \
a.Marital_Status AS marital_Status \
                                      FROM \
                                       t_applicant_dtls a \
                                        LEFT JOIN t_application_details b \
                                          ON a.APPLICATION_NO = b.APPLICATION_NO \
                                      WHERE a.CID =? \
                                        AND b.SERVICE_SL_NO =? \
                                        AND (b.STATUS_ID = '5') \
                                        AND a.Marital_Status='3'

CommonDao.getMcData= SELECT a.APPLICATION_NO AS applicationNo,b.CREATED_DATE AS createdDate, \
a.Marital_Status AS marital_status FROM t_applicant_dtls a \
LEFT JOIN t_application_details b \
ON a.APPLICATION_NO=b.APPLICATION_NO \
 WHERE a.CID=? AND a.Marital_Status='3' AND b.SERVICE_SL_NO='513' ORDER BY a.APPLICATION_NO DESC