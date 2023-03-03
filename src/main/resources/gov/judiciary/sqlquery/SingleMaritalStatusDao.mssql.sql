ChargeCalculationDao.getDuplicateOrReplacementDocCharge = CALL USP_BCSEA_DOC_SINGLE_MARITAL_STATUS (:serviceId ,:indexNo ,:documentId)

ChargeCalculationDao.getEnglishLanProCharge = CALL USP_BCSEA_ENG_LAN_SINGLE_MARITAL_STATUS (:serviceId ,:cidNo)

ChargeCalculationDao.isValidCid = SELECT A.CID FROM t_application_details A WHERE A.CID =:cidNo LIMIT 1