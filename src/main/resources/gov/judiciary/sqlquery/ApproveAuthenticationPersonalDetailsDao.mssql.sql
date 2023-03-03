ApproveauthenticationPersonalDetailsDao.getAttachedFiles = SELECT D.Document_Id AS documentId \
                ,D.Application_Number  AS applicationNo \
                ,D.Document_Name AS documentName \
                ,D.Upload_URL AS uploadUrl FROM t_document_dtls D \
                WHERE D.Application_Number =:applicationNo

ApproveauthenticationPersonalDetailsDao.downloadFile = SELECT D.Document_Id AS documentId \
                ,D.Application_Number  AS applicationNo \
                ,D.Document_Name AS documentName \
                ,D.Upload_URL AS uploadUrl FROM t_document_dtls D \
                WHERE D.Document_Id =:documentId
