package com.spring.mvc.judiciary.service.openService;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;

@Service
public class AffirmationMarriageCertificateService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonDao commonDao;

    Calendar calendar = Calendar.getInstance();

    Integer currentYear = Integer.valueOf(this.calendar.get(1));

    @Transactional(rollbackFor = {Exception.class})
    public ResponseMessage saveAffirmationMarriageCertificate(HttpServletRequest request, ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            Integer globalServiceTypeId = ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceTypeId();
            String applicationType = ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceCode();
            String applicationNo = this.commonService.generateApplicationNumber(globalServiceTypeId, applicationType);
            String applicationYear = this.currentYear.toString().substring(2, 4);
            applicantDetailDTO.setApplicationYear(applicationYear);
            applicationDetailDTO.setApplicationYear(applicationYear);
            applicationDetailDTO.setApplicationNo(applicationNo);
            applicantDetailDTO.setApplicationNo(applicationNo);
            spouseDetailsDTO.setApplicationNo(applicationNo);
            applicantDetailDTO.setMarital_Status("2");
            spouseDetailsDTO.setMarital_Status_Id("2");
            applicationDetailDTO.setServiceSlNo(globalServiceTypeId);
            Integer courtId = applicationDetailDTO.getCourtId();
            String courtName = this.commonService.getCourtName(Integer.toString(courtId.intValue()));
            String serviceName = ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceName();
            this.commonService.saveApplication(applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);
            Integer iterator = Integer.valueOf(0);
            for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
                MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
                if (attachedFile != null) {
                    String attachedFileName = attachedFile.getOriginalFilename();
                    String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                    String fileName = attachedFileName;
                    String propertiesFileName = "attachFile.properties";
                    responseMessage = FileUploadToExternalLocation.fileUploader(attachedFile, fileName, propertiesFileName, request);
                    if (responseMessage.getResponseStatus().intValue() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
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
                    iterator = Integer.valueOf(iterator.intValue() + 1);
                    FileUploadDTO fileUploadDTO = FileUploadToExternalLocation.fileUploadPathRetriever(request);
                    String uploadedDirectory = fileUploadDTO.getUploadFilePath().concat(attachedFileName);
                    fileAttachmentDTO.setUploadUrl(uploadedDirectory);
                    fileAttachmentDTO.setApplicationNo(applicationNo);
                    fileAttachmentDTO.setDocumentName(attachedFileName);
                    FileAttachment fileAttachment = convertFileAttachmentEntToDTO(fileAttachmentDTO);
                    this.commonDao.saveAttachFile(fileAttachment);
                }
            }
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
            responseMessage.setApplicationNumber(applicationNo);
            responseMessage.setCourtName(courtName);
            responseMessage.setServiceName(ServiceTypeEnum.AFFIRMATION_MARRIAGE_CERTIFICATE.getServiceName());
            responseMessage.setResponseText("Submitted successfully.");
            Boolean result = Boolean.valueOf(CommonNotificationUtils.notifyOnSubmission(applicationNo, courtName, applicantDetailDTO.getMobileNo()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
        return this.commonDao.getCount(curent_date, courtId, Service_Sl_NO);
    }
}