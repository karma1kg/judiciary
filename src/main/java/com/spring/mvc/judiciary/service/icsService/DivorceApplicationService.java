package com.spring.mvc.judiciary.service.icsService;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.FileUploadDTO;
import com.spring.mvc.helper.FileUploadToExternalLocation;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dto.*;
import com.spring.mvc.judiciary.entity.FileAttachment;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.util.CommonNotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;

/*Created by kg on 08/08/2022.*/


@Service
public class DivorceApplicationService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonDao commonDao;

    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @Transactional(rollbackOn = Exception.class)
    public ResponseMessage saveDivorceApplication(HttpServletRequest request,
                                                              ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                              WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        Integer globalServiceTypeId = ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceTypeId();
        String applicationType = ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceCode();
        String applicationNo = commonService.generateApplicationNumber(globalServiceTypeId, applicationType);
        String applicationYear = currentYear.toString().substring(2, 4);
        applicantDetailDTO.setApplicationYear(applicationYear);
        applicantDetailDTO.setMarital_Status("3");
        spouseDetailsDTO.setMarital_Status_Id("3");
        applicationDetailDTO.setApplicationYear(applicationYear);
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicantDetailDTO.setApplicationNo(applicationNo);
        spouseDetailsDTO.setApplicationNo(applicationNo);
        applicationDetailDTO.setServiceSlNo(globalServiceTypeId);
        Integer courtId = applicationDetailDTO.getCourtId();
        String courtName = commonService.getCourtName(String.valueOf(courtId));
        String serviceName = ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceName();
        commonService.saveApplication(applicationDetailDTO,applicantDetailDTO,witnessDetailDTO,spouseDetailsDTO);
        Integer iterator = 0;
        for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
            MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
            if (attachedFile != null) {
                String attachedFileName = attachedFile.getOriginalFilename();
                String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                String fileName = attachedFileName;
                String propertiesFileName = "attachFile.properties";
                responseMessage = FileUploadToExternalLocation.fileUploader(attachedFile, fileName, propertiesFileName, request);
                if (responseMessage.getResponseStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return responseMessage;
                }
            }
        }

        for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
            MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
            if (attachedFile != null) {
                String attachedFileName = attachedFile.getOriginalFilename();
                String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                String fileName = attachedFileName;

                iterator = iterator + 1;
                FileUploadDTO fileUploadDTO = FileUploadToExternalLocation.fileUploadPathRetriever(request);
                String uploadedDirectory = fileUploadDTO.getUploadFilePath().concat(attachedFileName);
                fileAttachmentDTO.setUploadUrl(uploadedDirectory);
                fileAttachmentDTO.setApplicationNo(applicationNo);
                fileAttachmentDTO.setDocumentName(attachedFileName);
                FileAttachment fileAttachment = convertFileAttachmentEntToDTO(fileAttachmentDTO);
                commonDao.saveAttachFile(fileAttachment);
            }
        }
        //endregion

        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setCourtName(courtName);
        responseMessage.setServiceName(ServiceTypeEnum.DIVORCE_CERTIFICATE.getServiceName());
        responseMessage.setResponseText("Submitted successfully.");
        Boolean result = CommonNotificationUtils.notifyOnSubmission(applicationNo, courtName, applicantDetailDTO.getMobileNo());
        return responseMessage;
    }

    private FileAttachment convertFileAttachmentEntToDTO(FileAttachmentDTO fileAttachmentDTO) {
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setDocumentId(fileAttachmentDTO.getDocumentId());
        fileAttachment.setDocumentTypeId(fileAttachmentDTO.getDocumentTypeId());
        fileAttachment.setApplicationNo(fileAttachmentDTO.getApplicationNo());
        fileAttachment.setDocumentType(fileAttachmentDTO.getDocumentType());
        fileAttachment.setDocumentName(fileAttachmentDTO.getDocumentName());
        fileAttachment.setUploadUrl(fileAttachmentDTO.getUploadUrl());
        fileAttachment.setUuId(fileAttachmentDTO.getUuId());
        return fileAttachment;
    }
    @Transactional
    public BigInteger getCount(String curent_date, Integer courtId, Integer Service_Sl_NO) {
        return commonDao.getCount(curent_date,courtId,Service_Sl_NO);
    }

}
